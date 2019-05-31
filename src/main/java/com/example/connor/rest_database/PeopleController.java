package com.example.connor.rest_database;
import com.example.connor.rest_database.models.People;
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
		public List<People> getAllPeople() {
			return repository.findAll();
		}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public People getPersonById(@PathVariable("id") ObjectId id) {
			return repository.findBy_id(id);
		}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public void modifyPersonById(@PathVariable("id") ObjectId id, @Valid @RequestBody People people) {
			people.set_id(id);
			people.address = AddressController.getAddressbyLatLng(Integer.toString(people.latitude), Integer.toString(people.longitude));
			repository.save(people);
		}

	@RequestMapping(value = "/", method = RequestMethod.POST)
		public People createPerson(@Valid @RequestBody People people) {
			people.set_id(ObjectId.get());
			people.address = AddressController.getAddressbyLatLng(Integer.toString(people.latitude), Integer.toString(people.longitude));
			repository.save(people);
			return people;
		}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public void deletePerson(@PathVariable ObjectId id) {
			repository.delete(repository.findBy_id(id));
		}
}
