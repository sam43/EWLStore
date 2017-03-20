package example.saadat.com.ewlmerge.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.Model.Data;
import example.saadat.com.ewlmerge.R;

/**
 * Created by Saadat on 9/5/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    static Context cxt;

    private ArrayList<Data> arrayList = new ArrayList<Data>();


    public RecyclerAdapter(Context context, ArrayList<Data> arrayList) {
        this.cxt = context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, null);

        //Creating view Holder

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Data data = arrayList.get(position);
        holder.imageView.setImageResource(data.getImg());
        holder.tit1.setText(data.getTitle1());
        holder.new_price.setText(data.getTitle2());
        holder.old_price.setText(data.getTitle3());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        RatingBar ratingBar;
        TextView tit1, new_price, old_price;
        Button btnmore;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.thumbnail);
            tit1 = (TextView) itemView.findViewById(R.id.product_name);
            new_price = (TextView) itemView.findViewById(R.id.n_price);
            old_price = (TextView) itemView.findViewById(R.id.p_price);

            old_price.setPaintFlags(old_price.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        //    ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
            //btnmore = (Button) itemView.findViewById(R.id.button);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(cxt, ShowItem.class);
                    cxt.startActivity(i);
                }
            });


        }
    }
}