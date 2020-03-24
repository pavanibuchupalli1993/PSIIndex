
package com.example.psiindex.psi_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoSubIndex {

    @SerializedName("west")
    @Expose
    public Integer west;
    @SerializedName("national")
    @Expose
    public Integer national;
    @SerializedName("east")
    @Expose
    public Integer east;
    @SerializedName("central")
    @Expose
    public Integer central;
    @SerializedName("south")
    @Expose
    public Integer south;
    @SerializedName("north")
    @Expose
    public Integer north;

}