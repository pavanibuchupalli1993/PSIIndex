
package com.example.psiindex.psi_model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PSIResponse {

    @SerializedName("region_metadata")
    @Expose
    public List<RegionMetadatum> regionMetadata = null;
    @SerializedName("items")
    @Expose
    public List<Item> items = null;
    @SerializedName("api_info")
    @Expose
    public ApiInfo apiInfo;

}
