package example.saadat.com.ewlmerge;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import example.saadat.com.ewlmerge.Adapters.ExpandableListAdapter;
import example.saadat.com.ewlmerge.AppIntro.WelcomeActivity;
import example.saadat.com.ewlmerge.Authentications.LoginActivity;
import example.saadat.com.ewlmerge.Authentications.SignupActivity;
import example.saadat.com.ewlmerge.BottomMenuActivities.FragmentCart;
import example.saadat.com.ewlmerge.BottomMenuActivities.FragmentFav;
import example.saadat.com.ewlmerge.BottomMenuActivities.FragmentMore;
import example.saadat.com.ewlmerge.BottomMenuActivities.FragmentProduct;
import example.saadat.com.ewlmerge.Controllers.HomeFragment;
import example.saadat.com.ewlmerge.Model.FragmentDrawer;
import example.saadat.com.ewlmerge.Model.parent;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {


    private Toolbar mToolbar;
    FragmentDrawer drawerFragment;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    ArrayList<parent> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private Integer[] icon = { R.drawable.lap,
            R.drawable.acs,
            R.drawable.ic_ac,
            R.drawable.kap,
            R.drawable.app,
            R.drawable.mtb,

    };


    private String[] name = { "Laptop & Desktop","Accessories","    Home Appliances","Kitchen Appliances","Home Theater","Mobiles & Tabs"};
    // json data files to be added

    final String[] colors = {"#96CC7A", "#EA705D", "#66BBCC", "#fae98d23", "#fd5728b3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(getString(R.string.tab_1), R.drawable.contact_us, Color.parseColor(colors[0]));
        final AHBottomNavigationItem item2 = new AHBottomNavigationItem(getString(R.string.tab_2), R.drawable.ic_store_mall_directory_24dp, Color.parseColor(colors[2]));
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(getString(R.string.tab_3), R.drawable.heart_fav, Color.parseColor(colors[1]));
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(getString(R.string.tab_4), R.drawable.ic_local_restaurant_24dp, Color.parseColor(colors[3]));
        AHBottomNavigationItem item5 = new AHBottomNavigationItem(getString(R.string.tab_5), R.drawable.ic_map_24dp, Color.parseColor(colors[4]));

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
        bottomNavigation.addItem(item5);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        //  Enables Reveal effect
        bottomNavigation.setColored(true);

        bottomNavigation.setCurrentItem(0);
        bottomNavigation.setNotificationBackgroundColor(Color.rgb(252,71,68));
        bottomNavigation.setNotification("0",3);
        bottomNavigation.setNotification("3+",4);
        bottomNavigation.setNotification("5",2);
        bottomNavigation.setNotificationTextColor(Color.parseColor("#ffffff"));

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...

                if (position == 0){
                    Toast.makeText(MainActivity.this,"Welcome Home!", Toast.LENGTH_SHORT).show();
                    /*Intent intent = new Intent(, HomeFragment.class);
                    HomeFragment.this.startActivity(intent);*/
                    Fragment frg = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    //fragmentTransaction.replace();
                    fragmentTransaction.replace(R.id.container_body,frg);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } else if (position == 1){
                    Toast.makeText(MainActivity.this,"You pressed Product", Toast.LENGTH_SHORT).show();
                    Fragment frg = new FragmentProduct();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    //fragmentTransaction.replace();
                    fragmentTransaction.replace(R.id.container_body,frg);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } else if (position == 2){
                    Toast.makeText(MainActivity.this,"Favorites", Toast.LENGTH_SHORT).show();
                    FragmentFav fav = new FragmentFav();
                    FragmentTransaction ftt = getSupportFragmentManager().beginTransaction();
                    ftt.replace(R.id.container_body, fav);
                    ftt.addToBackStack(null);
                    ftt.commit();
                } else if(position == 3){
                    //bottomNavigation.setNotification("", position);
                    FragmentCart fav = new FragmentCart();
                    FragmentTransaction ftt = getSupportFragmentManager().beginTransaction();
                    ftt.replace(R.id.container_body, fav);
                    ftt.addToBackStack(null);
                    ftt.commit();
                    Toast.makeText(MainActivity.this,"My Cart", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    FragmentMore fav = new FragmentMore();
                    FragmentTransaction ftt = getSupportFragmentManager().beginTransaction();
                    ftt.replace(R.id.container_body, fav);
                    ftt.addToBackStack(null);
                    ftt.commit();
                    Toast.makeText(MainActivity.this,"More...", Toast.LENGTH_SHORT).show();
                }
                //fragment.updateColor(Color.parseColor(colors[position]));
            }

        });

        listDataHeader = new ArrayList<parent>();

        for (int i = 0; i < name.length; i++) {

            parent nav = new parent(icon[i],name[i]);

            listDataHeader.add(nav);
        }


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        //mToolbar.setLogo(R.drawable.logo);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        expListView = (ExpandableListView)findViewById(R.id.lvExp);

        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        //Show toast when Parent expanded

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //Toast.makeText(getApplicationContext(),"Clicked finally",Toast.LENGTH_LONG).show();
                //Toast.makeText(getBaseContext(), listDataHeader.get(groupPosition) + "Clicked finally", Toast.LENGTH_SHORT).show();
                //Edit it to make toast for the Category name

                ExpandableListAdapter adapter = (ExpandableListAdapter) expListView.getExpandableListAdapter();
                if (adapter == null) {
                    return;
                }
                for (int i = 0; i < adapter.getGroupCount(); i++) {
                    if (i != groupPosition) {
                        expListView.collapseGroup(i);
                    }

                    expListView.animate();
                }

            }
        });

       /* expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;

                expListView.animate();
            }
        });*/

        //expListView.setAnimation();

        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                expListView.animate();
            }
        });


        //Can be use the "onGroupCollapse" method also...

        //onChildItemClick Listener here

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //code here
                //Toast.makeText(getBaseContext(), listDataChild.get(listDataChild.get(groupPosition)).get(childPosition) + "Clicked Child finally" + listDataHeader.get(groupPosition) + "is selected", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Clicked Child finally",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);
    }

    private void setIcon(Menu menu, int menuItemId, int labelId, int iconId){
        MenuItem item = menu.findItem(menuItemId);
        SpannableStringBuilder builder = new SpannableStringBuilder("           " + getResources().getString(labelId));
        builder.setSpan(new ImageSpan(this,iconId),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        item.setTitle(builder);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        setIcon(menu,R.id.action_location_found,R.string.action_location_found,R.drawable.ic_location);
        setIcon(menu,R.id.action_refresh,R.string.action_refresh,R.drawable.ic_refresh);
        setIcon(menu,R.id.action_check_updates,R.string.action_check_updates,R.drawable.ic_update);
        setIcon(menu,R.id.action_help,R.string.action_help,R.drawable.ic_help);
        setIcon(menu,R.id.action_cart,R.string.action_cart,R.drawable.ic_cart);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.action_search:
                // search action
                return true;
            case R.id.action_location_found:
                // location found
                //LocationFound();
                return true;
            case R.id.action_refresh:
                // refresh
                return true;
            case R.id.action_help:
                // help action
                return true;
            case R.id.action_check_updates:
                // check for updates action

                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
//            getSupportActionBar().setTitle(title);
        }
    }


    private void prepareListData() {
        //listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        List<String> cat1 = new ArrayList<String>();
        cat1.add("MAC");
        cat1.add("ASUS");
        cat1.add("hp");
        cat1.add("Lenovo");
        cat1.add("Dell");


        List<String> cat2 = new ArrayList<String>();
        cat2.add("Hard Disc");
        cat2.add("Router");
        cat2.add("Adapters");
        cat2.add("Speaker");
        cat2.add("Keyboard & Mouse");
        cat2.add("Chill Mat");
        cat2.add("Headphones");
        cat2.add("USB Devices");
        cat2.add("Power Bank");
        cat2.add("JBL");
        cat2.add("Mobile Accessories");
        cat2.add("Bose");


        List<String> cat3 = new ArrayList<String>();
        cat3.add("Air Conditioner");
        cat3.add("Refrigerator");
        cat3.add("Washing Machine");
        cat3.add("Small Appliances");
        cat3.add("Panasonic");
        cat3.add("LG");
        cat3.add("EWL");
        cat3.add("Sharp");
        cat3.add("Samsung");
        cat3.add("Toshiba");


        List<String> cat4 = new ArrayList<String>();
        cat4.add("Large Appliance");
        cat4.add("Small Appliance");
        cat4.add("Oven");
        cat4.add("Cooker");
        cat4.add("Water Filter");
        cat4.add("Sharp");
        cat4.add("Panasonic");
        cat4.add("EWL");


        List<String> cat5 = new ArrayList<String>();
        cat5.add("Home Cinema & DVD");
        cat5.add("Audio");
        cat5.add("Recorder & Karaoke");
        cat5.add("BOSE & JBL");
        cat5.add("Headphones");

        List<String> cat6 = new ArrayList<String>();
        cat6.add("ASUS");
        cat6.add("Samsung");
        cat6.add("HTC");
        cat6.add("iPhone");
        cat6.add("Oppo");
        cat6.add("Huawei");

        listDataChild.put(listDataHeader.get(0).getName(), cat1); // Header, Child data
        listDataChild.put(listDataHeader.get(1).getName(), cat2);
        listDataChild.put(listDataHeader.get(2).getName(), cat3);
        listDataChild.put(listDataHeader.get(3).getName(), cat4);
        listDataChild.put(listDataHeader.get(4).getName(), cat5);
        listDataChild.put(listDataHeader.get(5).getName(), cat6);
    }


  /*  boolean doubleBackToExit = false;

    @Override
    public void onBackPressed() {

        // We implements here our logic
        //this.createDialog();

        if(doubleBackToExit) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExit = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExit = false;
            }
        }, 2000);

    }*/
/*

    //use the method to call alert dialog................


    private void createDialog() {

        AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);



        alertDlg.setMessage("Are you sure you want to exit?");

        alertDlg.setCancelable(false); // We avoid that the dialong can be cancelled, forcing the user to choose one of the options



        alertDlg.setPositiveButton("Yes", new DialogInterface.OnClickListener() {



                    public void onClick(DialogInterface dialog, int id) {

                        MainActivity.super.onBackPressed();
                        finish();

                    }

                }

        );

        alertDlg.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                // We do nothing

            }

        });

        alertDlg.create().show();
    }*/
}