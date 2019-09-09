package com.moshaf.yasmeen.project1_quraan.RoomDatabaseforAzkar;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.moshaf.yasmeen.project1_quraan.Model.Model_Azkar;
/**
 * Created by Yasmeen on 2/6/2019.
 */
@Database(entities = {Model_Azkar.class},version = 1,exportSchema = true)
public abstract class MyDatabase extends RoomDatabase {
    public static MyDatabase myDatabase;
    public abstract AzkarDao azkarDao();
  public static MyDatabase getInstance(Context context)
  {
      if(myDatabase==null)
      {
myDatabase= Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,"Azkar-Database")
        .allowMainThreadQueries()
        .build();
          //MyDatabase=Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "Todo-Database").allowMainThreadQueries().build();
      }
return myDatabase;



    }
}
