package com.example.psiindex.model;

import com.google.gson.annotations.SerializedName;

public class Readings {
    @SerializedName("pm10_twenty_four_hourly")
    String pm10_twenty_four_hourly;

    @SerializedName("pm10_sub_index")
    String pm10_sub_index;

    @SerializedName("co_sub_index")
    String co_sub_index;

    @SerializedName("so2_sub_index")
    String so2_sub_index;

    @SerializedName("pm25_twenty_four_hourly")
    String pm25_twenty_four_hourly;

    @SerializedName("co_eight_hour_max")
    String co_eight_hour_max;

    @SerializedName("no2_one_hour_max")
    String no2_one_hour_max;

    @SerializedName("so2_twenty_four_hourly")
    String so2_twenty_four_hourly;

    @SerializedName("pm25_sub_index")
    String pm25_sub_index;

    @SerializedName("psi_twenty_four_hourly")
    String psi_twenty_four_hourly;

    @SerializedName("o3_eight_hour_max")
    String o3_eight_hour_max;


}
