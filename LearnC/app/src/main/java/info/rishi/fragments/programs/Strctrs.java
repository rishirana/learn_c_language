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
public class Strctrs extends ListFragment implements AdapterView.OnItemClickListener {


    public Strctrs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_strctrs, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.strctrs,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);
        switch (position){
            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/simple structure.html"));
                i.putExtra("key","Simple Structure");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/Storing information.html"));
                i.putExtra("key","Array of Structure");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/distance conversion.html"));
                i.putExtra("key","Distance Conversion");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/union.html"));
                i.putExtra("key","Union ");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/stack.html"));
                i.putExtra("key","Stack");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/queue.html"));
                i.putExtra("key","Queue");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/dynamic memory allocation.html"));
                i.putExtra("key","Dynamic Memory Allocation");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/single linked list.html"));
                i.putExtra("key","Single linked list");
                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/doubly linked list.html"));
                i.putExtra("key","Doubly Linked List");
                break;
            case 9:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/reversing linked list.html"));
                i.putExtra("key","Reversing Linked List");
                break;
            case 10:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/queue using linked list.html"));
                i.putExtra("key","Queue Using Linked List");
                break;
            default:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/structure/simple structure.html"));

        }
        startActivity(i);
    }
}
