package foodzie.person.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import foodzie.person.Person;
import foodzie.person.dao.PersonRepository;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@Component
public class PersonController {

  @Autowired
  PersonRepository personRepository;
  @Autowired
  PasswordEncoder passwordEncoder;

  @RequestMapping(value = "/all", method = GET, produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<Person> getPeople() {
    return personRepository.findAll();
  }

  @RequestMapping(value = "/search", method = GET, produces = APPLICATION_JSON_VALUE)
  public List<Person> searchPeople(
      @RequestParam(value = "email", required = false) String email,
      @RequestParam(value = "first_name", required = false) String firstName,
      @RequestParam(value = "last_name", required = false) String lastName,
      @RequestParam(value = "id", required = false) Long id,
      @RequestParam(value = "date_of_birth", required = false) LocalDate dateOfBirth,
      @RequestParam(value = "username", required = false) String username) {
    final Person person = Person.builder()
        .id(id)
        .email(email)
        .firstName(firstName)
        .lastName(lastName)
        .username(username)
        .dateOfBirth(dateOfBirth)
        .build();
    return personRepository.findAll(Example.of(person));
  }

  @RequestMapping(value = "/create", method = POST, consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity createPerson(@RequestBody @Valid Person person) {
    person.setPassword(passwordEncoder.encode(person.getPassword()));
    personRepository.saveAndFlush(person);
    return ResponseEntity.status(CREATED).build();
  }

  @RequestMapping(value = "/delete", method = DELETE)
  public ResponseEntity deletePerson(@RequestParam("id") Long id) {
    personRepository.delete(id);
    return ResponseEntity.status(OK).build();
  }

}
