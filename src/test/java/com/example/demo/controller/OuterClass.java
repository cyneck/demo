package com.example.demo.controller;

/**
 * <p>Description:  </p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/28 18:12
 **/
public class OuterClass {
    //    private static float f = 1.0f;
    private float f = 1.0f;

    public String name = "test";
    private static int age = 20;

//    class InnerClass {
//        public static float func() {
//            return f;
//        }
//    }

//    abstract class InnerClass {
//        public abstract float func() {
//        }
//    }

//    static class InnerClass {
//        protected static float func() {
//            return f;
//        }
//    }

//    public class InnerClass {
//        static float func() {
//            return f;
//        }
//    }

    /**
     * 静态内部类和非静态内部类之间存在一个最大的区别，非静态内部类在编译完成之后会隐含的保存着一个引用
     * 静态内部类的创建不需要依赖外部类可以直接创建。可以 new OuterClass.Inner()
     */
    static class Inner {

        private String name;

        public void fun() {
            //静态内部类不可以使用任何外部类的非static类（包括属性和方法），但可以存在自己的成员变量
            System.out.println(name);
            System.out.println(age);
        }
    }


}
