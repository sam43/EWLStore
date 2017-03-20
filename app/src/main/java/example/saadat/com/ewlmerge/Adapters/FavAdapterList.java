package example.saadat.com.ewlmerge.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.Model.DataFav;
import example.saadat.com.ewlmerge.R;

/**
 * Created by Saadat on 11/24/2016.
 */

public class FavAdapterList extends RecyclerView.Adapter<FavAdapterList.ViewHolder> {

    static Context cxt;

    private ArrayList<DataFav> favList = new ArrayList<>();


    public FavAdapterList(Context context, ArrayList<DataFav> favList) {
        this.cxt = context;
        this.favList = favList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_single_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //int currentPosition = position;
        //Info

       /* holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItem(position, InfoData);
            }
        });*/

        DataFav dataFav = favList.get(position);
        holder.imageView.setImageResource(dataFav.getImg());
        holder.pro_name.setText(dataFav.getProductName());
        holder.new_price.setText(dataFav.getNewPrice());
        holder.pre_price.setText(dataFav.getPrePrice());
        holder.discount.setText(dataFav.getDiscount());


    }


    @Override
    public int getItemCount() {
        return favList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, remove;
        TextView pro_name, new_price, pre_price, discount;
        Button buy;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.pro_image);
            remove = (ImageView) itemView.findViewById(R.id.remove);
            pro_name = (TextView) itemView.findViewById(R.id.pro_name);
            new_price = (TextView) itemView.findViewById(R.id.new_price);
            pre_price = (TextView) itemView.findViewById(R.id.p_price);
            pre_price.setPaintFlags(pre_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            discount = (TextView) itemView.findViewById(R.id.discount);
            buy = (Button) itemView.findViewById(R.id.buy_button);


            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int currPosition = getAdapterPosition();
                    try {
                        favList.remove(currPosition);
                        notifyItemRemoved(currPosition);
                    }catch
                            (ArrayIndexOutOfBoundsException e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
