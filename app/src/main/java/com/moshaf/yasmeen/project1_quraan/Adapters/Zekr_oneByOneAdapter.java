package com.moshaf.yasmeen.project1_quraan.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.moshaf.yasmeen.project1_quraan.Model.Model_Azkar;
import com.moshaf.yasmeen.project1_quraan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yasmeen on 6/29/2019.
 */

public class Zekr_oneByOneAdapter extends RecyclerView.Adapter<Zekr_oneByOneAdapter.viewHolder> {
    List<Model_Azkar> arraylist_azkar_items;
    public Zekr_oneByOneAdapter(ArrayList<Model_Azkar> arraylist_azkar_items) {
        this.arraylist_azkar_items = arraylist_azkar_items;
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.azkar_item_one_by_one,parent,false);




        return new viewHolder(view);
    }

    public void ChangeData(List<Model_Azkar> items)
    {
       arraylist_azkar_items=items;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        final Model_Azkar model_azkar=arraylist_azkar_items.get(position);
        holder.count.setText(model_azkar.getCount());
        holder.tv_title.setText(model_azkar.getTitle());
        holder.tv_desc.setText(model_azkar.getDesc());

        holder.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int  RealQuantity=Integer.parseInt(model_azkar.getCount());
                Log.e("REal",RealQuantity+"");
                holder.count.setText(String.valueOf(RealQuantity));
            }
        });


        holder.count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity=Integer.parseInt(holder.count.getText().toString());
                if(quantity>0)
                {
                    quantity--;
                    holder.count.setText(String.valueOf(quantity));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arraylist_azkar_items.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
Button count;
ImageView reset;
TextView tv_title,tv_desc;
        public viewHolder(View itemView) {
            super(itemView);
            count=itemView.findViewById(R.id.count_ofzekr);
            tv_title=itemView.findViewById(R.id.title_zekr);
            tv_desc=itemView.findViewById(R.id.desc_zekr);
            reset=itemView.findViewById(R.id.reset_zekr);

        }
    }


}
