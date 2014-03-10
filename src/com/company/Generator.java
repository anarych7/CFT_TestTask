package com.company;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Александр on 07.03.14.
 */
class Generator implements Runnable {

    private final Logger log = Logger.getLogger(Generator.class.getName());
    private final GroupQueue groupQueue;
    private final int maxItemId;
    private final int maxGroupId;
    private final long pause;

    public Generator(GroupQueue groupQueue, int maxItemId, int maxGroupId, long pause) {
        this.groupQueue = groupQueue;
        this.maxItemId = maxItemId;
        this.maxGroupId = maxGroupId;
        this.pause = pause;
    }

    @Override
    public void run() {
        log.info("started");
        try {
            Random randomId = new Random();
            Random randomGroup = new Random();
            while (!Thread.currentThread().isInterrupted()) {
                groupQueue.addItem(new Item(randomId.nextInt(maxItemId), randomGroup.nextInt(maxGroupId)));
                Thread.sleep(pause);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("finished");
        }
    }
}
