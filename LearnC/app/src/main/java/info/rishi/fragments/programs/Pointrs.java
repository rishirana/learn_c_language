package info.rishi.fragments.programs;


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

import java.util.List;

import info.rishi.learnc.R;
import info.rishi.learnc.Web;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pointrs extends ListFragment implements AdapterView.OnItemClickListener {


    public Pointrs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pointrs, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.pntrs,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);
        switch (position){
            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/add two no.html"));
                i.putExtra("key","Add Two No.");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/array of char pointer.html"));
                i.putExtra("key","Array of Char Pointer");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/array of int.html"));
                i.putExtra("key","Array of Int Pointer");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/decrementing a pointer.html"));
                i.putExtra("key","Decrementing Pointer");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/increment pointer.html"));
                i.putExtra("key","Incrementing Pointer");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/null pointer.html"));
                i.putExtra("key","Null Pointer");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/pointer function.html"));
                i.putExtra("key","Pointer to Function");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/pointer to pointer.html"));
                i.putExtra("key","Pointer to Pointer");
                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/pointer and structure.html"));
                i.putExtra("key","Pointer and Structure");
                break;
            default:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pointers/pointer to pointer.html"));
        }
        startActivity(i);
    }
}
