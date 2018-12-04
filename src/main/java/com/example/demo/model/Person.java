package com.example.demo.model;

import com.example.demo.common.Update;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Package : com.example.demo.model
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/9/19 13:45 星期三
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Person implements Serializable, Comparable<Person> {


    @NotNull(message = "id不能为空", groups = {Update.class})
    @Min(value = 1, message = "id最小值不能为0", groups = {Update.class})
    private long personId;

    @NotEmpty(message = "不能为空", groups = {Update.class})
    private String name;
    private String sex;
    private int age;

    public Person() {
    }

    public Person(long personId, String name, String sex, int age) {
        this.personId = personId;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        }
        return -1;
    }
}
