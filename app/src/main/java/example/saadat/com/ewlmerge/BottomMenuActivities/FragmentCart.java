package example.saadat.com.ewlmerge.BottomMenuActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.Adapters.CartAdapter;
import example.saadat.com.ewlmerge.Model.DataCart;
import example.saadat.com.ewlmerge.MoreRelatedPackage.CheckOutActivity;
import example.saadat.com.ewlmerge.R;

public class FragmentCart extends Fragment {

    RecyclerView recyclerView;
    CartAdapter adapter;
    Button chkOutPay;

    String[] ProName;
    String[] NewPrice;
    String[] PrePrice;

    int[] img = {R.drawable.im3,R.drawable.im7,R.drawable.im6,
            R.drawable.im12,R.drawable.im8};

    ArrayList<DataCart> cartList = new ArrayList<>();
    private LinearLayoutManager layoutManager;

    private enum LayoutManagerType {
        LINEAR_LAYOUT_MANAGER
    }
    protected LayoutManagerType mCurrentLayoutManagerType;

    public FragmentCart() {
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
        View v = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyc_cart);

        chkOutPay = (Button) v.findViewById(R.id.chkOutNpay);

        chkOutPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChkOut = new Intent(getActivity(), CheckOutActivity.class);
                startActivity(intentChkOut);
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        ProName = getResources().getStringArray(R.array.Product);
        NewPrice = getResources().getStringArray(R.array.new_price);
        PrePrice = getResources().getStringArray(R.array.pre_price);

        int i = 0;
        for (String name : ProName) {
            DataCart data = new DataCart(img[i], name, NewPrice[i], PrePrice[i]);
            cartList.add(data);
            i++;
        }

        adapter = new CartAdapter(getContext(),cartList);

        layoutManager = new LinearLayoutManager(getContext());
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        cartData();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void cartData() {
        int[] covers = new int[]{
                R.drawable.im1,
                R.drawable.im3,
                R.drawable.im6,
                R.drawable.im1,
                R.drawable.im7};

        DataCart a = new DataCart(covers[0], "Apple", "ট 12,590", "ট 17,590");
        cartList.add(a);
        a = new DataCart(covers[1], "htc", "ট 25,590", "ট 27,590");
        cartList.add(a);
        a = new DataCart(covers[2], "hp", "ট 26,590", "ট 28,590");
        cartList.add(a);
        a = new DataCart(covers[3], "EWL", "ট 22,590", "ট 29,590");
        cartList.add(a);
        a = new DataCart(covers[4], "Panasonic", "ট 32,590", "ট 36,590");
        cartList.add(a);
    }
}
