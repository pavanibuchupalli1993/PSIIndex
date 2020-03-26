
package com.example.psiindex.psimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionMetadatum {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("label_location")
    @Expose
    public LabelLocation labelLocation;

}
