/**
 * 
 */
package com.crossover.techtrial.controller;

import java.util.ArrayList;
import java.util.List;

import com.crossover.techtrial.dto.PersonDTO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crossover.techtrial.model.Person;
import com.crossover.techtrial.service.PersonService;

/**
 * 
 * @author crossover
 */

@RestController
public class PersonController {

  @Autowired
  PersonService personService;

  @Autowired
  DozerBeanMapper mapper;
  
  @PostMapping(path = "/api/person")
  public ResponseEntity<Person> register(@RequestBody PersonDTO p) {
    return ResponseEntity.ok(personService.save(mapper.map(p,Person.class)));
  }
  
  @GetMapping(path = "/api/person")
  public ResponseEntity<List<PersonDTO>> getAllPersons() {
    List<PersonDTO> all = new ArrayList<>();
    mapper.map(personService.getAll(),all);
    return ResponseEntity.ok(all);
  }
  
  @GetMapping(path = "/api/person/{person-id}")
  public ResponseEntity<PersonDTO> getPersonById(@PathVariable(name="person-id", required=true)Long personId) {
    Person person = personService.findById(personId);
    if (person != null) {
      PersonDTO dto = mapper.map(person, PersonDTO.class);
      return ResponseEntity.ok(dto);
    }
    return ResponseEntity.notFound().build();
  }
  
}
