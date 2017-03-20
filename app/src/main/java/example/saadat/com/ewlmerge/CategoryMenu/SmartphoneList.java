package example.saadat.com.ewlmerge.CategoryMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.Adapters.SmartphoneListAdapter;
import example.saadat.com.ewlmerge.Controllers.HeightGridViewSmart;
import example.saadat.com.ewlmerge.Model.SmartBeans;
import example.saadat.com.ewlmerge.R;


public class SmartphoneList extends Fragment {

    private HeightGridViewSmart gridviewSmart;
    private ArrayList<SmartBeans> beanclassArrayList;
    private SmartphoneListAdapter gridviewAdapter;

    private int[] IMAGEgrid = {R.drawable.im1, R.drawable.im3, R.drawable.im6, R.drawable.im8, R.drawable.im12, R.drawable.pik1, R.drawable.im7, R.drawable.pik4, R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4, R.drawable.w5, R.drawable.w1, R.drawable.w4, R.drawable.w5};
    private String[] TITLeGgrid = {"Min 70% off", "Min 50% off", "Min 45% off",  "Min 60% off", "Min 70% off", "Min 50% off", "Min 25% off", "Min 40% off", "Min 50% off", "Min 45% off",  "Min 60% off", "Min 70% off", "Min 50% off", "Min 25% off", "Min 40% off", "Min 25% off"};
    private String[] DIscriptiongrid = {"Wrist Watch", "Wrist Watch", "Wrist Watch","Wrist Watch", "Wrist Watch", "Wrist Watch","Flame thower","bla bla", "Wrist Watch", "Wrist Watch","Wrist Watch", "Wrist Watch", "Wrist Watch","Flame thower", "Dragon Ballz", "Laptop New"};
    private String[] Dategrid = {"Explore Now!","Grab Now!","Discover now!", "Great Savings!", "Explore Now!","Grab Now!","Take it now!", "Save your Money!","Grab Now!","Discover now!", "Great Savings!", "Explore Now!","Grab Now!","Take it now!", "Save your Money!", "আরে মিয়া ফ্রি তো!"};


    public SmartphoneList() {
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
        View v = inflater.inflate(R.layout.fragment_smartphone_list, container, false);
        gridviewSmart = (HeightGridViewSmart) v.findViewById(R.id.gridview_smart);
        beanclassArrayList = new ArrayList<SmartBeans>();

        for (int i=0; i<IMAGEgrid.length; i++){
            SmartBeans beanclass = new SmartBeans(IMAGEgrid[i], TITLeGgrid [i], DIscriptiongrid [i], Dategrid[i]);
            beanclassArrayList.add(beanclass);
        }
        gridviewAdapter = new SmartphoneListAdapter(getActivity(), beanclassArrayList);
        gridviewSmart.setExpanded(true);

        gridviewSmart.setAdapter(gridviewAdapter);

        return v;
    }
}
