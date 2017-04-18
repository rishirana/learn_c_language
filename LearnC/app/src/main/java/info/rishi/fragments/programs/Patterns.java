package info.rishi.fragments.programs;

import android.content.Context;
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


public class Patterns extends ListFragment implements AdapterView.OnItemClickListener {



    public Patterns() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patterns, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.pattern,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);

        switch (position){
            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/binary pattern.html "));
                i.putExtra("key","Binary Pattern");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/diamond.html "));
                i.putExtra("key","Diamond");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/diamond star outline.html "));
                i.putExtra("key","Diamond star outline");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/floyd triangle.html "));
                i.putExtra("key","Floyd Triangle");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/hollow diamond.html "));
                i.putExtra("key","Hollow Diamond");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/hollow square.html "));
                i.putExtra("key","Hollow Square");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/hourglass pattern.html "));
                i.putExtra("key","HourGlasss Pattern");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/nested star hash pyramid.html "));
                i.putExtra("key","Nested StarHash Pyramid");
                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/pascal triangle.html "));
                i.putExtra("key","Pascal Traingle");
                break;
            case 9:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/reverse star.html "));
                i.putExtra("key","Reverse Star Triangle");
                break;
            case 10:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/rhombus.html "));
                i.putExtra("key","Rhombus Pattern");
                break;
            case 11:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/triangle with only border.html "));
                i.putExtra("key","Triangle with only Border");
                break;
            case 12:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/x pattern.html "));
                i.putExtra("key","X Pattern");
                break;
            case 13:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/pattern/heart pattern.html "));
                i.putExtra("key","Heart Pattern");
                break;

            default:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/hello world.html"));
                i.putExtra("key","Hello ");
        }

        startActivity(i);


    }
}
