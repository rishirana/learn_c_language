package info.rishi.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import info.rishi.learnc.R;
import info.rishi.learnc.Term;

/**
 * A simple {@link Fragment} subclass.
 */
public class Strings extends ListFragment implements AdapterView.OnItemClickListener {


    public Strings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_string, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.strings,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Term.class);
        switch (position) {
            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/string.html"));
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/string function.html"));
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/formatted input.html"));
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/formatted output.html"));
                break;
            default:
                i.setData(Uri.parse("file:///android_asset/c_html/string.html"));


        }
        startActivity(i);
    }
}
