package com.company;

/**
 * Created by Александр on 07.03.14.
 */
public class Item implements Comparable<Item> {

    private final int id;
    private final int groupId;

    public Item(int id, int groupId) {
        this.id = id;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public int compareTo(Item item) {
        if (this.getId() > item.getId())
            return 1;
        if (this.getId() < item.getId())
            return -1;
        return 0;
    }
}
