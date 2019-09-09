package com.moshaf.yasmeen.project1_quraan.Adapters;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moshaf.yasmeen.project1_quraan.Model.Model_sewrQuraan;
import com.moshaf.yasmeen.project1_quraan.R;

/**
 * Created by Yasmeen on 1/29/2019.
 */

public class QuraanAdapter extends RecyclerView.Adapter<QuraanAdapter.viewHolder> {
String[]items;

    public void setOnItemClickLisnter(OnItemClickLisnter onItemClickLisnter) {
        this.onItemClickLisnter = onItemClickLisnter;
    }

    OnItemClickLisnter onItemClickLisnter;


    public QuraanAdapter(String[] items) {
        this.items = items;
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sewr_quraan_item,parent,false);
       return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {
        holder.soret_quraan.setText(Model_sewrQuraan.ArSuras[position]);
if(onItemClickLisnter!=null)
{
    Log.e("Quraan","AA");
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

    class viewHolder extends RecyclerView.ViewHolder{
TextView soret_quraan;
        TextView esm_Elsora;
    public viewHolder(
            View itemView) {
        super(itemView);
    soret_quraan=itemView.findViewById(R.id.soret_quran);
esm_Elsora=itemView.findViewById(R.id.esm_elsora);
    }
}
public interface OnItemClickLisnter {

      void OnItem(int pos);


}


}
