package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Observer1 o = new Observer1();
        Subscribable.INSTANCE().register(o);
        Subscribable.INSTANCE().post(Type.TYPE1);
        Subscribable.INSTANCE().post(Type.TYPE2);
        Subscribable.INSTANCE().post(Type.TYPE3);
        Subscribable.INSTANCE().post(Type.TYPE4);
    }
}
