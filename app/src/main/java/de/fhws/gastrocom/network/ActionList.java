package de.fhws.gastrocom.network;


import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * stores the current actions of this waiter in a list
 */
public class ActionList implements Iterable<Action> {
    private final List<Action> list = new ArrayList<>();


    public void addAction(Action action) {
        list.add(action);
    }

    public void removeAction(Action action) {
        list.remove(action);
    }

    public void removeAction(int index) {
        list.remove(index);
    }

    public Action get(int index) {
        return list.get(index);
    }

    public void sort() {
        Collections.sort(list);
    }

    public List<Action> getList() {
        return list;
    }


    @NonNull
    @Override
    public Iterator<Action> iterator() {
        return list.iterator();
    }
}
