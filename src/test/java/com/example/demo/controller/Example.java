package com.example.demo.controller;

/**
 * <p>Description: string练习</p>
 * 成员变量和局部变量的区别
 * 1、成员变量是独立于方法外的变量，局部变量是类的方法中的变量
 *      1）成员变量：包括实例变量和类变量，用static修饰的是类变量，不用static修饰的是实例变量，所有类的成员变量可以通过this来引用。
 *      2）局部变量：包括形参，方法局部变量，代码块局部变量，存在于方法的参数列表和方法定义中以及代码块中。
 * 2、成员变量可以被public，protect，private，static等修饰符修饰，而局部变量不能被控制修饰符及 static修饰；两者都可以定义成final型。
 * 3、成员变量存储在堆，局部变量存储在栈。局部变量的作用域仅限于定义它的方法，在该方法的外部无法访问它。成员变量的作用域在整个类内部都是可见的，所有成员方法都可以使用它。如果访问权限允许，还可以在类的外部使用成员变量。
 * 4、局部变量的生存周期与方法的执行期相同。当方法执行到定义局部变量的语句时，局部变量被创建；执行到它所在的作用域的最后一条语句时，局部变量被销毁。类的成员变量，如果是实例成员变量，它和对象的生存期相同。而静态成员变量的生存期是整个程序运行期。
 * 5、成员变量在累加载或实例被创建时，系统自动分配内存空间，并在分配空间后自动为成员变量指定初始化值，初始化值为默认值，基本类型的默认值为0，复合类型的默认值为null。（被final修饰且没有static的必须显式赋值），局部变量在定义后必须经过显式初始化后才能使用，系统不会为局部变量执行初始化。
 * 6、局部变量可以和成员变量 同名，且在使用时，局部变量具有更高的优先级，直接使用同名访问，访问的是局部变量，如需要访问成员变量可以用this.变量名访问
 * 本例中i为成员变量，有默认的初始值，如果定义在方法内部，就没有初始值
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/27 21:23
 **/
public class Example {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    static int i;

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
        System.out.println(new Example().str);
        System.out.println(i);
    }

    public void change(String str, char ch[]) {
//        this.str = "test ok";
        str = "test ok";//没有修改string引用
        ch[0] = 'g';
    }
}
