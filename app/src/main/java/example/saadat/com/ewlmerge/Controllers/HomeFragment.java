package example.saadat.com.ewlmerge.Controllers;

/**
 * Created by Ravi on 29/07/15.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import example.saadat.com.ewlmerge.Adapters.CustomGridViewActivity;
import example.saadat.com.ewlmerge.Authentications.LoginActivity;
import example.saadat.com.ewlmerge.CategoryMenu.Accessories;
import example.saadat.com.ewlmerge.CategoryMenu.AudioVideo;
import example.saadat.com.ewlmerge.CategoryMenu.FragmentPC;
import example.saadat.com.ewlmerge.CategoryMenu.HomeApp;
import example.saadat.com.ewlmerge.CategoryMenu.KitchenApp;
import example.saadat.com.ewlmerge.CategoryMenu.MobsTabs;
import example.saadat.com.ewlmerge.CategoryMenu.MoreOption;
import example.saadat.com.ewlmerge.CategoryMenu.SmartphoneList;
import example.saadat.com.ewlmerge.R;


public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener {

    SliderLayout mDemoSlider;
    Button signin;
    TabLayout tabLayout;
    NoScrollableViewPager viewPager;


    GridView androidGridView;

    String[] gridViewString = {
            "Smartphone", "Laptops & Desktops", "Accessories", "Kitchen Appliances", "Audio & Video",
            "Mobiles & Tabs", "Home Appliances", "More..."

    } ;
    int[] gridViewImageId = {
            R.drawable.smtp, R.drawable.ic4, R.drawable.acss, R.drawable.ic2, R.drawable.anv,
            R.drawable.mmtb, R.drawable.ic5, R.drawable.ic6

    };

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        signin = (Button) rootView.findViewById(R.id.btn_signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"You are signed out.",Toast.LENGTH_SHORT).show();
                signin.setVisibility(View.INVISIBLE);
                /*Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);*/

            }
        });

        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getActivity(), gridViewString, gridViewImageId);
        androidGridView=(GridView) rootView.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                //Toast.makeText(getActivity(), "GridView Item: " + gridViewString[+i], Toast.LENGTH_SHORT).show();
                switch (i){
                    case 0: {
                        Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();

                        SmartphoneList smt = new SmartphoneList();
                        FragmentManager fg = getFragmentManager();
                        FragmentTransaction ft = fg.beginTransaction();
                        //ft.replace(R.id.sm_list, fg);
                        ft.add(R.id.container_body, smt, "smart");
                        ft.commit();
                    }
                    break;
                    case 1: {Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
                        FragmentPC fpc = new FragmentPC();
                        FragmentManager fg1 = getFragmentManager();
                        FragmentTransaction ft1 = fg1.beginTransaction();
                        //ft.replace(R.id.sm_list, fg);
                        ft1.add(R.id.container_body, fpc, "pc");
                        ft1.commit();
                    }
                    break;
                    case 2: {Toast.makeText(getActivity(), "3", Toast.LENGTH_SHORT).show();
                        Accessories smt = new Accessories();
                        FragmentManager fg = getFragmentManager();
                        FragmentTransaction ft = fg.beginTransaction();
                        //ft.replace(R.id.sm_list, fg);
                        ft.add(R.id.container_body, smt, "accs");
                        ft.commit();
                    }
                    break;
                    case 3: {Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                        KitchenApp smt = new KitchenApp();
                        FragmentManager fg = getFragmentManager();
                        FragmentTransaction ft = fg.beginTransaction();
                        //ft.replace(R.id.sm_list, fg);
                        ft.add(R.id.container_body, smt, "smart");
                        ft.commit();
                    }
                    break;
                    case 4: {Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
                        AudioVideo smt = new AudioVideo();
                        FragmentManager fg = getFragmentManager();
                        FragmentTransaction ft = fg.beginTransaction();
                        //ft.replace(R.id.sm_list, fg);
                        ft.add(R.id.container_body, smt, "smart");
                        ft.commit();
                    }
                    break;
                    case 5: {Toast.makeText(getActivity(), "3", Toast.LENGTH_SHORT).show();
                        MobsTabs smt = new MobsTabs();
                        FragmentManager fg = getFragmentManager();
                        FragmentTransaction ft = fg.beginTransaction();
                        //ft.replace(R.id.sm_list, fg);
                        ft.add(R.id.container_body, smt, "smart");
                        ft.commit();
                    }
                    break;
                    case 6: {
                        Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
                        HomeApp smt = new HomeApp();
                        FragmentManager fg = getFragmentManager();
                        FragmentTransaction ft = fg.beginTransaction();
                        //ft.replace(R.id.sm_list, fg);
                        ft.add(R.id.container_body, smt, "smart");
                        ft.commit();
                        break;
                    }
                    case 7: {
                        Toast.makeText(getActivity(), "3", Toast.LENGTH_SHORT).show();
                        MoreOption smt = new MoreOption();
                        FragmentManager fg = getFragmentManager();
                        FragmentTransaction ft = fg.beginTransaction();
                        //ft.replace(R.id.sm_list, fg);
                        ft.add(R.id.container_body, smt, "smart");
                        ft.commit();
                        break;
                    }


                }
            }
        });

        setHasOptionsMenu(true);
        mDemoSlider = (SliderLayout)rootView.findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<>();
        file_maps.put("Laptops",R.drawable.im1);
        file_maps.put("Smartphones",R.drawable.im8);
        file_maps.put("Android",R.drawable.im10);
        file_maps.put("hps", R.drawable.im3);
        file_maps.put("Smartphones",R.drawable.im9);
        file_maps.put("Android",R.drawable.im12);
        file_maps.put("hps", R.drawable.im7);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            // textSliderView.getBundle().putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(2000);
        mDemoSlider.addOnPageChangeListener(this);

        // all codes...

        // tab+viewpager

        viewPager = (NoScrollableViewPager) rootView.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomAdapter(getChildFragmentManager(),getActivity().getApplicationContext()));

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabview);
        tabLayout.setupWithViewPager(viewPager);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    private class CustomAdapter extends FragmentPagerAdapter {

        private String fragments [] = {"Recommended","For you"};
//        private Context context;
        /*private int[] imageResId = {
                R.drawable.ic_search,
                R.drawable.ic_refresh
        };*/



        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {

            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Recommended();
                case 1:
                    return new ForYou();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return fragments[position];
        }
    }
}
