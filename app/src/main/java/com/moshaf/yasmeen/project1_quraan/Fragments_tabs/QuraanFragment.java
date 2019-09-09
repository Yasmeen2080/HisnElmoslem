package com.moshaf.yasmeen.project1_quraan.Fragments_tabs;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.moshaf.yasmeen.project1_quraan.Activities.Sora_Kamla;
import com.moshaf.yasmeen.project1_quraan.Adapters.QuraanAdapter;
import com.moshaf.yasmeen.project1_quraan.Model.Model_sewrQuraan;
import com.moshaf.yasmeen.project1_quraan.R;

public class  QuraanFragment extends Fragment {


    public QuraanFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    QuraanAdapter adapter;

    GridLayoutManager layoumanager;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_quraan, container, false);
        recyclerView=view.findViewById(R.id.recycler_view_sewr_quraan);
        layoumanager=new GridLayoutManager(getContext(),3,GridLayoutManager.HORIZONTAL,true);
        adapter=new QuraanAdapter(Model_sewrQuraan.ArSuras);
        adapter.setOnItemClickLisnter(new QuraanAdapter.OnItemClickLisnter() {
            @Override
            public void OnItem(int pos) {
Intent in=new Intent(getActivity(), Sora_Kamla.class);
                in.putExtra("Pos_Key",pos);
                in.putExtra("Esm_Elsora",Model_sewrQuraan.ArSuras[pos]);

startActivity(in);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoumanager);

        return view;
    }

        }
