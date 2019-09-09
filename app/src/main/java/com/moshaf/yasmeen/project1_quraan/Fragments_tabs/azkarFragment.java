package com.moshaf.yasmeen.project1_quraan.Fragments_tabs;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moshaf.yasmeen.project1_quraan.Activities.Azkar_Kamla;
import com.moshaf.yasmeen.project1_quraan.Adapters.azkar_Adapter;
import com.moshaf.yasmeen.project1_quraan.Model.Model_Azkar_Name;
import com.moshaf.yasmeen.project1_quraan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class azkarFragment extends Fragment {
    RecyclerView azkar_recycler;
    RecyclerView.LayoutManager layoutManager;
    azkar_Adapter azkar_adapter;

    public azkarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_azkar, container, false);


        azkar_recycler=v.findViewById(R.id.recycler_view_azkar);
        layoutManager=new LinearLayoutManager(getActivity());
        azkar_adapter=new azkar_Adapter(Model_Azkar_Name.azkarnames);
        Log.e("Mbydkholsh","Mbydkolsh");
        azkar_recycler.setAdapter(azkar_adapter);
        azkar_recycler.setLayoutManager(layoutManager);
        Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                azkar_adapter.setItemClickListener(new azkar_Adapter.ItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                      Intent in=new Intent(getActivity(), Azkar_Kamla.class);
                        in.putExtra("Pos_Key",position);
                        in.putExtra("Esm_Elzekr",Model_Azkar_Name.azkarnames[position]);
                      startActivity(in);
                    }
                } );
            }
        });

th.start();

        return v;
    }

}
