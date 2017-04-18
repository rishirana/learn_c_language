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
import info.rishi.learnc.Term;
import info.rishi.learnc.Web;

/**
 * A simple {@link Fragment} subclass.
 */
public class Basics extends ListFragment implements AdapterView.OnItemClickListener {


    public Basics() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basics, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.basics,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);

        switch (position){
            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/hello world.html "));
                 i.putExtra("key","Hello World");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/integer input.html "));
                i.putExtra("key","Integer Input");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/string basic.html "));
                i.putExtra("key","String Basic");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/airthmetic operation.html "));
                i.putExtra("key","Airthmetic Opearation");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/area and cir of circle.html "));
                i.putExtra("key","Area & Circumference of Circle");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/odd or even.html "));
                i.putExtra("key","Odd or Even");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/size of variable.html "));
                i.putExtra("key","Size of Variable");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/sum of integers.html "));
                i.putExtra("key","Sum of Integers");
                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/celsius to fahr.html "));
                i.putExtra("key","Celsius to Fahrenheit Conversion");
                break;
            case 9:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/sum of even and odd.html "));
                i.putExtra("key","Sum of Even & Odd No.");
                break;
            case 10:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/sum of pos and neg.html "));
                i.putExtra("key","Sum of +ve and -ve no.");
                break;
            case 11:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/ascii.html "));
                i.putExtra("key","ASCII Codes");
                break;

            default:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/hello world.html"));
                i.putExtra("key","Hello ");
        }

        startActivity(i);
    }
}
