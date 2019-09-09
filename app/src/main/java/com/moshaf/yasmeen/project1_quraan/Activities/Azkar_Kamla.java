package com.moshaf.yasmeen.project1_quraan.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.moshaf.yasmeen.project1_quraan.Adapters.Zekr_oneByOneAdapter;
import com.moshaf.yasmeen.project1_quraan.Model.Model_Azkar;
import com.moshaf.yasmeen.project1_quraan.R;
import com.moshaf.yasmeen.project1_quraan.RoomDatabaseforAzkar.MyDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Azkar_Kamla extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Model_Azkar> list;
    Zekr_oneByOneAdapter adapter;
    int stringofPos;
    String esmelzekr_string;
    int positionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar__kamla);
        list = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.container_azkar);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        adapter=new Zekr_oneByOneAdapter(null);
        stringofPos = getIntent().getExtras().getInt("Pos_Key");
        esmelzekr_string = getIntent().getExtras().getString("Esm_Elzekr");
        Log.e("string position", String.valueOf(stringofPos));
        positionText = stringofPos + 1;
        String child="0"+positionText;
        Log.e("Position Text", String.valueOf(positionText));

        reference = FirebaseDatabase.getInstance().getReference().child("Data").child(child);
     Log.e("Refrence",reference+" ");
//Do you task
        DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
        Log.e("ConnectedRef",connectedRef+" ");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                Log.e("connected",connected+"");
                if (connected) {
             Refrences();
                } else {
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            List<Model_Azkar> azkarList=MyDatabase.getInstance(Azkar_Kamla.this).azkarDao().getAllAzkar();
                            Log.e("AzkarListGetter",azkarList+" ");
                            Log.e("ElThread Ashtghlet ;) ","Okay");
                            //    adapter.ChangeData(azkarList);
                            adapter=new Zekr_oneByOneAdapter((ArrayList<Model_Azkar>) azkarList);

                            recyclerView.setAdapter(adapter);

                        }
                    });


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
void Refrences()
{
    reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {


                Model_Azkar p = dataSnapshot1.getValue(Model_Azkar.class);
                list.add(p);
                Log.e("List", list + "");
            }
            adapter = new Zekr_oneByOneAdapter(list);
            recyclerView.setAdapter(adapter);
            InsertIntoRoomDatabaseThread InsertThread = new InsertIntoRoomDatabaseThread(list);
            InsertThread.start();
            Log.e("List of Thread", InsertThread.azkarList + "");

        }


        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.e("Error", "Opsss.... Something is wrong");
            // Toast.makeText(Azkar_Kamla.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

        }
    });
}
    class InsertIntoRoomDatabaseThread extends Thread
    {

        List<Model_Azkar>azkarList;


        public InsertIntoRoomDatabaseThread(List<Model_Azkar> azkarList) {
            this.azkarList = azkarList;
        }
        @Override
        public void run()
        {
            MyDatabase.getInstance(Azkar_Kamla.this).azkarDao().AddAzkar(azkarList);

            Log.e("ElThread Ashtghlet ;) ","Okay");
        }
    }
    }

