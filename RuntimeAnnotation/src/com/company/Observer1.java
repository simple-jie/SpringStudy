package com.company;

public class Observer1 {

    @MySubscribe
    public void test(Type type) {
        System.out.println("Observer1 test " + type.name());
    }

    @MySubscribe({Type.TYPE2, Type.TYPE3})
    public void test2(Type type) {
        System.out.println("Observer1 test2 " + type.name());
    }
}
