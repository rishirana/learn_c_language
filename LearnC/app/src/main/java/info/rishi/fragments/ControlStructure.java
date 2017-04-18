package info.rishi.fragments;


import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Fade;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import info.rishi.learnc.MainActivity;
import info.rishi.learnc.R;
import info.rishi.learnc.Term;


public class ControlStructure extends ListFragment implements AdapterView.OnItemClickListener {

    public ControlStructure() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control_structure, container, false);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter ad = ArrayAdapter.createFromResource(getActivity(),R.array.control,android.R.layout.simple_list_item_activated_1);
        setListAdapter(ad);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void setSharedElementEnterTransition(Object transition) {
        super.setSharedElementEnterTransition(transition);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Intent i = new Intent(getActivity().getApplicationContext(), Term.class);
             switch (position) {
                 case 0:
                i.setData(Uri.parse("file:///android_asset/c_html/if else.html"));
                 break;
                 case 1:
                     i.setData(Uri.parse("file:///android_asset/c_html/switch.html"));
                     break;
                 case 2:
                     i.setData(Uri.parse("file:///android_asset/c_html/goto.html"));
                     break;
                 case 3:
                     i.setData(Uri.parse("file:///android_asset/c_html/while.html"));
                     break;
                 case 4:
                     i.setData(Uri.parse("file:///android_asset/c_html/do while.html"));
                     break;
                 case 5:
                     i.setData(Uri.parse("file:///android_asset/c_html/for.html"));
                     break;
                 case 6:
                     i.setData(Uri.parse("file:///android_asset/c_html/nesting of loop.html"));
                     break;
                 default:
                     i.setData(Uri.parse("file:///android_asset/c_html/Continue and Break.html"));


             }
        startActivity(i);
    }
}
