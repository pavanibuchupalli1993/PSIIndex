
package com.example.psiindex.psi_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LabelLocation {

    @SerializedName("latitude")
    @Expose
    public Double latitude;
    @SerializedName("longitude")
    @Expose
    public Double longitude;

}
