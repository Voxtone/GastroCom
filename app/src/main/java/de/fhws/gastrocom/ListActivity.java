package de.fhws.gastrocom;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

import de.fhws.gastrocom.network.Action;
import de.fhws.gastrocom.network.ActionList;
import de.fhws.gastrocom.network.Client;
import de.fhws.gastrocom.network.Type;

// TODO: proper http connection (Client class)
// TODO: write JSON adapter, to convert JSONObject to Action object
// TODO: three dots to call another waiter

public class ListActivity extends AppCompatActivity {

    private static final String HOST = "192.168.178.5";
    private ListView dynamic;
    private final ActionList actions = new ActionList();
    private CustomListAdapter adapter;
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        try {
            client = new Client(HOST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dynamic = findViewById(R.id.dynamic);


        dynamic.setOnItemClickListener((parent, view, position, id) -> {
            onItemClicked(position);
        });

        adapter = new CustomListAdapter(this, actions.getList());
        dynamic.setAdapter(adapter);

        test();                                                             // only test

        updateData();
    }

    /**
     * updates the adapter and as a consequence also the ListView
     */
    protected void updateData() {
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void onItemClicked(int position) {

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Tisch " + actions.get(position).getTable() + ": " + actions.get(position).getType())
                .setMessage("Auftrag erledigt?")
                //.setIcon(R.drawable. no icon yet)
                .setPositiveButton(R.string.done, (dialog, whichButton) -> {
                    completeAction(position);
                    toast(getResources().getString(R.string.done));
                    updateData();
                })
                .setNeutralButton(R.string.pass, (dialog, whichButton) -> {
                    passAction(position);
                    toast("Passed");
                    updateData();
                }).show();
                /*.setNegativeButton(R.string.dnf, (dialog, whichButton) -> {       // no negative button specified
                    updateData();
                })*/
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.transparent, null));
        alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setBackgroundColor(getResources().getColor(R.color.transparent, null));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setBackgroundColor(getResources().getColor(R.color.transparent, null));
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.blue, null));
        alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(getResources().getColor(R.color.red, null));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.blue, null));

    }

    /**
     * passes the action to antother waiter
     * @param position index of the action
     */
    private void passAction(int position) {
        actions.removeAction(position);
    }

    /**
     * completes the action
     * @param position index of the action
     */
    private void completeAction(int position) {
        actions.removeAction(position);
    }

    private void toast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT);
    }


    private void test() {
        actions.addAction(new Action(1, Type.ORDER, 5, 3));
        actions.addAction(new Action(2, Type.PAY, 4, 5));
        actions.addAction(new Action(4, Type.ORDER, 13, 3));
        actions.addAction(new Action(5, Type.ORDER, 2, 3));
        actions.addAction(new Action(6, Type.ORDER, 4, 1));
        actions.addAction(new Action(7, Type.PAY, 5, 1));
        actions.addAction(new Action(8, Type.ORDER, 6, 1));
        actions.addAction(new Action(9, Type.ORDER, 8, 1));
        actions.addAction(new Action(10, Type.PAY, 1, 4));
        actions.addAction(new Action(11, Type.ORDER, 7, 1));
        actions.addAction(new Action(12, Type.PAY, 8, 1));
        actions.addAction(new Action(13, Type.ORDER, 3, 2));

    }


}