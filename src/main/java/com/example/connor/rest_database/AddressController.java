package com.example.connor.rest_database;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.*;
import java.io.IOException;
import java.awt.Component;
import com.example.connor.rest_database.models.Address;
import com.example.connor.rest_database.models.GoogleGeoCodeResponse;
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
import java.util.concurrent.TimeUnit;
@RestController
@RequestMapping("/latlng")
public class AddressController {
  @Autowired
 
  @RequestMapping(value = "/{lat}:{lng}", method = RequestMethod.GET)
  public GoogleGeoCodeResponse getAddressbyLatLng(@PathVariable String lat, @PathVariable String lng) {
	Map<String, String> vars = new HashMap<String, String>();

        vars.put("latitude", lat);
        vars.put("longitude", lng);
	RestTemplate restTemplate = new RestTemplate();
	ObjectMapper mapper = new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);	
	GoogleGeoCodeResponse address = new GoogleGeoCodeResponse();
//	try {
	//URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=AIzaSyAxAUF8id0rwkt_S48z6vlLy9sip_IaEt8");
	//address = mapper.readValue(url, GoogleGeoCodeResponse.class);
	System.out.println("I'm being a retard again");
	address = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?latlng={latitude},{longitude}&key=AIzaSyCW2inUNb43jZd7QFOny4T-xa0zmH9TWRc&sensor=true", GoogleGeoCodeResponse.class,vars);
//	} catch (IOException e1) {
//		e1.printStackTrace();
//	}
	return address;
	//Address address = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=AIzaSyAxAUF8id0rwkt_S48z6vlLy9sip_IaEt8", Address.class);
	/*GeocodeAddressParser ref = new GeocodeAddressParser();

	Address address = new Address();
        address.setAddress(ref.getLocationInfo("23.0043673","72.5411868999996"));
	return address;
	*/
  }
}
