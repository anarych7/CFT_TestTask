package com.company;

import java.util.ArrayList;

/**
 * Created by Александр on 09.03.14.
 */
public class GroupQueue extends ArrayList<Group> {

    private int currentGroup = 0;

    public synchronized Group getGroup() {
        if (++currentGroup >= this.size()) {
            currentGroup = 0;
        }
        return this.get(currentGroup);
    }

    public synchronized void addGroup(Group group) {
        this.add(group);
    }

    public synchronized void addItem(Item item) {
        boolean flag = false;
        for (Group group : this) {
            if (item.getGroupId() == group.getId()) {
                group.addItem(item);
                flag = true;
                break;
            }
        }
        if (!flag) {
            Group newGroup = new Group(item.getGroupId());
            newGroup.addItem(item);
            this.addGroup(newGroup);
        }
    }
}
