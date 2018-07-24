package com.sqs.training;

public class DemoPrint {

    Integer value1;
    Integer value2;


    public DemoPrint(int val1, int val2){
        System.out.println("in constructor");
        value1 = val1;
        value2 = val2;

    }

    public void add(){
        System.out.println("Add: " + (value1 + value2));

    }

    public void subtract(){
        System.out.println("Subtract: " + (value1 - value2));

    }
    public void show(String msg) {

        System.out.println("Msg:" +msg);

    }

    public void show(int msg) {

        System.out.println("Msg:" +msg);

    }
}
