package com.giao.simple_expandablelistview;
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(MainActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        ExpandList.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<Child> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();

                showToastMsg(group_name + "\n" + child_name);

                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "\n Expanded");

            }
        });

        ExpandList.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "\n Expanded");

            }
        });

    }

    public ArrayList<Group> SetStandardGroups() {

        ArrayList<Group> group_list = new ArrayList<Group>();
        ArrayList<Child> child_list;

        // Setting Group 1
        child_list = new ArrayList<Child>();
        Group gru1 = new Group();
        gru1.setName("APPLE");

        Child ch1_1 = new Child();
        ch1_1.setName("Iphone");
        child_list.add(ch1_1);

        Child ch1_2 = new Child();
        ch1_2.setName("ipad");
        child_list.add(ch1_2);

        Child ch1_3 = new Child();
        ch1_3.setName("ipod");
        child_list.add(ch1_3);

        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<Child>();
        Group gru2 = new Group();
        gru2.setName("SAMSUNG");

        Child ch2_1 = new Child();
        ch2_1.setName("Galaxy Grand");
        child_list.add(ch2_1);

        Child ch2_2 = new Child();
        ch2_2.setName("Galaxy Note");
        child_list.add(ch2_2);

        Child ch2_3 = new Child();
        ch2_3.setName("Galaxy Mega");
        child_list.add(ch2_3);

        Child ch2_4 = new Child();
        ch2_4.setName("Galaxy Neo");
        child_list.add(ch2_4);

        gru2.setItems(child_list);

        //listing all groups
        group_list.add(gru1);
        group_list.add(gru2);

        return group_list;
    }

    public void showToastMsg(String Msg) {
        Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT).show();
    }

}