package com.ccty.beanDemo;

public class C {

    public String c;
    public static String ccc;

    public static void outMethod1( int iii){

    }


    //局部内部类  方法内部类
    public void outMethod( int iii){
        int a =10;
        class Inner{
            void innerMethod(){
                System.out.println(a);
            }
        }

        Inner inner = new Inner();
        inner.innerMethod();
    }

    void da(final int s){
        //匿名内部类
        new D(){
            public int dd(int d) {
                System.out.println(s);
                return 0;
            }

        }.dd(123456);
    }
    //静态内部类
    public  static class JT{
        void dasdadasd(){

            System.out.println(ccc);
//            System.out.println(c);
            outMethod1(2323);

            C c = new C();
            c.outMethod(222);
//            outMethod(111);
        }
    }
    //普通内部类  成员内部类
    public  class dasDFGDFGd{

        void dasdadaSDFSDsd(){
            outMethod1(2323);
            outMethod(111);
        }
    }


    public static void main(String[] args) {


        C c = new C();
        c.outMethod(111111);
        c.da(2334);

        JT jt = new C.JT();
        jt.dasdadasd();

        D d = new D() {
            public int aaa;
            @Override
            public int dd( int d) {
                System.out.println(aaa);
                return d;
            }
        };

        System.out.println(d.dd(11));
    }

    private void test( int i){
        new D(){
            public int dd(int d){
                for(int j =0; j < i; j++){
                    System.out.println("匿名内部类");
                }
                return d;
            }
        }.dd(222);
    }

    public void display(final String name,String age){
        class InnerClass{
            void display(){
                System.out.println(name);
            }
        }
    }

}
