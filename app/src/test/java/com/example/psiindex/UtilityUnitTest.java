package com.example.psiindex;

import com.example.psiindex.api.APIConstants;
import com.example.psiindex.psimodel.PSIResponse;
import com.example.psiindex.psimodel.Reading;
import com.example.psiindex.utils.Utility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class UtilityUnitTest {
    private PSIResponse testData= null;

    @Before
    public void  setMockDetails()
    {
        MockitoAnnotations.initMocks(this);
        testData = TestUtils.getResponseData();
    }

    @Test
    public void getRegionTitleTestSuccess() {
        String testString = "Click to see Psi Index details for : east";

        Assert.assertEquals("east", Utility.getRegionTitle(testString));
    }

    @Test
    public void getRegionTitleTestFailure() {
        String testString = "Click to see Psi Index details for : east";

        Assert.assertNotEquals("west", Utility.getRegionTitle(testString));
    }
    @Test
    public void getRegionTitleTestNullTitleFailure() {
        String testString = null;
        Assert.assertNull("west", Utility.getRegionTitle(testString));
    }

    @Test
    public void getRegionTitleTestEmptyTitleFailure() {
        String testString = "Click to see Psi Index details for : ";
        Assert.assertNotEquals("west", Utility.getRegionTitle(testString));
    }
    @Test
    public void  getReadingDetailsTestSuccess() {
        Assert.assertEquals(
                testData(),
                Utility.getReadingDetails(testData.items.get(0).readings, "east")
        );
    }

    @Test
    public void getReadingDetailsTest_null_identifier() {
        Assert.assertNotEquals(
                testData(),
                Utility.getReadingDetails(testData.items.get(0).readings, null)
        );
    }

    @Test
    public void  getReadingDetailsTest_failure() {
        Assert.assertNotEquals(
                testData(),
                Utility.getReadingDetails(testData.items.get(0).readings, "east")
        );
    }
    @Test
    public void  getCentralReadingTestSuccess() {
        Assert.assertEquals(
                testData(),
                Utility.getReadingsCentral(testData.items.get(0).readings)
        );
    }

    @Test
    public void  getCentralReadingTestError (){
        Assert.assertNotEquals(
                testData(),
                Utility.getReadingsCentral(testData.items.get(0).readings)
        );
    }

    private List<Reading> testData(){
        ArrayList<Reading> readingDetailsPair =new  ArrayList<Reading>();
        readingDetailsPair.add(new Reading(APIConstants.co_eight_hour_max, "11"));
        readingDetailsPair.add(new Reading(APIConstants.co_sub_index, "11"));
        readingDetailsPair.add(new Reading(APIConstants.no2_one_hour_max, "11"));
        readingDetailsPair.add(new Reading(APIConstants.o3_eight_hour_max, "11"));
        readingDetailsPair.add(new Reading(APIConstants.o3_sub_index, "11"));
        readingDetailsPair.add(new Reading(APIConstants.pm10_sub_index, "11"));
        readingDetailsPair.add(new Reading(APIConstants.pm10_twenty_four_hourly, "11"));
        readingDetailsPair.add(new Reading(APIConstants.pm25_sub_index, "11"));
        readingDetailsPair.add(new Reading(APIConstants.pm25_twenty_four_hourly, "11"));
        readingDetailsPair.add(new Reading(APIConstants.psi_twenty_four_hourly, "11"));
        readingDetailsPair.add(new Reading(APIConstants.so2_sub_index, "11"));
        readingDetailsPair.add(new Reading(APIConstants.so2_twenty_four_hourly, "11"));
        return readingDetailsPair;
    }


}
