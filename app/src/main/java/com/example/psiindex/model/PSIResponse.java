package com.example.psiindex.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PSIResponse {
    @SerializedName("region_metadata")
    RegionalMetaData regionalMetaData;
    @SerializedName("items")
    List<Items>  items;


}
