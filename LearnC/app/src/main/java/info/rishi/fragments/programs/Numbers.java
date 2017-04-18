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
public class Numbers extends ListFragment implements AdapterView.OnItemClickListener {


    public Numbers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numbers, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.numbers,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent i = new Intent(getActivity().getApplicationContext(), Web.class);

        switch (position){
            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/greatest among three.html "));
                i.putExtra("key","Greatest Among Three");
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/factorial.html "));
                i.putExtra("key","Factorial of Number");
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/swapping.html "));
                i.putExtra("key","Swapping of Two No.");
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/gcd and lcm.html "));
                i.putExtra("key","GCD and LCM");
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/reverse of number.html "));
                i.putExtra("key","Reverse of No.");
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/sum of digits.html "));
                i.putExtra("key","Sum of Digits");
                break;
            case 6:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/palidrome.html "));
                i.putExtra("key","Palindrome");
                break;
            case 7:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/armstrong.html "));
                i.putExtra("key","Armstrong No.");
                break;
//            case 8:
//                i.setData(Uri.parse("file:///android_asset/c_html/programss/number/fibonacci.html "));
//                i.putExtra("key","Fibonacci Series");
//                break;
            case 8:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/quadratic roots.html "));
                i.putExtra("key","Quadratic Roots");
                break;
            case 9:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/prime no.html "));
                i.putExtra("key","Prime Number");
                break;
            case 10:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/random no.html "));
                i.putExtra("key","Random No Generator");
                break;
            case 11:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/leap year.html "));
                i.putExtra("key","Leap Year");
                break;
            case 12:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/numbers/exponential.html "));
                i.putExtra("key","Exponential Power");
                break;

            default:
                i.setData(Uri.parse("file:///android_asset/c_html/programss/basic/hello world.html"));
                i.putExtra("key","Hello ");
        }

        startActivity(i);

    }
}
