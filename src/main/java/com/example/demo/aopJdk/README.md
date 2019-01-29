AspectJ 实现 AOP 效果
AOP 实现的关键就在于 AOP 框架自动创建的 AOP 代理，AOP 代理则可分为静态代理和动态代理两大类:

静态代理是指使用 AOP 框架提供的命令进行编译，从而在编译阶段通过AOP框架指令生成 AOP 代理类，因此也称为编译时增强；还有一种静态代理是编写代码实现不用工具；这种方式一般是代理模式会使用。

动态代理则在运行时借助于 JDK 动态代理、CGLIB 等在内存中“临时”生成 AOP 动态代理类，因此也被称为运行时增强。

基于 AspectJ 的编译时增强进行 AOP POM 依赖
原生 AspectJ 不依赖Spring案例, 基于 AspectJ 的编译时增强进行 AOP 它是在编译期修改字节码，增强功能；并不会生成新的代理类字节码。