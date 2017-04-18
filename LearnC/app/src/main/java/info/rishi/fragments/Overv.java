package info.rishi.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import info.rishi.learnc.R;
import info.rishi.learnc.Term;

///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link Overv.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link Overv#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Overv extends ListFragment implements AdapterView.OnItemClickListener {

    ListView listView;

    public Overv() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View  rv =  inflater.inflate(R.layout.fragment_overv, container, false);
       // listView = (ListView)rv.findViewById(R.id.list);
        return  rv;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.overviews,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Intent i = new Intent(getActivity().getApplicationContext(), Term.class);
        switch (position) {

            case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/structure of c.html"));
                break;
            case 1:
                i.setData(Uri.parse("file:///android_asset/c_html/compilation.html"));
                break;
            case 2:
                i.setData(Uri.parse("file:///android_asset/c_html/noenclature.html"));
                break;
            case 3:
                i.setData(Uri.parse("file:///android_asset/c_html/datatypes.html"));
                break;
            case 4:
                i.setData(Uri.parse("file:///android_asset/c_html/operator.html"));
                break;
            case 5:
                i.setData(Uri.parse("file:///android_asset/c_html/qualifier.html"));
                break;
            default:
                i.setData(Uri.parse("file:///android_asset/fg.jpg"));

//                Intent ii = new Intent(getActivity().getApplicationContext(),Term.class);
//                ii.putExtra("keyHtml","file:///android_asset/dashboard.html");
//                startActivity(ii);

        }
        startActivity(i);
    }

}
