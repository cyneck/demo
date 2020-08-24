package com.example.demo.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: 多线程池 </p>
 * 现给定处理器个数m ，作业数n.每个作业的处理时间分别为 t1………tn,
 * 当n大于m时，首先处理时间短的m个作业进入处理器处理，其他的进入等待，
 * 当某个作业处理完成时，依次从等待队列中取处理时间最短的作业进入处理。
 * 求系统处理完所有作业的耗时为多少？ 不考虑作业切换的消耗。
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/24 18:06
 **/
public class MultiThreadPool extends Thread {

    private static volatile int seq = 0; //线程序号

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>(); //任务队列

    private final static List<Worker> THREAD_COLLECTION = new ArrayList<>();   //线程集合

    private int size; //当前线程数量

    private int min;  //最小线程数量

    private int corePoolSize; //核心线程数量

    private int max;  //最大线程数量

    private final int queueSize;  // 任务队列大小

    private final DiscardPolicy discardPolicy;

    private volatile boolean destroy = false;

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    public MultiThreadPool() {
        this(2, 4, 6, 10, () -> {
            throw new DiscardException("Discard This Runnable.");
        });
    }


    public MultiThreadPool(int min, int corePoolSize, int max, int queueSize, DiscardPolicy discardPolicy) {
        this.min = min;
        this.corePoolSize = corePoolSize;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    /**
     * 根据初始化参数，初始化最低数量要求的线程
     */
    private void init() {
        for (int i = 0; i < this.min; i++) {
            createWorker();
        }
        this.size = min;
        this.start();
    }

    //提交任务
    public void submit(Runnable runnable) {
        if (destroy) {
            throw new IllegalStateException("The thread pool already destroy and not allow submit task.");
        }
        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() > queueSize)
                //超过队列大小的任务，直接跑出异常
                discardPolicy.discard();
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private void createWorker() {
        Worker worker = new Worker(GROUP, "THREAD_POOL-" + (++seq));
        worker.start();
        THREAD_COLLECTION.add(worker);
    }

    @Override
    public void run() {
        while (!destroy) {
            System.out.printf("Pool#Min:%d,corePoolSize:%d,Max:%d,Current:%d,QueueSize:%d\n",
                    this.min, this.corePoolSize, this.max, this.size, TASK_QUEUE.size());
            try {
                //当任务队列中的任务个数过多时，增加线程数
                Thread.sleep(5_000L);
                if (TASK_QUEUE.size() > corePoolSize && size < corePoolSize) {
                    for (int i = size; i < corePoolSize; i++) {
                        createWorker();
                    }
                    System.out.println("The pool has incremented to corePoolSize.");
                    size = corePoolSize;
                } else if (TASK_QUEUE.size() > max && size < max) {
                    for (int i = size; i < max; i++) {
                        createWorker();
                    }
                    System.out.println("The pool has incremented to max.");
                    size = max;
                }
                //任务队列为空，将超过核心线程数量的线程关闭
                synchronized (THREAD_COLLECTION) {
                    if (TASK_QUEUE.isEmpty() && size > corePoolSize) {
                        System.out.println("=========Reduce========");
                        int releaseSize = size - corePoolSize;
                        for (Iterator<Worker> it = THREAD_COLLECTION.iterator(); it.hasNext(); ) {
                            if (releaseSize <= 0)
                                break;
                            Worker worker = it.next();
                            if (worker.getTaskState() == TaskState.BLOCKED) {
                                worker.close();
                                worker.interrupt();
                                releaseSize--;
                            }
                            it.remove();
                        }
                        size = corePoolSize;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //线程的包装类
    private static class Worker extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        public Worker(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskState() {
            return this.taskState;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Closed.");
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }

                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

    //自定义状态
    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    //拒绝策略抛出异常
    public static class DiscardException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public DiscardException(String message) {
            super(message);
        }
    }

    //拒绝策略
    public interface DiscardPolicy {

        void discard() throws DiscardException;
    }

    /**
     * 关闭线程池
     *
     * @throws InterruptedException
     */
    public void shutdown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty()) { //任务队列不为空，继续等待
            Thread.sleep(50);
        }
        synchronized (THREAD_COLLECTION) {
            int initVal = THREAD_COLLECTION.size();
            while (initVal > 0) {
                for (Worker worker : THREAD_COLLECTION) {
                    if (worker.getTaskState() == TaskState.BLOCKED) { //如果是blocked状态，直接关闭
                        worker.close();
                        worker.interrupt();
                        initVal--;
                    } else {   //其他状态，就等待10毫秒
                        Thread.sleep(10);
                    }
                }
            }
        }
        this.destroy = true;
        System.out.println("The thread pool is shutdown");
    }

    /**
     * 主函数入口
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MultiThreadPool threadPool = new MultiThreadPool();
        for (int i = 1; i <= 40; i++) {
            threadPool.submit(new MyRunnable(i));
        }

        Thread.sleep(40000);
        threadPool.shutdown();
    }

    /**
     * 我的线程类
     */
    public static class MyRunnable implements Runnable {
        int index;

        public MyRunnable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("The runnable " + index + " be serviced by " + Thread.currentThread() + " start.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The runnable " + index + " be serviced by " + Thread.currentThread() + " finished.");
        }

    }
}
