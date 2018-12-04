package com.example.demo.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Package : com.example.demo.common
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/9 09:24 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class MyUpdate {
    private Class<? extends Object> myClass;
    private Object object;
    private String[] memberArray;// 类变量
    private Object[] resultArray;// get结果
    private int length;// 变量个数
    private String className;

    public MyUpdate(Object object) {
        this.myClass = object.getClass();
        this.object = object;

        try {
            myInit();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void myInit() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {
        // 成员变量
        Field[] declaredFields = myClass.getDeclaredFields();

        length = declaredFields.length;

        memberArray = new String[length];

        resultArray = new Object[length];

        for (int i = 0; i < length; i++) {
            String name = declaredFields[i].getName();

            memberArray[i] = name;

            // 得到get方法的结果
            resultArray[i] = myClass.getMethod("get" + (char) (name.charAt(0) - 32) + name.substring(1)).invoke(object);
        }

        String[] split = myClass.getName().split("\\.");

        className = split[split.length - 1];
    }

    // 拼接sql语句
    public String getSql() {

        String sql = "update " + className + " set " + memberArray[1];

        for (int i = 2; i < length; i++) {
            sql += "=? ," + memberArray[i];
        }

        sql += "=? where " + memberArray[0] + "=?";

        return sql;
    }

    public Object[] getResultArray() {
        return resultArray;
    }

    public int getLength() {
        return length;
    }

}
