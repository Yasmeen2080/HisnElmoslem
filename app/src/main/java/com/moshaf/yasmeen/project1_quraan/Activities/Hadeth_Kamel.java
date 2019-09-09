package com.moshaf.yasmeen.project1_quraan.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.moshaf.yasmeen.project1_quraan.Adapters.LineByLineHadesAdapter;
import com.moshaf.yasmeen.project1_quraan.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hadeth_Kamel extends AppCompatActivity {
    int stringofPos;
    String esmelhadith_string;
    int positionText;
    LineByLineHadesAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoumanager;
    List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadeth__kamel);
        layoumanager=new LinearLayoutManager(this);
        recyclerView=findViewById(R.id.container_hades);
        stringofPos = getIntent().getExtras().getInt("Pos_Key");
        esmelhadith_string = getIntent().getExtras().getString("Esm_Elhadith");
        Log.e("string position", String.valueOf(stringofPos));
        positionText = stringofPos + 1;
        Log.e("Position Text", String.valueOf(positionText));
        BufferedReader reader = null;
        String txt = "";
        items=new ArrayList<>();



        try{
            reader=new BufferedReader(new InputStreamReader(getAssets().open("ahadeth.txt"),"UTF-8"));
            String search=stringofPos+"#";
            int stringnext=stringofPos+1;
            String searchagain=stringnext+"#";
            String mLine="";
          while((mLine=reader.readLine())!=null) {
if(mLine.contains(search)) {
    while ((mLine = reader.readLine()) != null) {

if(mLine.contains(searchagain))
{
    break;
}
        items.add(mLine);

    }
    break;
}
            }
        }catch (Exception e)
        {

        }
        adapter=new LineByLineHadesAdapter(items);
            recyclerView.setLayoutManager(layoumanager);
            recyclerView.setAdapter(adapter);
    }

}