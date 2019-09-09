package com.moshaf.yasmeen.project1_quraan.API.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
@Entity
public class RadiosItem{
@ColumnInfo
	@SerializedName("URL")
	private String uRL;
@ColumnInfo
	@SerializedName("Name")
	private String name;

	public String getuRL() {
		return uRL;
	}

	public void setuRL(String uRL) {
		this.uRL = uRL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
@PrimaryKey (autoGenerate = true)
	int id;

	public void setURL(String uRL){
		this.uRL = uRL;
	}

	public String getURL(){
		return uRL;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"RadiosItem{" + 
			"uRL = '" + uRL + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}