package com.example.demo.designPattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Package : com.example.demo.designPattern.builderPattern
 * Description : TODO
 * Create on : 2019/1/9 12:45 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Meal {
    private List<Item> items = new ArrayList<Item>();//食物和包装的列表

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
