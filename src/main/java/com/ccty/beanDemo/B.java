package com.ccty.beanDemo;

import org.omg.CORBA.PUBLIC_MEMBER;

public class B extends A{

    public  static String a;
    public int i;


    public B() {
        super();
    }

    public static void bbb(){
        System.out.println("hhhhhh");
    }

    public static void main(String[] args) {
        B b = new B();
        B.bbb();
        A.bbb();


        b.aaa();
        System.out.println(b.a);

         Integer ii = null;
         String ss = null;
        System.out.println(ii);
        System.out.println(b.i);
        System.out.println(ss);

        String s1 = "aaa";
        String s2 = new String("aaa");
        String s3 = "aaa";
        String s4 = new String("aaa");

        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s4);







    }


}
