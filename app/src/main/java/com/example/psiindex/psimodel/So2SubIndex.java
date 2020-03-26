
package com.example.psiindex.psimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class So2SubIndex {

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
