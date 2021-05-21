package de.fhws.gastrocom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.widget.ListView;

import de.fhws.gastrocom.action.Action;
import de.fhws.gastrocom.action.ActionList;
import de.fhws.gastrocom.action.Type;

public class ListActivity extends AppCompatActivity {

    private ListView dynamic;
    private ActionList actions = new ActionList();
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Aufgaben");

        dynamic = findViewById(R.id.dynamic);


        dynamic.setOnItemClickListener((parent, view, position, id) -> {
            onItemClicked(position);
        });

        adapter = new CustomListAdapter(this, actions.getList());
        dynamic.setAdapter(adapter);

        test();
        updateListView();

    }

    /**
     * updates the adapter and as a consequence also the ListView
     */
    protected void updateListView() {
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
        // TODO: options: delete (action completed), pass (to another waiter)
        /*AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Modify Attempt")
                .setMessage("How do you want to modify this attempt?")
                .setIcon(R.drawable.ic_baseline_create_24)
                .setPositiveButton(R.string.plus2, (dialog, whichButton) -> {
                    if(attempts.get(position).isDnf())
                        toast("Already DNF");
                    attempts.get(position).togglePlus2();
                    updateData();
                })
                .setNegativeButton(R.string.dnf, (dialog, whichButton) -> {
                    if(attempts.get(position).isPlus2())
                        toast("Already +2");
                    attempts.get(position).toggleDnf();
                    updateData();
                })
                .setNeutralButton(R.string.delete, (dialog, whichButton) -> {
                    deleteTime(position);
                }).show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.transparent, null));
        alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setBackgroundColor(getResources().getColor(R.color.transparent, null));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setBackgroundColor(getResources().getColor(R.color.transparent, null));
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.blue, null));
        alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(getResources().getColor(R.color.red, null));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.blue, null));*/

    }

    private void test() {
        actions.addAction(new Action(1, Type.ORDER, 4, 3));
        actions.addAction(new Action(2, Type.PAY, 5, 5));
        actions.addAction(new Action(3, Type.ORDER, 3, 3));
    }


}