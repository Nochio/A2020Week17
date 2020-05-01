package com.example.week17;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    private MainActivity mainActivity;//reference to parent so we can call it handle item method

    public static ListFragment newInstance(MainActivity mainActivity) {//to avoid conflict with no-args constructor
        ListFragment listFragment = new ListFragment();
        listFragment.mainActivity = mainActivity;
        return listFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listlayout, container, false);

        ListView listview = view.findViewById(R.id.myList);

        listview.setOnItemClickListener((adapterView, view2, adapter_pos, row_id) -> {
            //Call parent (MainActivity), and ask it to handle the click.
            TextView textView = (TextView)view2;
            if (textView != null) {
                mainActivity.handleItemClick(textView.getText().toString());
            }


        });

        return view;
    }
}
