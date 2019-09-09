package com.moshaf.yasmeen.project1_quraan.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moshaf.yasmeen.project1_quraan.Model.Model_AhadesName;
import com.moshaf.yasmeen.project1_quraan.R;

/**
 * Created by Yasmeen on 2/7/2019.
 */

public class Ahades_Adapter extends RecyclerView.Adapter<Ahades_Adapter.viewHolder> {
    String[] items;

    public void setOnItemClickLisnter(OnItemClickLisnter onItemClickLisnter) {
        this.onItemClickLisnter = onItemClickLisnter;
    }

    OnItemClickLisnter onItemClickLisnter;


    public Ahades_Adapter(String[] items) {
        this.items = items;
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hadeth_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {
        holder.Haidth_Name.setText(Model_AhadesName.AhadesName[position]);
        if (onItemClickLisnter != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickLisnter.OnItem(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ImageView Hadith_image;
        TextView Haidth_Name;

        public viewHolder(
                View itemView) {
            super(itemView);
            //Hadith_image = itemView.findViewById(R.id.sora_background_haidth);
            Haidth_Name = itemView.findViewById(R.id.Haidith_name_textview);

        }
    }

    public interface OnItemClickLisnter {

        void OnItem(int pos);


    }
}
