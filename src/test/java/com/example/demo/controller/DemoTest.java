package com.example.demo.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Package : com.example.demo.controller
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/24 15:43 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
////由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
public class DemoTest {
    @Test
    public void test() {
        String[] arrayB = new String[]{"B", "D", "F", "G", "H", "K"};
        List<String> listA = Arrays.asList("B", "C", "A", "F", "D", "E");
        List listB = Arrays.asList(arrayB);
        boolean contains = listA.contains("A");

        TreeSet treeSetSorted = new TreeSet(listA);//二叉树排序

        TreeSet treeSet = new TreeSet();
        treeSet.add("B");
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("D");
        Assert.assertTrue("A", treeSet.first().equals("A"));

    }
}
