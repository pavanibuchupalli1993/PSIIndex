
package com.example.psiindex.psimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PSIResponse {

    @SerializedName("region_metadata")
    @Expose
    public List<RegionMetadatum> regionMetadata = null;
    @SerializedName("items")
    @Expose
    public List<Item> items = null;

}
