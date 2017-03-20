package example.saadat.com.ewlmerge.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import example.saadat.com.ewlmerge.Model.DataCart;
import example.saadat.com.ewlmerge.R;

/**
 * Created by Saadat on 11/27/2016.
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    static Context cxt;
    private ArrayList<DataCart> cartList = new ArrayList<>();

    Spinner spinner;

    ArrayAdapter<CharSequence> spin_adapter;


    public CartAdapter(Context context, ArrayList<DataCart> cartList) {
        this.cxt = context;
        this.cartList = cartList;
    }

    @Override
    public CartAdapter.CartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_single_item, parent, false);
        spinner = (Spinner) v.findViewById(R.id.spinner);

        spin_adapter = ArrayAdapter.createFromResource(cxt, R.array.spinner, android.R.layout.simple_spinner_item);
        spin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spin_adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(cxt, "You selected " + (position + 1), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Toast.makeText(cxt, " Select a quantity!", Toast.LENGTH_SHORT).show();

            }
        });

        return new CartHolder(v);
    }

    @Override
    public void onBindViewHolder(CartAdapter.CartHolder holder, int position) {

        DataCart dataCart = cartList.get(position);
        holder.imageView.setImageResource(dataCart.getImg());
        holder.pro_name.setText(dataCart.getProductName());
        holder.new_price.setText(dataCart.getNewPrice());
        holder.pre_price.setText(dataCart.getPrePrice());

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class CartHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView pro_name, new_price, pre_price;
        Button delete;

        public CartHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.pro_image);
            pro_name = (TextView) itemView.findViewById(R.id.prod_name);
            new_price = (TextView) itemView.findViewById(R.id.n_price);
            pre_price = (TextView) itemView.findViewById(R.id.p_price);
            pre_price.setPaintFlags(pre_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            delete = (Button) itemView.findViewById(R.id.delete);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int c_position = getAdapterPosition();

                    try {
                        cartList.remove(c_position);
                        //notifyDataSetChanged();
                        notifyItemRemoved(c_position);
                        Toast.makeText(cxt, "The item has been removed!", Toast.LENGTH_LONG).show();
                    } catch (ArrayIndexOutOfBoundsException e)
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
