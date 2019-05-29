package com.example.rest_database;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class GeocodeAddressParser {
    @SuppressWarnings("deprecation")
    public String getLocationInfo( String lat, String lng) throws JsonProcessingException, IOException {

        HttpGet httpGet = new HttpGet("http://maps.google.com/maps/api/geocode/json?latlng="+lat+","+lng+"&key=AIzaSyAxAUF8id0rwkt_S48z6vlLy9sip_IaEt8");
        @SuppressWarnings("resource")
        HttpClient client = new DefaultHttpClient();
        HttpResponse response;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
            } catch (IOException e) {
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode array =  mapper.readValue(stringBuilder.toString(), JsonNode.class);
        JsonNode object = array.get("results").get(0);
        String reportKey = object.get("results").textValue();
	return reportKey;
        }
}
