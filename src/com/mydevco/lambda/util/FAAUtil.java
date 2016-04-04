/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mydevco.lambda.util;

//Call FAA web service and get airport details
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mydevco.lambda.model.Airport;

public class FAAUtil {

    private static final Log Log = LogFactory.getLog(FAAUtil.class);

    public static Airport contactFAA(String code) {
        
        Airport airport = new Airport();
        airport.setCode(code);
        BufferedReader in = null;
        try {
            String url = String.format("http://services.faa.gov/airport/status/%s?format=json", code);
            URL faaURL = new URL(url);
            URLConnection yc = faaURL.openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            StringBuilder jsonResponse = new StringBuilder();
            String inputLine = "";
            while ((inputLine = in.readLine()) != null) {
                jsonResponse.append(inputLine);
            }

            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse.toString());
            airport.setName((String)jsonObject.get("name"));
            airport.setState((String)jsonObject.get("state"));
            airport.setIsDelay(Boolean.parseBoolean((String) jsonObject.get("delay")));
            String temp = (String)((JSONObject)jsonObject.get("weather")).get("temp");
            if(StringUtils.isNotEmpty(temp)) {
                String tempf = StringUtils.substringBefore(temp, " ");
                airport.setTemperatue(Double.parseDouble(tempf));
            }

        } catch (Exception ex) {
            //Log.error(ex); //ignore
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException ex) {
                    Log.error(ex);
                }
            }
        }

        return airport;
    }

}
