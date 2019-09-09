package com.moshaf.yasmeen.project1_quraan.API;

import com.moshaf.yasmeen.project1_quraan.API.Model.RadioResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Yasmeen on 2/12/2019.
 */

public interface APi_servers
{
    @GET("radio/radio_ar.json")
    Call<RadioResponse> getAllRadioChannels();

}
