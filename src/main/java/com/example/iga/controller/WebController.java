package com.example.iga.controller;

import com.example.iga.Entity.Person;
import com.example.iga.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class WebController {

    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/countries")
    public List<Person> getAllCountries() {
        return personRepo.getAll();
    }

    @GetMapping("/countries/{countryId}")
    public Person getCountryById(@PathVariable("countryId") int id) {
        return personRepo.getById(id);
    }

    @PostMapping("/countries")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createCountry(@RequestBody Person country) {
        return personRepo.create(country);
    }

    @PutMapping("/countries/{countryId}")
    public Person updateCountry(@PathVariable("countryId") int id, @RequestBody Person country) {
        return personRepo.update(id, country);
    }

    @DeleteMapping("/countries/{countryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable("countryId") int id) {
        personRepo.delete(id);
    }

}
