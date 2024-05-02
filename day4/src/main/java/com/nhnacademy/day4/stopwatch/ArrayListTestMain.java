package com.nhnacademy.day4.stopwatch;

public class ArrayListTestMain {
    public static void main(String[] args) {
//        ArrayListTest arrayListTest = new ArrayListTest();
//        arrayListTest.test();

        LinkedListTest linkedListTest = new LinkedListTest();
//        linkedListTest.test();
        ArrayListTestProxy arrayListTestProxy = new ArrayListTestProxy(linkedListTest);
        arrayListTestProxy.test();
    }
}