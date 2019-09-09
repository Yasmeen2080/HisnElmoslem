package com.moshaf.yasmeen.project1_quraan.Fragments_tabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moshaf.yasmeen.project1_quraan.Activities.Hadeth_Kamel;
import com.moshaf.yasmeen.project1_quraan.Adapters.Ahades_Adapter;
import com.moshaf.yasmeen.project1_quraan.Model.Model_AhadesName;
import com.moshaf.yasmeen.project1_quraan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ahadeth_Fragment_tab extends Fragment {
View view;
    RecyclerView recyclerView;
    Ahades_Adapter adapter;
    LinearLayoutManager layoumanager;
    public Ahadeth_Fragment_tab() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_ahadeth__fragment_tab, container, false);
        recyclerView=view.findViewById(R.id.ahades_recyclerview);
        layoumanager=new LinearLayoutManager(getActivity());
        adapter=new Ahades_Adapter(Model_AhadesName.AhadesName);
        adapter.setOnItemClickLisnter(new Ahades_Adapter.OnItemClickLisnter() {
            @Override
            public void OnItem(int pos) {
                Intent in=new Intent(getActivity(), Hadeth_Kamel.class);
                in.putExtra("Pos_Key",pos);
                in.putExtra("Esm_Elhadith",Model_AhadesName.AhadesName[pos]);
                startActivity(in);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoumanager);

        return view;
    }

}
