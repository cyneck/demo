package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;


/**
 * Package : com.example.demo.controller
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/9/19 13:53 星期三
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
public class HomeTest {

    @Test
    public void test() {
        Assert.assertTrue(true);
    }

//    @Autowired
//    private PersonService personService;

//    @Test
//    public void index() {
//
//        Person person = new Person(1, "lxl", "man", 18);
//        personService.update(person);
//
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person(1, "张三", "man", 18));
//        personList.add(new Person(2, "张四", "woman", 20));
//        personList.add(new Person(3, "张五", "woman", 26));
//        personList.add(new Person(4, "张六", "man", 22));
//        personList.add(new Person(4, "张七", "woman", 22));
//        Collections.sort(personList);
////        personList.sort(Comparator.reverseOrder());
//        /*迭代器过滤*/
//        Iterator<Person> personIterator = personList.iterator();
//        while (personIterator.hasNext()) {
//            if ("WOMAN".equalsIgnoreCase(personIterator.next().getSex())) {
//                personIterator.remove();
//            }
//        }
//        String[] arrayA = new String[]{"A", "B", "C", "D", "E", "F"};
//        String[] arrayB = new String[]{"B", "D", "F", "G", "H", "K"};
//        List listA = Arrays.asList(arrayA);
//        List listB = Arrays.asList(arrayB);
//        /*取并集*/
//        List ppp = (List<Person>) CollectionUtils.select(personList, new Predicate() {
//            @Override
//            public boolean evaluate(Object arg) {
//                Person argPerson = (Person) arg;
//                return "man".equals(argPerson.getSex());
//            }
//        });
//        String a = ArrayUtils.toString(CollectionUtils.union(listA, listB));
//        String b = ArrayUtils.toString(CollectionUtils.intersection(listA, listB));
//        String c = ArrayUtils.toString(CollectionUtils.subtract(listA, listB));
//        String d = ArrayUtils.toString(CollectionUtils.collate(listA, listB));
//        //Original String
//        String string = "hello world";
//        byte[] bytes = string.getBytes();
//        String s = new String(bytes);
//        System.out.println(personIterator);
//    }


}
