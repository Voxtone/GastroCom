package de.fhws.gastrocom.network;


import org.json.JSONObject;

/**
 * represents an action, that was invoked by a table
 * Action is comparable with itself; Comparision is based on priority
 */
public class Action implements Comparable<Action>{
    private int id;
    private Type type;
    private int table;
    private int priority;

    public Action(int id, Type type, int table) {
        this(id, type, table, 0);
    }

    public Action(int id, Type type, int table, int priority) {
        this.id = id;
        this.type = type;
        this.table = table;
        this.priority = priority;
    }

    @Override
    public int compareTo(Action o) {
        if(this.priority == o.priority)
            return this.id - o.id;
        else
            return o.priority - this.priority;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public int getTable() {
        return table;
    }

    public int getPriority() {
        return priority;
    }


}
