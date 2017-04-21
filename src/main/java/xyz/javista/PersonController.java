package xyz.javista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.javista.dto.PersonDTO;
import xyz.javista.mapper.PersonMapper;
import xyz.javista.repository.PersonRepository;

import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<PersonDTO> getPersons() {
        return personMapper.toDTO(personRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PersonDTO getPerson(@PathVariable(name = "id") Integer id) {
        return personMapper.toDTO(personRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO add(@RequestBody PersonDTO personDTO) {
        return personMapper.toDTO(personRepository.add(personDTO));
    }
}
