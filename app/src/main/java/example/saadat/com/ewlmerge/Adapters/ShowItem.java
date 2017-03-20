package example.saadat.com.ewlmerge.Adapters;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import example.saadat.com.ewlmerge.R;


/**
 * Created by Saadat on 11/3/2016.
 */
public class ShowItem extends AppCompatActivity {

    TextView p_price;
    ImageView fav;
    Boolean flag = false;

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

        p_price = (TextView) findViewById(R.id.price_old);
        p_price.setPaintFlags(p_price.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        fav = (ImageView) findViewById(R.id.fav);


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

    private void addItem() {
    }
}
