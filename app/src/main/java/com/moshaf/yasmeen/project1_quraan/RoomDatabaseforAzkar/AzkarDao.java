package com.moshaf.yasmeen.project1_quraan.RoomDatabaseforAzkar;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.moshaf.yasmeen.project1_quraan.Model.Model_Azkar;

import java.util.List;
/**
 * Created by Yasmeen on 2/6/2019.
 */
@Dao
public interface AzkarDao {
@Insert
    public void AddAzkar(List<Model_Azkar> Item);
@Query("select * from Model_Azkar")
List<Model_Azkar> getAllAzkar();

}
