package com.company;

import java.util.logging.Logger;

/**
 * Created by Александр on 07.03.14.
 */
class Executor implements Runnable {

    private final Logger log = Logger.getLogger(Executor.class.getName());
    private final GroupQueue groupQueue;

    public Executor(GroupQueue groupQueue) {
        this.groupQueue = groupQueue;
    }

    @Override
    public void run() {
        log.info("started");
        Group group;
        try {
            Item item;
            while (!Thread.currentThread().isInterrupted()) {
                if (groupQueue.size() != 0) {
                    group = groupQueue.getGroup();
                    synchronized (group) {
                        if (!group.isEmpty()) {
                            item = group.getItem();
                            if (item != null)
                                this.exe(item.getId(), item.getGroupId());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("finished");
        }
    }

    private void exe(int itemId, int groupId) {
        System.out.format("item [%d:%d] is executed {%s}\n", itemId, groupId, Thread.currentThread().getName());
    }
}
