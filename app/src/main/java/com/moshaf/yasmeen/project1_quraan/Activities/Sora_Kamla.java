package com.moshaf.yasmeen.project1_quraan.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.moshaf.yasmeen.project1_quraan.Adapters.LineByLineAdapter;
import com.moshaf.yasmeen.project1_quraan.R;
import com.moshaf.yasmeen.project1_quraan.Splash_screen.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import static com.moshaf.yasmeen.project1_quraan.Adapters.LineByLineAdapter.checkvalue;
import static com.moshaf.yasmeen.project1_quraan.Adapters.LineByLineAdapter.markthisLine;
import static com.moshaf.yasmeen.project1_quraan.Adapters.LineByLineAdapter.positionTransfer;
import static com.moshaf.yasmeen.project1_quraan.Adapters.LineByLineAdapter.selectedpos;

public class Sora_Kamla extends AppCompatActivity {
    TextView ElsoraKamla,EsmElsoraKamla;
    int stringofPos;
    String esmelsora;
    String mLine;
    int positionText;
    LineByLineAdapter adapterlinebyline;
    RecyclerView recyclerView;
    LinearLayoutManager layoumanager;
    List<String> items;


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this Without Mark!")
                .setPositiveButton("Yes", null)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sora__kamla);
        //ElsoraKamla=findViewById(R.id.Elaya_kamla);
        layoumanager=new LinearLayoutManager(this);
        recyclerView=findViewById(R.id.container_sora);
        EsmElsoraKamla=findViewById(R.id.esm_elsora);

        stringofPos=getIntent().getExtras().getInt("Pos_Key");
        esmelsora=getIntent().getExtras().getString("Esm_Elsora");
        EsmElsoraKamla.setText(esmelsora);
        Log.e("string position", String.valueOf(stringofPos));
        positionText=stringofPos+1;
        Log.e("Position Text", String.valueOf(positionText));

        BufferedReader reader = null;
        items=new ArrayList<>();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(positionText+".txt"), "UTF-8"));


            while ((mLine = reader.readLine()) != null) {
                items.add(mLine);


            }

            adapterlinebyline=new LineByLineAdapter(items);
          recyclerView.setLayoutManager(layoumanager);
            recyclerView.setAdapter(adapterlinebyline);


        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }


    }



    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences settings = getSharedPreferences("saveit", 0);
        int snowDensity = settings.getInt("SNOW_DENSITY", 0);
    String sora_name= settings.getString("esmElsora",esmelsora);
        if(sora_name==esmelsora)
     selectedpos=snowDensity;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    Log.e("Destroyed","Destroyed");
        SharedPreferences settings = getSharedPreferences("saveit", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("SNOW_DENSITY",selectedpos);
        editor.commit();
        Log.e("position is =", selectedpos+" ");

    }

}
