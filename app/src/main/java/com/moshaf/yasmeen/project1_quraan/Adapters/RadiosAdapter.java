package com.moshaf.yasmeen.project1_quraan.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moshaf.yasmeen.project1_quraan.R;

import java.util.List;

import com.moshaf.yasmeen.project1_quraan.API.Model.RadiosItem;

/**
 * Created by Yasmeen on 2/13/2019.
 */

public class RadiosAdapter extends RecyclerView.Adapter<RadiosAdapter.viewHolder> {
List<RadiosItem>channels;
   public static Boolean play2=false;

OnItemClickLisnter OnPlayClickLisnter;

    public void setOnPlayClickLisnter(OnItemClickLisnter onPlayClickLisnter) {
        OnPlayClickLisnter = onPlayClickLisnter;
    }

    public void setOnStopClickLisnter(OnItemClickLisnter onStopClickLisnter) {
        OnStopClickLisnter = onStopClickLisnter;
    }

    OnItemClickLisnter OnStopClickLisnter;
    public RadiosAdapter(List<RadiosItem> channels) {
        this.channels = channels;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio_channel,parent,false);


return new viewHolder(view);
    }
public void ChangeData(List<RadiosItem> items)
{
this.channels=items;
notifyDataSetChanged();


}







    boolean play;
    @Override
    public void onBindViewHolder(final viewHolder holder, final int position) {
play=false;
        final RadiosItem channel= channels.get(position);

        holder.img_play.setImageResource(R.drawable.playbutton);
holder.tv_channels.setText(channel.getName());

if(OnPlayClickLisnter !=null || play)
{

    holder.img_play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            play=!play;
            play2=play;
            OnPlayClickLisnter.OnItem(position,channel);


            for(int i=0;i<channels.size();i++)
            {
                if(i!=position)
                {
                    notifyItemChanged(i);
                }
            }


            Log.e("play",play+" ");
            if(play==false) {
                holder.img_play.setImageResource(R.drawable.playbutton);
            }
            else if(play==true)
            {
                holder.img_play.setImageResource(R.drawable.pause);
            }
        }
    });
}

        if(OnStopClickLisnter !=null)
        {
            holder.img_stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnStopClickLisnter.OnItem(position,channel);
                    holder.img_play.setImageResource(R.drawable.playbutton);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        if(channels==null)
        {
             return 0;
        }
        return channels.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{

TextView tv_channels;
ImageView img_play,img_stop;

    public viewHolder(View itemView) {
        super(itemView);
tv_channels=itemView.findViewById(R.id.tv_asamyElChannels);
img_play=itemView.findViewById(R.id.ic_play_music);
img_stop=itemView.findViewById(R.id.ic_stop_music);

    }
}
    public interface OnItemClickLisnter {

        void OnItem(int pos,RadiosItem name);


    }

}
