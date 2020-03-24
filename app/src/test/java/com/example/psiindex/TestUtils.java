package com.example.psiindex;

import com.example.psiindex.psi_model.PSIResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.InputStream;

public class TestUtils {
    @Before
  public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    public static PSIResponse getResponseData() {
        try {
            String response = "{\"region_metadata\":[{\"name\":\"west\",\"label_location\":{\"latitude\":1.35735,\"longitude\":103.7}},{\"name\":\"national\",\"label_location\":{\"latitude\":0,\"longitude\":0}},{\"name\":\"east\",\"label_location\":{\"latitude\":1.35735,\"longitude\":103.94}},{\"name\":\"central\",\"label_location\":{\"latitude\":1.35735,\"longitude\":103.82}},{\"name\":\"south\",\"label_location\":{\"latitude\":1.29587,\"longitude\":103.82}},{\"name\":\"north\",\"label_location\":{\"latitude\":1.41803,\"longitude\":103.82}}],\"items\":[{\"timestamp\":\"2020-03-23T22:00:00+08:00\",\"update_timestamp\":\"2020-03-23T22:08:52+08:00\",\"readings\":{\"o3_sub_index\":{\"west\":4,\"national\":11,\"east\":6,\"central\":9,\"south\":11,\"north\":10},\"pm10_twenty_four_hourly\":{\"west\":24,\"national\":24,\"east\":23,\"central\":21,\"south\":23,\"north\":20},\"pm10_sub_index\":{\"west\":24,\"national\":24,\"east\":23,\"central\":21,\"south\":23,\"north\":20},\"co_sub_index\":{\"west\":5,\"national\":8,\"east\":8,\"central\":4,\"south\":6,\"north\":3},\"pm25_twenty_four_hourly\":{\"west\":9,\"national\":13,\"east\":11,\"central\":12,\"south\":13,\"north\":10},\"so2_sub_index\":{\"west\":3,\"national\":3,\"east\":2,\"central\":1,\"south\":3,\"north\":1},\"co_eight_hour_max\":{\"west\":0.46,\"national\":0.76,\"east\":0.76,\"central\":0.41,\"south\":0.56,\"north\":0.34},\"no2_one_hour_max\":{\"west\":35,\"national\":53,\"east\":52,\"central\":37,\"south\":38,\"north\":53},\"so2_twenty_four_hourly\":{\"west\":5,\"national\":5,\"east\":3,\"central\":2,\"south\":5,\"north\":2},\"pm25_sub_index\":{\"west\":39,\"national\":52,\"east\":45,\"central\":51,\"south\":52,\"north\":42},\"psi_twenty_four_hourly\":{\"west\":39,\"national\":39,\"east\":45,\"central\":51,\"south\":52,\"north\":42},\"o3_eight_hour_max\":{\"west\":10,\"national\":26,\"east\":15,\"central\":22,\"south\":26,\"north\":23}}}],\"api_info\":{\"status\":\"healthy\"}}\n";
            Gson gson = new Gson();
            return gson.fromJson(response, PSIResponse.class);

        }
        catch ( Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
