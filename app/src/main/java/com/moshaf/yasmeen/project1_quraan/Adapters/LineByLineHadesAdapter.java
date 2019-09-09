package com.moshaf.yasmeen.project1_quraan.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moshaf.yasmeen.project1_quraan.R;

import java.util.List;

/**
 * Created by Yasmeen on 2/7/2019.
 */

public class LineByLineHadesAdapter extends RecyclerView.Adapter<LineByLineHadesAdapter.viewHolder>
{
    public LineByLineHadesAdapter(List<String> items) {
        this.items = items;
    }

    List<String> items;

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=        LayoutInflater.from(parent.getContext()).inflate(R.layout.linebylinehades,parent,false);
    return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.tv_hades.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
TextView tv_hades;

        public viewHolder(View itemView) {
            super(itemView);
        tv_hades=itemView.findViewById(R.id.Elhadith_Kamel);

        }
    }


}