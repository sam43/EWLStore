package example.saadat.com.ewlmerge.BottomMenuActivities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.Adapters.FavAdapterList;
import example.saadat.com.ewlmerge.Model.DataFav;
import example.saadat.com.ewlmerge.R;


public class FragmentFav extends Fragment {

    RecyclerView recyclerView;
    FavAdapterList adapter;

    String[] ProName;
    String[] NewPrice;
    String[] PrePrice;
    String[] discount;


   int[] img = {R.drawable.im3,R.drawable.im7,R.drawable.im6,
            R.drawable.im12,R.drawable.im8,R.drawable.im10,
            R.drawable.im1,R.drawable.im6,R.drawable.im7,
            R.drawable.im8,R.drawable.im10};

    ArrayList<DataFav> favList = new ArrayList<>();
    private LinearLayoutManager layoutManager;

    private enum LayoutManagerType {
        LINEAR_LAYOUT_MANAGER
    }


    protected LayoutManagerType mCurrentLayoutManagerType;


    public FragmentFav() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fav, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyc_fav);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        ProName = getResources().getStringArray(R.array.Product);
        NewPrice = getResources().getStringArray(R.array.new_price);
        PrePrice = getResources().getStringArray(R.array.pre_price);
        discount = getResources().getStringArray(R.array.discount);


        int i = 0;
        for (String name : ProName) {
            DataFav data = new DataFav(img[i], name, NewPrice[i], PrePrice[i], discount[i]);
            favList.add(data);
            i++;
        }

        adapter = new FavAdapterList(getContext(),favList);

        layoutManager = new LinearLayoutManager(getContext());
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        productData();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void productData() {

        int[] covers = new int[]{
                R.drawable.im1,
                R.drawable.im3,
                R.drawable.im6,
                R.drawable.im1,
                R.drawable.im7,
                R.drawable.im10,
                R.drawable.im3,
                R.drawable.im12,
                R.drawable.im3,
                R.drawable.im1,
                R.drawable.im8};

        DataFav a = new DataFav(covers[0], "ASUS", "ট 2,590", "ট 2,590", "25% Discount");
        favList.add(a);

        a = new DataFav(covers[1], "ASUS", "ট 2,590", "ট 3,590", "25% Discount");
        favList.add(a);
        a = new DataFav(covers[2], "Apple", "ট 12,590", "ট 17,590", "5% Discount");
        favList.add(a);
        a = new DataFav(covers[3], "htc", "ট 25,590", "ট 27,590", "20% Discount");
        favList.add(a);
        a = new DataFav(covers[4], "Oppo", "ট 8,590", "ট 10,590", "15% Discount");
        favList.add(a);
        a = new DataFav(covers[5], "asus", "ট 4,590", "ট 5,590", "25% Discount");
        favList.add(a);
        a = new DataFav(covers[6], "bla bla", "ট 890", "ট 1,590", "25% Discount");
        favList.add(a);
        a = new DataFav(covers[7], "hp", "ট 26,590", "ট 28,590", "25% Discount");
        favList.add(a);
        a = new DataFav(covers[8], "EWL", "ট 22,590", "ট 29,590", "25% Discount");
        favList.add(a);
        a = new DataFav(covers[9], "Panasonic", "ট 32,590", "ট 36,590", "25% Discount");
        favList.add(a);
        a = new DataFav(covers[10], "Mac pro", "ট 42,590", "ট 48,590", "25% Discount");
        favList.add(a);
    }
}
