package com.bxp.test;

public class Base {
    private String name = "base";
    public Base(){
        super();
        //位置1：name初始化
        this.callName();
    }
    public void callName() {
        System.out.println(name);
    }
    public static void main(String[] args) {
        Base b = new Sub();
    }
    static class Sub extends Base{
        private String name = "sub";
        public Sub(){
            super();
            //位置2：name初始化
        }
        public void callName() {
            System.out.println(name);
        }
    }
}

