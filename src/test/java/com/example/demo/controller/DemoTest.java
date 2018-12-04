package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

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
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class DemoTest {
    @Test
    public void test() {
        String[] arrayA = new String[]{"A", "B", "C", "D", "E", "F"};
        String[] arrayB = new String[]{"B", "D", "F", "G", "H", "K"};
        List<String> listA = Arrays.asList(arrayA);
        List listB = Arrays.asList(arrayB);
        boolean contains = listA.contains("A");
    }
}
