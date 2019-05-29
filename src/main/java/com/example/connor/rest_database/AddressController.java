package com.example.connor.rest_database;
import com.example.connor.rest_database.models.Address;
import com.example.connor.rest_database.models.LatLng;
import com.example.connor.rest_database.GeocodeAddressParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/latlng")
public class AddressController {
  @Autowired
 
  @RequestMapping(value = "/{lat}:{lng}", method = RequestMethod.GET)
  public Address getAddressbyLatLng() {
	//RestTemplate restTemplate = new RestTemplate();
	//Address address = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=AIzaSyAxAUF8id0rwkt_S48z6vlLy9sip_IaEt8", Address.class);
	//return address;
	GeocodeAddressParser ref = new GeocodeAddressParser();

	Address address = new Address();
        address.setAddress(ref.getLocationInfo("23.0043673","72.5411868999996"));
	return address;
  }
}
