假设有一个问题，我们需要创建一个学生对象，属性有name,number,class,sex,age,school等属性，如果每一个属性都可以为空，也就是说我们可以只用一个name,也可以用一个school,name,或者一个class,number，或者其他任意的赋值来创建一个学生对象，这时该怎么构造？

　　难道我们写6个1个输入的构造函数，15个2个输入的构造函数.......吗？这个时候就需要用到Builder模式了。给个例子，大家肯定一看就懂：