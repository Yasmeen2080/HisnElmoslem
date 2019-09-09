package com.moshaf.yasmeen.project1_quraan.Adapters;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moshaf.yasmeen.project1_quraan.Activities.Sora_Kamla;
import com.moshaf.yasmeen.project1_quraan.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Yasmeen on 2/7/2019.
 */

public class LineByLineAdapter extends RecyclerView.Adapter<LineByLineAdapter.viewHolder> {
    public LineByLineAdapter(List<String> items) {
        this.items = items;
    }
    List<String> items;
 public  static int selectedpos=10500;
public static Boolean checkvalue=false;
   public static String markthisLine;
    public static int positionTransfer;

    public LineByLineAdapter() {
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
View view=        LayoutInflater.from(parent.getContext()).inflate(R.layout.soraa_line_item,parent,false);


    return new viewHolder(view);
    }
    @Override
    public void onBindViewHolder(final viewHolder holder, final int position) {
        int anotherpos=position+1;

        Log.e("Another",anotherpos+" ");
        holder.tv_line.setText(items.get(position));


        Log.e("Ok",items.get(position)+" ");
        markthisLine=items.get(position);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    selectedpos = position;
                    Log.e("remove pos", selectedpos + " ");
                    notifyDataSetChanged();



                }
            });
        if (selectedpos != position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#00ffffff"));
        } else {

            holder.itemView.setBackgroundColor(Color.parseColor("#FFA39064"));


        }

                Log.e("new Pos", anotherpos+" ");
            NumberFormat nf = NumberFormat.getInstance(new Locale("ar", "EG"));
            holder.tv_aya_aya.setText(String.valueOf(nf.format(anotherpos)));



        }


    @Override
    public int getItemCount() {
        return items.size();
    }
    class viewHolder extends RecyclerView.ViewHolder {

        TextView tv_line;
 TextView tv_aya_aya;
ImageView img;
        public viewHolder(View itemView) {
            super(itemView);
            tv_aya_aya=itemView.findViewById(R.id.AyahAyahQuran);
            tv_line = itemView.findViewById(R.id.sora_line_item);
            img=itemView.findViewById(R.id.islam);
        }
    }


}
