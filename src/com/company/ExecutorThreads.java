package com.company;

/**
 * Created by Александр on 10.03.14.
 */
class ExecutorThreads {

    private Thread[] threads;

    public ExecutorThreads(Executor executor, int maxThreads) {
        this.threads = new Thread[maxThreads];
        for (int i = 0; i < this.threads.length; i++) {
            threads[i] = new Thread(executor);
        }
    }

    public void startAllThreads(){
        for (Thread thread : this.threads) {
            thread.start();
        }
    }
}
