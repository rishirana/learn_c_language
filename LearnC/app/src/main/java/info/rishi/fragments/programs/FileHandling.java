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
public class FileHandling extends ListFragment implements AdapterView.OnItemClickListener {


    public FileHandling() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_file_handling, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.fileHandling,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);
        switch (position){
            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/file handling/viewing file.html"));
                i.putExtra("key","Viewing List of File");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/file handling/reading file.html"));
                i.putExtra("key","Reading from File");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/file handling/deleting file.html"));
                i.putExtra("key","Deleting from File");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/file handling/copying file.html"));
                i.putExtra("key","Copying File");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/file handling/character counting.html"));
                i.putExtra("key","Character Counting");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/file handling/merging two file.html"));
                i.putExtra("key","Merging Files");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/file handling/reverse content.html"));
                i.putExtra("key","Reversing File Content");
                break;
            default:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/file handling/reading file.html"));
        }
        startActivity(i);
    }
}
