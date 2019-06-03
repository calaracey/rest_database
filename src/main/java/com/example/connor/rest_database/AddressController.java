package com.example.connor.rest_database;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.*;
import java.io.IOException;
import java.awt.Component;
import com.example.connor.rest_database.models.Address;
import com.example.connor.rest_database.models.GoogleGeoCodeResponse;
import com.example.connor.rest_database.models.results;
import com.example.connor.rest_database.models.geometry;
import com.example.connor.rest_database.models.location;
import com.example.connor.rest_database.models.bounds;
import com.example.connor.rest_database.models.address_component;
import com.example.connor.rest_database.models.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import javax.validation.Valid;
import java.util.List;
import com.example.connor.rest_database.helpers.SpringLoggingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/latlng")
public class AddressController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/{lat}:{lng}", method = RequestMethod.GET)
		public String getAddressbyLatLng(@PathVariable String lat, @PathVariable String lng) {
				Map<String, String> vars = new HashMap<String, String>();

				vars.put("latitude", lat);
				vars.put("longitude", lng);
				RestTemplate restTemplate = new RestTemplate();
				ObjectMapper mapper = new ObjectMapper();
				mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);	
				GoogleGeoCodeResponse address = new GoogleGeoCodeResponse();
				System.out.println("calling geo api");
				try {
				address = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?latlng={latitude},{longitude}&key=AIzaSyCW2inUNb43jZd7QFOny4T-xa0zmH9TWRc&sensor=true", GoogleGeoCodeResponse.class,vars);
			} catch (RuntimeException e) {
				logger.error("Error in attempting to get address",e);
				System.out.println(e.getClass().getName());
			}	
				return address.results[0].formatted_address;
		}
}
