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

import info.rishi.learnc.R;
import info.rishi.learnc.Web;

/**
 * A simple {@link Fragment} subclass.
 */
public class Arrays extends ListFragment implements AdapterView.OnItemClickListener {


    public Arrays() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_arrays, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.Arry,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);
        switch (position){

            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/minimum element of array.html"));
                i.putExtra("key","Smallest Element of Array");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/maximum element.html"));
                i.putExtra("key","Greatest Element of Array");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/reverse of array.html"));
                i.putExtra("key","Reversing an Array");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/duplicating array.html"));
                i.putExtra("key","Duplicating an  Array");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/merging of array.html"));
                i.putExtra("key","Merging  Arrays");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/binary search.html"));
                i.putExtra("key","Binary Sorting");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/insertion sort.html"));
                i.putExtra("key","Insertion Sort");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/selection sort.html"));
                i.putExtra("key","Selection Sort");
                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/linear search.html"));
                i.putExtra("key","Linear Search");
                break;
            case 9:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/inserting element into array.html"));
                i.putExtra("key","Inserting Element into Array");
                break;
            case 10:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/deleting element from array.html"));
                i.putExtra("key","Deleting Element from  Array");
                break;
            case 11:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/stack using array.html"));
                i.putExtra("key","Stack using Array");
                break;
            case 12:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/array/standard deviation.html"));
                i.putExtra("key","Standard Deviation Calculation");
                break;
             default:
                 i.setData(Uri.parse("file:///android_asset/c_html/programss/array/linear search.html"));



        }

        startActivity(i);
    }
}
