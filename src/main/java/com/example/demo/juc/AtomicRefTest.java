package com.example.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Eric Lee(3958)
 * @Package : com.example.demo.juc
 * @Description : TODO
 * @Create on : 2019/9/9 20:55
 **/
public class AtomicRefTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicReference<Integer> atomRef = new AtomicReference<>(new Integer(1000));

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Task(atomRef), "Thread-" + i);
            list.add(thread);
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }

        System.out.println("show atom:"+atomRef.get());    // 打印2000
    }

}

class Task implements Runnable {
    private AtomicReference<Integer> atomRef;

    Task(AtomicReference<Integer> atomRef) {
        this.atomRef = atomRef;
    }

    @Override
    public void run() {
        while (true) {    //自旋操作
            Integer oldV = atomRef.get();
            if (atomRef.compareAndSet(oldV, oldV + 1))  // CAS操作
                break;
        }
    }
}