package info.rishi.fragments.programs;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Transition;
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
public class Strng extends ListFragment implements AdapterView.OnItemClickListener {


    public Strng() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_strng, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.strngs,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);

        switch (position){

            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/vowel.html"));
                i.putExtra("key","Vowel");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/length.html"));
                i.putExtra("key","String Length");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/comparing two string.html"));
                i.putExtra("key","Comparing Two String");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/copying two string.html"));
                i.putExtra("key","Copying Two String");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/concatenating two string.html"));
                i.putExtra("key","Concatenating Two String");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/substring.html"));
                i.putExtra("key","Substring");
                break;

            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/string to lower case.html"));
                i.putExtra("key","String to Lower Case");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/counting no of vowel in string.html"));
                i.putExtra("key","Counting No of Vowel in String");
                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/palindrome of string.html"));
                i.putExtra("key","Palindrome String");
                break;
            case 9:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/string to integer.html"));
                i.putExtra("key","String to Integer");
                break;
            case 10:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/sorting.html"));
                i.putExtra("key","Sorting of String");
                break;
            case 11:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/removing spaces.html"));
                i.putExtra("key","Removing Spaces from String");
                break;
            case 12:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/frequency of character.html"));
                i.putExtra("key","Vowel");
                break;
             default:
                 i.setData(Uri.parse("file:///android_asset/c_html/programss/strng/removing spaces.html"));

        }
        startActivity(i);

    }
}
