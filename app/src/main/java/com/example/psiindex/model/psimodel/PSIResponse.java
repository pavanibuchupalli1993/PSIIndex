
package com.example.psiindex.model.psimodel;

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
