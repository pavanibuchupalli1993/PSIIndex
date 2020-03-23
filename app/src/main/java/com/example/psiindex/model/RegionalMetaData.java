package com.example.psiindex.model;

import com.google.gson.annotations.SerializedName;

public class RegionalMetaData {
    @SerializedName("name")
    String name;

    @SerializedName("label_location")
    LabelLocation label_location;
}

