package example.saadat.com.ewlmerge.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.Model.PcBeans;
import example.saadat.com.ewlmerge.R;

/**
 * Created by Saadat on 11/14/2016.
 */

public class PcsListAdapter extends BaseAdapter {

    Context context;

    ArrayList<PcBeans> bean;
//    Typeface fonts1, fonts2;


    public PcsListAdapter(Context context, ArrayList<PcBeans> bean) {
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
    public View getView(int position, View convertView, ViewGroup parent) {

        PcsListAdapter.ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.product_gridview, null);

            viewHolder = new PcsListAdapter.ViewHolder();

            viewHolder.image1 = (ImageView) convertView.findViewById(R.id.image1);
            viewHolder.title1 = (TextView) convertView.findViewById(R.id.title1);
            viewHolder.discription1 = (TextView) convertView.findViewById(R.id.description1);
            viewHolder.date1 = (TextView) convertView.findViewById(R.id.date1);

            convertView.setTag(viewHolder);


        } else {

            viewHolder = (PcsListAdapter.ViewHolder) convertView.getTag();
        }


        PcBeans bean = (PcBeans) getItem(position);

        viewHolder.image1.setImageResource(bean.getImage1());
        viewHolder.title1.setText(bean.getTitle1());
        viewHolder.discription1.setText(bean.getDiscription1());
        viewHolder.date1.setText(bean.getDate1());


        return convertView;
    }

    private class ViewHolder {
        ImageView image1;
        TextView title1;
        TextView discription1;
        TextView date1;

    }
}