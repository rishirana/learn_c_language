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
public class Extras extends ListFragment implements AdapterView.OnItemClickListener {


    public Extras() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extras, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.Extras,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);
        switch (position){
            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/extras/calender.html"));
                i.putExtra("key","Displaying Calender");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/extras/binary multiplication.html"));
                i.putExtra("key","Binary Multiplication");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/extras/binary addition.html"));
                i.putExtra("key","Binary Addition");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/extras/current time and date.html"));
                i.putExtra("key","Viewing Current Date");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/extras/gettng ip address.html"));
                i.putExtra("key","Getting IP Address");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/extras/shutdown.html"));
                i.putExtra("key","Turning Off Computer");
                break;
            default:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/extras/calender.html"));

        }
        startActivity(i);
    }
}
