package example.saadat.com.ewlmerge.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.JSONConfigPozo.ConfigProduct;
import example.saadat.com.ewlmerge.Model.Beanclass;
import example.saadat.com.ewlmerge.MoreRelatedPackage.ShowItemJson;
import example.saadat.com.ewlmerge.R;


public class GridviewAdapter extends BaseAdapter {

    Context context;

    ArrayList<Beanclass> bean;
//    Typeface fonts1, fonts2;


    public GridviewAdapter(Context context, ArrayList<Beanclass> bean) {
        this.bean = bean;
        this.context = context;
    } //create constructor


    //getters and setters for the data sources

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        Beanclass dataBind = bean.get(position);

        ViewHolder viewHolder;


        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.product_gridview, null);
            viewHolder = new ViewHolder();

            viewHolder.image1 = (ImageView) convertView.findViewById(R.id.image1);
            viewHolder.title1 = (TextView) convertView.findViewById(R.id.title1);
            viewHolder.discription1 = (TextView) convertView.findViewById(R.id.description1);
            viewHolder.date1 = (TextView) convertView.findViewById(R.id.date1);
            viewHolder.date1.setPaintFlags(viewHolder.date1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            convertView.setTag(viewHolder);


        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String productName = ((TextView) view.findViewById(R.id.title1)).getText().toString();
                String discountedPrice = ((TextView) view.findViewById(R.id.description1)).getText().toString();
                String previousPrice = ((TextView) view.findViewById(R.id.date1)).getText().toString();
                //ImageView imageView = (ImageView) view.findViewById(R.id.image1);
                //Bitmap image = imageView.getDrawingCache();
                //Bundle bundle = new Bundle();



                Intent in = new Intent(context, ShowItemJson.class);
                String bitmap = bean.get(position).getImage1();
                /*bundle.putString(productName, ConfigProduct.TAG_IMAGE);
                bundle.putString(discountedPrice, ConfigProduct.TAG_NEW_PRICE);
                bundle.putString(previousPrice, ConfigProduct.TAG_OLD_PRICE);*/

                in.putExtra("image", bitmap);
                in.putExtra(ConfigProduct.TAG_NAME, productName);
                in.putExtra(ConfigProduct.TAG_NEW_PRICE, discountedPrice);
                in.putExtra(ConfigProduct.TAG_OLD_PRICE, previousPrice);
                context.startActivity(in);

            }
        });

        Picasso.with(context)
                .load(dataBind.getImage1())
                .placeholder(R.drawable.loading)
                .error(R.drawable.notfound)
                .into(viewHolder.image1);

        //viewHolder.image1.setImageResource(bean.getImage1());
        viewHolder.title1.setText(dataBind.getTitle1());
        viewHolder.discription1.setText("BDT "+dataBind.getDiscription1());
        viewHolder.date1.setText("BDT " + dataBind.getDate1());

        return convertView;
    }

    private class ViewHolder {
        ImageView image1;
        TextView title1;
        TextView discription1;
        TextView date1;

    }
}