package com.example.psiindex.model;

import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("timestamp")
    String timestamp;
    @SerializedName("update_timestamp")
    String updateTimeStamp;
    @SerializedName("readings")
    Readings readings;
}
