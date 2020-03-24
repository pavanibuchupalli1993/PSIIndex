package com.example.psiindex.utils;

import com.example.psiindex.api.APIConstants;
import com.example.psiindex.psi_model.Reading;
import com.example.psiindex.psi_model.Readings;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    /**
     * Split string for delimiter :
     */
public static String getRegionTitle(String title)
{
    if(title!=null) {
        String[] titleParts = title.split(":");
        return titleParts[1].trim();
    }else
    {
        return null;
    }

}

    /**
     * Return psi index details for selected region.
     */
    public static ArrayList<Reading> getReadingDetails(Readings readings, String identifier)
    {
        ArrayList<Reading> list=new ArrayList<>();
        switch (identifier)
        {
            case APIConstants
                    .EAST:
                list=getReadingsEast(readings);
                break;
            case APIConstants
                    .WEST:
                list=getReadingsWest(readings);
                break;
            case APIConstants
                    .SOUTH:
                list=getReadingsSouth(readings);
                break;
            case APIConstants
                    .NORTH:
                list=getReadingsNorth(readings);
                break;
            case APIConstants
                    .CENTRAL:
                list=getReadingsCentral(readings);
                break;
        }

        return list;
    }

    private static ArrayList<Reading> getReadingsEast(Readings readings) {
        ArrayList<Reading> readingDetails = new ArrayList<>();

        readingDetails.add(new Reading(APIConstants.co_eight_hour_max, readings.coEightHourMax.east.toString()));
        readingDetails.add(new Reading(APIConstants.co_sub_index, readings.coSubIndex.east.toString()));
        readingDetails.add(new Reading(APIConstants.no2_one_hour_max, readings.no2OneHourMax.east.toString()));
        readingDetails.add(new Reading(APIConstants.o3_eight_hour_max, readings.o3EightHourMax.east.toString()));
        readingDetails.add(new Reading(APIConstants.o3_sub_index, readings.o3SubIndex.east.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_sub_index, readings.pm10SubIndex.east.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_twenty_four_hourly, readings.pm10TwentyFourHourly.east.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_sub_index, readings.pm25SubIndex.east.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_twenty_four_hourly, readings.pm25TwentyFourHourly.east.toString()));
        readingDetails.add(new Reading(APIConstants.so2_sub_index, readings.so2SubIndex.east.toString()));
        readingDetails.add(new Reading(APIConstants.so2_twenty_four_hourly, readings.so2TwentyFourHourly.east.toString()));

        return readingDetails;

    }

    private static ArrayList<Reading> getReadingsWest(Readings readings) {
        ArrayList<Reading> readingDetails = new ArrayList<>();

        readingDetails.add(new Reading(APIConstants.co_eight_hour_max, readings.coEightHourMax.west.toString()));
        readingDetails.add(new Reading(APIConstants.co_sub_index, readings.coSubIndex.west.toString()));
        readingDetails.add(new Reading(APIConstants.no2_one_hour_max, readings.no2OneHourMax.west.toString()));
        readingDetails.add(new Reading(APIConstants.o3_eight_hour_max, readings.o3EightHourMax.west.toString()));
        readingDetails.add(new Reading(APIConstants.o3_sub_index, readings.o3SubIndex.west.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_sub_index, readings.pm10SubIndex.west.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_twenty_four_hourly, readings.pm10TwentyFourHourly.west.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_sub_index, readings.pm25SubIndex.west.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_twenty_four_hourly, readings.pm25TwentyFourHourly.west.toString()));
        readingDetails.add(new Reading(APIConstants.so2_sub_index, readings.so2SubIndex.west.toString()));
        readingDetails.add(new Reading(APIConstants.so2_twenty_four_hourly, readings.so2TwentyFourHourly.west.toString()));

        return readingDetails;

    }

    private static ArrayList<Reading> getReadingsNorth(Readings readings) {
        ArrayList<Reading> readingDetails = new ArrayList<>();

        readingDetails.add(new Reading(APIConstants.co_eight_hour_max, readings.coEightHourMax.north.toString()));
        readingDetails.add(new Reading(APIConstants.co_sub_index, readings.coSubIndex.north.toString()));
        readingDetails.add(new Reading(APIConstants.no2_one_hour_max, readings.no2OneHourMax.north.toString()));
        readingDetails.add(new Reading(APIConstants.o3_eight_hour_max, readings.o3EightHourMax.north.toString()));
        readingDetails.add(new Reading(APIConstants.o3_sub_index, readings.o3SubIndex.north.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_sub_index, readings.pm10SubIndex.north.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_twenty_four_hourly, readings.pm10TwentyFourHourly.north.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_sub_index, readings.pm25SubIndex.north.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_twenty_four_hourly, readings.pm25TwentyFourHourly.north.toString()));
        readingDetails.add(new Reading(APIConstants.so2_sub_index, readings.so2SubIndex.north.toString()));
        readingDetails.add(new Reading(APIConstants.so2_twenty_four_hourly, readings.so2TwentyFourHourly.north.toString()));

        return readingDetails;

    }

    private static  ArrayList<Reading> getReadingsSouth(Readings readings) {
        ArrayList<Reading> readingDetails = new ArrayList<>();

        readingDetails.add(new Reading(APIConstants.co_eight_hour_max, readings.coEightHourMax.south.toString()));
        readingDetails.add(new Reading(APIConstants.co_sub_index, readings.coSubIndex.south.toString()));
        readingDetails.add(new Reading(APIConstants.no2_one_hour_max, readings.no2OneHourMax.south.toString()));
        readingDetails.add(new Reading(APIConstants.o3_eight_hour_max, readings.o3EightHourMax.south.toString()));
        readingDetails.add(new Reading(APIConstants.o3_sub_index, readings.o3SubIndex.south.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_sub_index, readings.pm10SubIndex.south.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_twenty_four_hourly, readings.pm10TwentyFourHourly.south.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_sub_index, readings.pm25SubIndex.south.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_twenty_four_hourly, readings.pm25TwentyFourHourly.south.toString()));
        readingDetails.add(new Reading(APIConstants.so2_sub_index, readings.so2SubIndex.south.toString()));
        readingDetails.add(new Reading(APIConstants.so2_twenty_four_hourly, readings.so2TwentyFourHourly.south.toString()));

        return readingDetails;

    }

    private static ArrayList<Reading> getReadingsCentral(Readings readings) {
        ArrayList<Reading> readingDetails = new ArrayList<>();

        readingDetails.add(new Reading(APIConstants.co_eight_hour_max, readings.coEightHourMax.central.toString()));
        readingDetails.add(new Reading(APIConstants.co_sub_index, readings.coSubIndex.central.toString()));
        readingDetails.add(new Reading(APIConstants.no2_one_hour_max, readings.no2OneHourMax.central.toString()));
        readingDetails.add(new Reading(APIConstants.o3_eight_hour_max, readings.o3EightHourMax.central.toString()));
        readingDetails.add(new Reading(APIConstants.o3_sub_index, readings.o3SubIndex.central.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_sub_index, readings.pm10SubIndex.central.toString()));
        readingDetails.add(new Reading(APIConstants.pm10_twenty_four_hourly, readings.pm10TwentyFourHourly.central.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_sub_index, readings.pm25SubIndex.central.toString()));
        readingDetails.add(new Reading(APIConstants.pm25_twenty_four_hourly, readings.pm25TwentyFourHourly.central.toString()));
        readingDetails.add(new Reading(APIConstants.so2_sub_index, readings.so2SubIndex.central.toString()));
        readingDetails.add(new Reading(APIConstants.so2_twenty_four_hourly, readings.so2TwentyFourHourly.central.toString()));

        return readingDetails;

    }

}
