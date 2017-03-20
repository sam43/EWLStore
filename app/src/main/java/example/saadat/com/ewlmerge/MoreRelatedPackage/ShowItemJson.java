package example.saadat.com.ewlmerge.MoreRelatedPackage;


import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

import example.saadat.com.ewlmerge.Adapters.CartAdapter;
import example.saadat.com.ewlmerge.JSONConfigPozo.ConfigProduct;
import example.saadat.com.ewlmerge.R;


/**
 * Created by Saadat on 11/3/2016.
 */
public class ShowItemJson extends AppCompatActivity {

    private Random mRandom = new Random();
    private ArrayList<String> cartList = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView rv;

    TextView p_price, n_price, productName;
    ImageView fav, proImage;
    Button add_to_cart, buy_now;
    Boolean flag = false;
    Context context;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details_page);

        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        String pro_name = bundle.getString(ConfigProduct.TAG_NAME);
        String disPrice = bundle.getString(ConfigProduct.TAG_NEW_PRICE);
        String oldPrice = bundle.getString(ConfigProduct.TAG_OLD_PRICE);
        String bitmap = intent.getStringExtra("image");

        proImage = (ImageView) findViewById(R.id.product_image);
        Picasso.with(context)
                .load(bitmap)
                .placeholder(R.drawable.loading)
                .error(R.drawable.notfound)
                .into(proImage);

        productName = (TextView) findViewById(R.id.pro_name);
        productName.setText(pro_name);
        n_price = (TextView) findViewById(R.id.price_new);
        n_price.setText(disPrice);
        p_price = (TextView) findViewById(R.id.price_old);
        p_price.setText(oldPrice);
        p_price.setPaintFlags(p_price.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        fav = (ImageView) findViewById(R.id.fav);

       /*Picasso.with(context)
                .load(String.valueOf(bmp))
                .placeholder(R.drawable.loading)
                .error(R.drawable.notfound)
                .into(proImage);*/

        //onClick buttons

        add_to_cart = (Button) findViewById(R.id.add_to_cart);
        buy_now = (Button) findViewById(R.id.buy_now);

        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItemToCart();
                /*int position = 0;
                String itemLabel = "" + mRandom.nextInt(100);
                cartList.add(position, "" + itemLabel);
                mAdapter.notifyItemInserted(position);
                rv.scrollToPosition(position);*/
                Toast.makeText(ShowItemJson.this,"Your item has been added to the Cart.", Toast.LENGTH_SHORT).show();
            }
        });

        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowItemJson.this, CheckOutActivity.class);
                startActivity(intent);

            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.include);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag)
                {
                    fav.setImageResource(R.drawable.heart_outline);
                    flag = false;

                    addItem();


                } else {
                    fav.setImageResource(R.drawable.heart);
                    flag = true;
                }

            }
        });
    }
    private void addItemToCart() {

        /*int position = 0;
        String itemLabel = "" + mRandom.nextInt(100);
        cartList.add(position, "" + itemLabel);
        mAdapter.notifyItemInserted(position);
        rv.scrollToPosition(position);*/

    }


    private void addItem() {

        //write function to add wishlist

    }
}
