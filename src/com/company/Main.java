package com.company;

import java.util.logging.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    //Generator constants
    private static final int MAX_ITEM_ID = 100;
    private static final int MAX_GROUP_ID = 8;
    private static final long PAUSE = 500;

    //ExecutorThreads constants
    private static final int MAX_THREADS_COUNT = 5;

    public static void main(String[] args) {

        log.info("mainThread is started");

        GroupQueue groupQueue = new GroupQueue();

        new Thread(new Generator(groupQueue, MAX_ITEM_ID, MAX_GROUP_ID, PAUSE)).start();

        new ExecutorThreads(new Executor(groupQueue), MAX_THREADS_COUNT).startAllThreads();

        log.info("mainThread is finished");
    }
}