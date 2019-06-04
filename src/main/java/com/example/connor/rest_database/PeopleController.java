/*
* PeopleController.java
* Description: routes http requests to proper function,
* manages identity information in database
*/

package com.example.connor.rest_database;
import com.example.connor.rest_database.models.People;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.connor.rest_database.helpers.SpringLoggingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.connor.rest_database.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import java.util.List;
@RestController
@RequestMapping("/people")
public class PeopleController {
	@Autowired
		private PeopleRepository repository;
// Get all identities in database
	@RequestMapping(value = "/", method = RequestMethod.GET)
		public List<People> getAllPeople() {
			new SpringLoggingHelper().GetAllPeople();
			return repository.findAll();
		}
// Get all identities with specific first name
	@RequestMapping(method = RequestMethod.GET)
		public List<People> getPersonByFirstName(@RequestParam(value="name") String name) {
			new SpringLoggingHelper().GetPersonByName(name);
			return repository.findByfirstName(name);
		}
// Get all identities with first name that contains specific pattern
	@RequestMapping(value = "/regex/{pattern}", method = RequestMethod.GET)
		public List<People> getPersonByRegex(@PathVariable("pattern") String pattern) {
			new SpringLoggingHelper().GetPersonByRegex(pattern);
			return repository.readByfirstNameRegex(pattern);
		}
// Get all identities with which there is an address associated
	@RequestMapping(value = "/nonNullAddress", method = RequestMethod.GET)
		public List<People> getNonNullAddress() {
			new SpringLoggingHelper().GetNonNullAddress();
			return repository.findByAddressIsNotNull();
		}
// Get the identity with the matching id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public People getPersonById(@PathVariable("id") ObjectId id) {
			new SpringLoggingHelper().GetPersonById(id);
			return repository.findBy_id(id);
		}
// Update the identity with the matching id, and if lat/long is not 0,0, update address
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public void updatePerson(@PathVariable("id") ObjectId id, @Valid @RequestBody People people) {
			people.set_id(id);
			AddressController addcont = new AddressController();
			if ((people.latitude != 0) && (people.longitude != 0)) {
				people.address = addcont.getAddressbyLatLng(Integer.toString(people.latitude), Integer.toString(people.longitude));
			}
			new SpringLoggingHelper().UpdatePerson(id);
			repository.save(people);
		}
// Create a new identity and generate an associated unique ID number; if lat/long is not 0,0, add address
	@RequestMapping(value = "/", method = RequestMethod.POST)
		public People createPerson(@Valid @RequestBody People people) {
			ObjectId id = ObjectId.get();
			people.set_id(id);
			AddressController addcont = new AddressController();
			if ((people.latitude != 0) && (people.longitude != 0)) {
				people.address = addcont.getAddressbyLatLng(Integer.toString(people.latitude), Integer.toString(people.longitude));
			}
			repository.save(people);
			new SpringLoggingHelper().CreatePerson(id);
			return people;
		}
//delete the identity with the matching Id number
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public void deletePerson(@PathVariable ObjectId id) {
			new SpringLoggingHelper().DeletePerson(id);
			repository.delete(repository.findBy_id(id));
		}
}
