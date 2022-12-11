package com.LuthfiMisbachulMunirJSleepFN;

/**
 * The `ThreadingObject` class is a subclass of the `Thread` class.
 *
 * @author (Your name here)
 * @version (The version number or date here)
 */
public class ThreadingObject extends Thread {

    /**
     * Constructs a `ThreadingObject` object with the specified thread name.
     *
     * @param threadName the name of the thread
     */
    public ThreadingObject(String threadName){
        super(threadName);
        this.start();
    }

    /**
     * The `run()` method is called when the thread is started.
     */
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("id Thread " + Thread.currentThread().getId());
    }
}