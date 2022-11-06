package com.LuthfiMisbachulMunirJSleepFN;

public class ThreadingObject extends Thread {

    public ThreadingObject(String threadName){
        super(threadName);
        this.start();
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("id Thread " + Thread.currentThread().getId());
    }
}