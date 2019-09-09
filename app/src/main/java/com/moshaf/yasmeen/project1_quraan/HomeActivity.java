package com.moshaf.yasmeen.project1_quraan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.moshaf.yasmeen.project1_quraan.Fragments_tabs.Ahadeth_Fragment_tab;
import com.moshaf.yasmeen.project1_quraan.Fragments_tabs.QuraanFragment;
import com.moshaf.yasmeen.project1_quraan.Fragments_tabs.Radio_Fragment;
import com.moshaf.yasmeen.project1_quraan.Fragments_tabs.azkarFragment;
import com.moshaf.yasmeen.project1_quraan.Fragments_tabs.sebha_electronia_fragment;
import com.moshaf.yasmeen.project1_quraan.Helper.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment=new QuraanFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;

                case R.id.navigation_dashboard:
                    fragment=new sebha_electronia_fragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;
                case R.id.navigation_ahadeth:
                    fragment=new Ahadeth_Fragment_tab();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;
                case R.id.navigation_Api:
                    fragment=new Radio_Fragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;

                case R.id.navigation_azkar:
                    fragment=new azkarFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;
            }
            return true;
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        Fragment fragment=new QuraanFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

    }

}
