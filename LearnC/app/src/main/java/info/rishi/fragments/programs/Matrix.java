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
public class Matrix extends ListFragment implements AdapterView.OnItemClickListener {


    public Matrix() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matrix, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.matrix,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);
        switch (position){

            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/addition of two matrix.html"));
                i.putExtra("key","Addition of Two Matrix");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/subtraction.html"));
                i.putExtra("key","Subtraction of Two Matrix");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/multiplication.html"));
                i.putExtra("key","Multiplication Two Matrix");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/transpose of matrix.html"));
                i.putExtra("key","Transpose of  Matrix");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/sum of all element.html"));
                i.putExtra("key","Sum of Element of Matrix");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/sum of lower triangle.html"));
                i.putExtra("key","Sum of Lower Triangle");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/sum of upper triangle.html"));
                i.putExtra("key","Sum of Upper Triangle");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/identity.html"));
                i.putExtra("key","Identity Matrix");
                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/square table.html"));
                i.putExtra("key","Square Table");
                break;
            case 9:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/magic square.html"));
                i.putExtra("key","Magic Square");
                break;
            default:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/matrix/magic square.html"));

        }
        startActivity(i);
    }
}
