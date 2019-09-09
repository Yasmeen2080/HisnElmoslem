package com.moshaf.yasmeen.project1_quraan.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yasmeen on 2/12/2019.
 */

public class Api_Manager {
private static Retrofit retrofitInstance;

   private static Retrofit  getInstance() {
      if(retrofitInstance==null)//create
      {
         retrofitInstance = new Retrofit.Builder()
                  .baseUrl("http:/mp3quran.net/api/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();

      }
      return retrofitInstance;
    }

    public static APi_servers getApi()
    {
        APi_servers api_servers=getInstance().create(APi_servers.class);

        return api_servers;
    }
}
