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
public class Conversions extends ListFragment implements AdapterView.OnItemClickListener {


    public Conversions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conversions, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.conversion,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);

        switch (position){
            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/binary to decimal.html"));
                i.putExtra("key","Binary to Decimal");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/decimal to binary.html"));
                i.putExtra("key","Decimal to Binary");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/binary to hexadecimal.html"));
                i.putExtra("key","Binary to HexaDecimal");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/binary to octal.html"));
                i.putExtra("key","Binary to Octal");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/decimal to roman.html"));
                i.putExtra("key","Decimal to Roman");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/decimal to hexadecimal.html"));
                i.putExtra("key","Decimal to HexaDecimal");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/decimal to octal.html"));
                i.putExtra("key","Decimal to Octal");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/octal to binary.html"));
                i.putExtra("key","Octal to Binary");
                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/octal to decimal.html"));
                i.putExtra("key","Octal to Decimal");
                break;
            case 9:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/hexadecimal to binary.html"));
                i.putExtra("key","HexaDecimal to Binary");
                break;
            case 10:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/conversions/roman to decimal.html"));
                i.putExtra("key","Roman to Decimal");
                break;
            default:
                i.setData(Uri.parse("file:///android_asset/c_html/porgramss/conversions/binary to decimal"));

        }
        startActivity(i);
    }
}
