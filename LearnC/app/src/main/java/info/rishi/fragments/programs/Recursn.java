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
public class Recursn extends ListFragment implements AdapterView.OnItemClickListener {


    public Recursn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recursn, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.recursion,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);
        switch (position){

            case 0:
            i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/sum of n no.html"));
            i.putExtra("key","Sum of N No.");
             break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/power of no.html"));
                i.putExtra("key","Power of  No.");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/prime no.html"));
                i.putExtra("key","No is Prime or Not");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/fabonacci series.html"));
                i.putExtra("key","Fabonacci Series");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/factorial of no.html"));
                i.putExtra("key","Factorial of  No.");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/palindrome.html"));
                i.putExtra("key","Palindrome No");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/largest in array.html"));
                i.putExtra("key","Largest Element of Array");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/gcd of two no.html"));
                i.putExtra("key","GCD of Two No.");
                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/lcm of two.html"));
                i.putExtra("key","LCM of Two No.");
                break;
            default:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/recursion/lcm of two.html"));
        }
        startActivity(i);
    }
}
