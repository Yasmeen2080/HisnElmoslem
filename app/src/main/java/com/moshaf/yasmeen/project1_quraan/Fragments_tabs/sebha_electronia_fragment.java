package com.moshaf.yasmeen.project1_quraan.Fragments_tabs;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.moshaf.yasmeen.project1_quraan.R;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class sebha_electronia_fragment extends Fragment {
    int counter=0;
int sum=0;
int countertasbeh=0;
    Button tasbeeh;
    Button magmo3tasbeeh;

    ImageView reset;
SharedPreferences shared;


    public sebha_electronia_fragment() {

    }

View view;
    Spinner spinner;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_sebha_electronia_fragment, container, false);
        spinner=view.findViewById(R.id.spinner);
        tasbeeh=view.findViewById(R.id.tasbeeha);
        reset=view.findViewById(R.id.reload);
        final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("counters", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        magmo3tasbeeh=view.findViewById(R.id.magmo3tasbeeh);
shared=getActivity().getSharedPreferences("Mypref",MODE_PRIVATE);
        counter = sharedPreferences.getInt("counter",sum);
magmo3tasbeeh.setText(String.valueOf(counter));


        tasbeeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countertasbeh++;
                counter++;
                tasbeeh.setText(String.valueOf(countertasbeh));

                sum=counter;
                magmo3tasbeeh.setText(String.valueOf(sum));
                editor.putInt("counter",sum).commit();

                sum = sharedPreferences.getInt("savedCounter", counter);

            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=0;
                countertasbeh=0;
                tasbeeh.setText(String.valueOf(counter));
                magmo3tasbeeh.setText(String.valueOf(counter));
            }
        });
        return view;
    }

}
