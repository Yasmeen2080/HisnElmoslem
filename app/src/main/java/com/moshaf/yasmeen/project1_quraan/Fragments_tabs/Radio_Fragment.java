package com.moshaf.yasmeen.project1_quraan.Fragments_tabs;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;
import com.moshaf.yasmeen.project1_quraan.Adapters.RadiosAdapter;
import com.moshaf.yasmeen.project1_quraan.R;

import com.moshaf.yasmeen.project1_quraan.API.Api_Manager;
import com.moshaf.yasmeen.project1_quraan.API.Model.RadioResponse;
import com.moshaf.yasmeen.project1_quraan.API.Model.RadiosItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;
import static com.moshaf.yasmeen.project1_quraan.Adapters.RadiosAdapter.play2;

/**
 * A simple {@link Fragment} subclass.
 */
public class Radio_Fragment extends Fragment {

    RecyclerView recyclerView2;
    RadiosAdapter adapter;
    MediaPlayer mediaplayer;

    private SimpleExoPlayer exoPlayer;
        LinearLayoutManager layoutmanager;
    TextView textView;
    public Radio_Fragment() {
        // Required empty public constructoor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_radio_, container, false);

        textView = view.findViewById(R.id.text);
        recyclerView2 = view.findViewById(R.id.recycler_view_radio_api);
        layoutmanager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        adapter = new RadiosAdapter(null);
        recyclerView2.setAdapter(adapter);
        recyclerView2.setLayoutManager(layoutmanager);
        adapter.setOnPlayClickLisnter(new RadiosAdapter.OnItemClickLisnter() {
            @Override
            public void OnItem(int pos, RadiosItem radiosItem) {
                if(play2==false)
                {
                    Log.e("Radio off","umm");
                    ReleaseExoplayer();
                }
                else {
                    ReleaseExoplayer();
                    playChannelUsingExoPlayer(radiosItem.getURL());
                    Log.e("Radio oN","umm");
                }
            }
        });
        adapter.setOnStopClickLisnter(new RadiosAdapter.OnItemClickLisnter() {
            @Override
            public void OnItem(int pos, RadiosItem name) {
ReleaseExoplayer();
            }
        });
        getRadioChannels();

        return view;

    }

    void playChannelUsingExoPlayer(String uri)
    {

DefaultRenderersFactory defaultRenderersFactory=new DefaultRenderersFactory(getContext(),null,DefaultRenderersFactory.EXTENSION_RENDERER_MODE_OFF);
DefaultTrackSelector trackSelector=new DefaultTrackSelector();
exoPlayer=ExoPlayerFactory.newSimpleInstance(defaultRenderersFactory,trackSelector);
String useragent =Util.getUserAgent(getContext(),"Project1_Quraan");
//ExtractorMediaSource mediaSource =new ExtractorMediaSource(uri, new DefaultDataSourceFactory(getContext(),useragent), new DefaultExtractorsFactory(),null,null);
        MediaSource mediaSource=new ExtractorMediaSource(Uri.parse(uri),new DefaultDataSourceFactory(getContext(),useragent),new DefaultExtractorsFactory(),null,null);
    exoPlayer.prepare(mediaSource);
    exoPlayer.setPlayWhenReady(true);

    }

    @Override
    public void onPause() {
        super.onPause();
   Log.e("Pause","Pause");
   ReleaseExoplayer();
    }

    void ReleaseExoplayer()
{
    if(exoPlayer!=null)
    exoPlayer.stop();
}

    @Override
    public void onResume() {
        super.onResume();
    Log.e("Resume","Resumed");

    }

    @Override
    public void onStart() {
        super.onStart();
    Log.e("Started","Started");




    }

    //using MediaPlayer
public void PlayChannel(String Url)
{
StopPlay();
mediaplayer=new MediaPlayer();
    mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

try {
    mediaplayer.setDataSource(Url);
    mediaplayer.prepare();

    mediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.start();
        }
    });
}
catch (Exception ex)
{
    Toast.makeText(getContext(),Toast.LENGTH_LONG,Toast.LENGTH_LONG).show();
}

}
public void StopPlay()
{
    if(mediaplayer!=null)
        mediaplayer.stop();
}

        void getRadioChannels(){
        Api_Manager.getApi().getAllRadioChannels().enqueue(new Callback<RadioResponse>() {
            @Override
            public void onResponse(Call<RadioResponse> call, Response<RadioResponse> response) {
                if(response.isSuccessful())
                {
adapter.ChangeData(response.body().getRadios());
                }

            }

            @Override
            public void onFailure(Call<RadioResponse> call, Throwable t) {
                Toast.makeText(getContext(),"No Internet Connection!",Toast.LENGTH_LONG).show();
            }
        });


    }

}
