package com.moshaf.yasmeen.project1_quraan.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.moshaf.yasmeen.project1_quraan.Model.Model_Azkar_Name;
import com.moshaf.yasmeen.project1_quraan.R;

/**
 * Created by Yasmeen on 6/25/2019.
 */

public class azkar_Adapter extends RecyclerView.Adapter<azkar_Adapter.viewHolder>{
    String[] items;
    private ItemClickListener onItemClickListener;
    public void setItemClickListener(ItemClickListener clickListener) {
        onItemClickListener = clickListener;
    }

    public azkar_Adapter(String[] items) {
        this.items = items;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.azkar_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {
        holder.zekr.setText(Model_Azkar_Name.azkarnames[position]);
        holder.zekr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    class viewHolder extends RecyclerView.ViewHolder{
Button zekr;

        public viewHolder(View itemView) {
            super(itemView);
            zekr=itemView.findViewById(R.id.zekr);

        }

    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }
}
