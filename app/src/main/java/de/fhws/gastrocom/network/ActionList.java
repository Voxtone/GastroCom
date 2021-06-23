package de.fhws.gastrocom.network;


import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

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

    public boolean containsId(int id) {
        return list.
                stream()
                .anyMatch(action -> action.getId() == id);
    }

    @NonNull
    @Override
    public Iterator<Action> iterator() {
        return list.iterator();
    }

    public void updateListFromJson(JSONObject json) throws JSONException {
        Iterator<String> iter = json.keys();
        while (iter.hasNext()) {
            JSONObject actionJson = json.getJSONObject(iter.next());
            int id = actionJson.getInt("id");
            if(!this.containsId(id))
                this.addAction(new Action(id, Type.stringToType(actionJson.getString("action")), actionJson.getInt("number")));
            //TODO: tell Jakob to make table not redundant anymore
        }
    }
}
