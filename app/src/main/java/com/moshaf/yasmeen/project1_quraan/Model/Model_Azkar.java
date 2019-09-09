package com.moshaf.yasmeen.project1_quraan.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Yasmeen on 6/29/2019.
 */
@Entity
public class Model_Azkar {
    @ColumnInfo
    String title;
    @ColumnInfo
    String desc;
    @ColumnInfo
    String count;
    @PrimaryKey(autoGenerate = true)
int id;
    public Model_Azkar() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


    public Model_Azkar(String title, String desc, String count) {
        this.title = title;
        this.desc = desc;
        this.count = count;

    }
}
