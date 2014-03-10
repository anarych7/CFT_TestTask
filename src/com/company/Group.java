package com.company;

import java.util.PriorityQueue;

/**
 * Created by Александр on 07.03.14.
 */
public class Group extends PriorityQueue<Item> {

    private final int id;

    public Group(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public synchronized void addItem(Item item) {
        this.add(item);
    }

    public synchronized Item getItem() {
        return this.remove();
    }
}