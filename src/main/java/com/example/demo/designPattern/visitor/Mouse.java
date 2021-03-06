package com.example.demo.designPattern.visitor;

/**
 * Package : com.example.demo.designPattern.visitor
 * Description : TODO
 * Create on : 2019/1/9 14:10 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Mouse  implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
