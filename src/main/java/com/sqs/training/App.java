package com.sqs.training;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DemoPrint cls = new DemoPrint(1,2);


        cls.add();
        cls.subtract();

        cls.show("John");

        cls.show(9800);

        cls = null;


        System.out.println( "Hello World!" + "Screw the world!" );
    }
}
