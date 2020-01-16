package com.hackerrank.eshopping.product.dashboard.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ResultMatcher {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public ResultMatcher(){
    }

    private static List<JsonNode> pasreJsonArray(String jsonString){
        try{
            return (List)OBJECT_MAPPER.readValue(jsonString, new TypeReference<List<JsonNode>>() {
            });
        }catch (IOException ex){
            return null;
        }
    }

    public static boolean matchJson(String responseString, String expectedString, boolean reportMismatch){
        try{
            JsonNode response = OBJECT_MAPPER.readTree(responseString);
            JsonNode expected = OBJECT_MAPPER.readTree(expectedString);
            if (!response.equals(expected)){
                if (reportMismatch){
                    System.out.println("\u001b[0;31mExpected <" + expectedString + "> but was <" + responseString + ">." + "\u001b[0m");
                }
                return false;
            }
        }catch (IOException ex){
            return false;
        }
        return true;
    }

    private static boolean preliminaryJsonArrayMatching(List<JsonNode> response, List<JsonNode> expected){
        if(response != null && expected != null){
            return response.size() == expected.size();
        }else
            return false;
    }

    public static boolean matchJsonArray(String response, String expected, boolean reportMismatch){
        List<JsonNode> responseList = pasreJsonArray(response);
        List<JsonNode> expectedList = pasreJsonArray(expected);

        boolean preliminary = preliminaryJsonArrayMatching(responseList, expectedList);
        return !preliminary ? false :jsonArrayMatching(responseList, expectedList, reportMismatch);
    }

    private static boolean jsonArrayMatching(List<JsonNode> response, List<JsonNode> expected, boolean reportMismatch) {

        for(int i=0; i<response.size(); ++i){
            JsonNode expectedJson = (JsonNode)expected.get(i);
            JsonNode responseJson = (JsonNode)response.get(i);
            if(!expectedJson.equals(responseJson)){
                if(reportMismatch){
                    System.out.println("\u001b[0;31mExpected <" + expectedJson.toString() + "> but was <" + responseJson.toString() + "> (at index " + i + ")." + "\u001b[0m");
                }
                return false;
            }
        }
        return true;
    }

}
