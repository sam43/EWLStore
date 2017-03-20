package example.saadat.com.ewlmerge.BottomMenuActivities;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.Adapters.GridviewAdapter;
import example.saadat.com.ewlmerge.Adapters.ShowItem;
import example.saadat.com.ewlmerge.Controllers.ExpandableHeightGridView;
import example.saadat.com.ewlmerge.JSONConfigPozo.ConfigProduct;
import example.saadat.com.ewlmerge.Model.Beanclass;
import example.saadat.com.ewlmerge.MoreRelatedPackage.ShowItemJson;
import example.saadat.com.ewlmerge.R;

/**
 * Created by Saadat on 9/5/2016.
 */
public class FragmentProduct extends Fragment {

    private ExpandableHeightGridView gridview;
    private ArrayList<Beanclass> beanclassArrayList;
    private GridviewAdapter gridviewAdapter;
    //static Context cxt;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.product, container, false);

        gridview = (ExpandableHeightGridView) v.findViewById(R.id.gridview);
        beanclassArrayList = new ArrayList<Beanclass>();

        getJsonData();
        gridviewAdapter = new GridviewAdapter(getActivity(), beanclassArrayList);
        gridview.setExpanded(true);

        gridview.setAdapter(gridviewAdapter);

        return v;
    }


    private void getJsonData() {

        final ProgressDialog loading = ProgressDialog.show(getActivity(), "Loading Data", "Please wait...", true, true);


        JsonArrayRequest jsonArrayequest = new JsonArrayRequest
                (ConfigProduct.DATA_URL, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        loading.setCancelable(false);
                        parseData(response);
                        loading.dismiss();
                    }
                },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                /*loading.dismiss();
                                Toast.makeText(getActivity(), "No Internet Connections!", Toast.LENGTH_LONG).show();

                                //Snackbar.make(getContext(), "No Internet Connections!", Snackbar.LENGTH_SHORT).show();*/


                            }
                        }

                );

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonArrayequest);
    }

    private void parseData(final JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            Beanclass data = new Beanclass();
            JSONObject json = null;

            try {
                json = array.getJSONObject(i);
                data.setImage1(json.getString(ConfigProduct.TAG_IMAGE));
                data.setTitle1(json.getString(ConfigProduct.TAG_NAME));
                data.setDate1(json.getString(ConfigProduct.TAG_OLD_PRICE));
                data.setDiscription1(json.getString(ConfigProduct.TAG_NEW_PRICE));
                //data.setRating(json.getString(String.valueOf(Config.TAG_RATING)));
                //data.setFear(json.getString(Config.TAG_FEAR));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            /*String productName = getString(ConfigProduct.TAG_NAME);
            String discountedPrice = Jobj.getString(ConfigProduct.TAG_NEW_PRICE);
            String previousPrice = Jobj.getString(ConfigProduct.TAG_OLD_PRICE);*/

            beanclassArrayList.add(data);
        }
        gridviewAdapter = new GridviewAdapter(getActivity(), beanclassArrayList);
        gridviewAdapter.notifyDataSetChanged();
        gridview.setAdapter(gridviewAdapter);
    }
}
