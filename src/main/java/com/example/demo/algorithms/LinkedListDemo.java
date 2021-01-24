package com.example.demo.algorithms;


public class LinkedListDemo {


    public static void main(String[] args) {

        LinkedList<String> data = new LinkedList<String>();
        data.add("1");
        data.add("2");
        data.add("3");

        LinkedList<String> data2 = new LinkedList<String>();
        data2.add("a");
        data2.add("b");
        data2.add("c");

        data2.addList(data);


    }


    public static class LinkedList<T> {

        private int size;
        private Node first;
        private Node last;


        public LinkedList() {
        }

        public void add(T node) {
            Node newNode = new Node(node);
            if (null == first) {
                first = newNode;
                last = newNode;
            } else {
                newNode.pre = last;
                last.next = newNode;
                last = newNode;
            }
            size++;
        }

        public void addList(LinkedList<T> list) {
            list.first.pre = last;
            last.next = list.first;
            size += list.size;
        }

    }

    public static class Node {
        private Object data;
        private Node pre;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }


}
