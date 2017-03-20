package example.saadat.com.ewlmerge.Controllers;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.Adapters.RecyclerAdapter;
import example.saadat.com.ewlmerge.Model.Data;
import example.saadat.com.ewlmerge.MoreRelatedPackage.Hotsell;
import example.saadat.com.ewlmerge.R;

/**
 * Created by Saadat on 9/5/2016.
 */
public class Recommended extends Fragment{

    RecyclerView recyclerView,recyclerView1,recyclerView2,recyclerView3;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] Title1;
    String[] Title2;
    String[] Title3;
    ViewDialog dialog;
    Button subscribe;
    Button more1, more2, more3, more4;

    //FragmentChangeController fragmentChangeController;


    //int i;
    int[] img = {R.drawable.im1,R.drawable.im3,R.drawable.im6,R.drawable.im7,R.drawable.im8,R.drawable.im10,R.drawable.im12};
    ArrayList<Data> arrayList = new ArrayList<Data>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.recommended, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.hotsell);

        subscribe = (Button) v.findViewById(R.id.subscribe);
        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ViewDialog();
                dialog.showDialog(getActivity(),"Thank you for Subscription!");

            }
        });


        more1 = (Button) v.findViewById(R.id.more1);
        more2 = (Button) v.findViewById(R.id.more2);
        more3 = (Button) v.findViewById(R.id.more3);
        more4 = (Button) v.findViewById(R.id.more4);

        more1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotsell frg = new Hotsell();
                FragmentTransaction frgtran = getFragmentManager().beginTransaction();
                frgtran.replace(R.id.replace, frg);
                frgtran.addToBackStack(null);
                frgtran.commit();
                //fragmentChangeController.onFragmentChange(HomeFragment.newInstance() ,Hotsell.FRAGMENT_TAG,true);

                Toast.makeText(getActivity().getApplicationContext(),"more to show...", Toast.LENGTH_SHORT).show();

                //Recommended.super.getFragmentManager().popBackStack();
            }
        });

        //recycler kaj kam... er moddhe hat diyen na
        recyclerView.setHasFixedSize(true);
        recyclerView1 = (RecyclerView) v.findViewById(R.id.offers);
        recyclerView2 = (RecyclerView) v.findViewById(R.id.choice);
        recyclerView3 = (RecyclerView) v.findViewById(R.id.mostview);
        recyclerView1.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setHasFixedSize(true);
        return v;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        Title1 = getResources().getStringArray(R.array.brand_name);
        Title2 = getResources().getStringArray(R.array.Item_name);
        Title3 = getResources().getStringArray(R.array.pre_price);

        int i = 0;
        for (String name : Title1) {
            Data data = new Data(img[i], name, Title2[i], Title3[i]);
            arrayList.add(data);
            i++;
        }

        for ( i = 0; i <=3; i++) {


            if (i == 0) {

                Data data = new Data(img[i], Title1[i], Title2[i],Title3[i]);
                arrayList.add(data);
                adapter = new RecyclerAdapter(getActivity(),arrayList);

                recyclerView.setHasFixedSize(false);

                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
                } else {
                    linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
                }
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

            }


            if (i == 1) {
                Data data = new Data(img[i], Title1[i], Title2[i], Title3[i]);
                arrayList.add(data);
                adapter = new RecyclerAdapter(getActivity(),arrayList);

                recyclerView1.setHasFixedSize(true);

                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView1.setLayoutManager(layoutManager);
                recyclerView1.setAdapter(adapter);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
                } else {
                    linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
                }
                recyclerView1.setLayoutManager(linearLayoutManager);
                recyclerView1.setItemAnimator(new DefaultItemAnimator());

            }

            if (i == 2) {
                Data data = new Data(img[i], Title1[i], Title2[i], Title3[i]);
                arrayList.add(data);
                adapter = new RecyclerAdapter(getActivity(),arrayList);

                recyclerView2.setHasFixedSize(true);

                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView2.setLayoutManager(layoutManager);
                recyclerView2.setAdapter(adapter);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
                } else {
                    linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
                }
                recyclerView2.setLayoutManager(linearLayoutManager);
                recyclerView2.setItemAnimator(new DefaultItemAnimator());

            }
            if (i == 3) {
                Data data = new Data(img[i], Title1[i], Title2[i], Title3[i]);
                arrayList.add(data);
                adapter = new RecyclerAdapter(getActivity(),arrayList);

                recyclerView3.setHasFixedSize(true);

                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView3.setLayoutManager(layoutManager);
                recyclerView3.setAdapter(adapter);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
                } else {
                    linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
                }
                recyclerView3.setLayoutManager(linearLayoutManager);
                recyclerView3.setItemAnimator(new DefaultItemAnimator());

            }
        }
    }
}
