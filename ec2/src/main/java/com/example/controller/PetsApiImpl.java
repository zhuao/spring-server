package com.example.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;

//@Configuration
public class PetsApiImpl /*implements PetsApiDelegate*/ {

//    @Override
//    public ResponseEntity<Pet> addPet(Pet pet) {
//        if ( ! Validation.buildDefaultValidatorFactory().getValidator().validate(pet).isEmpty()) {
//            return ResponseEntity.badRequest().body(null);
//        }
//
//        return ResponseEntity.ok(pet);
//    }
//
//    @Override
//    public ResponseEntity<List<Pet>> findPets() {
//        Pet pet = new Pet();
//        pet.setName("foo");
//        List<Pet> pets = new ArrayList<>();
//        pets.add(pet);
//        return ResponseEntity.ok(pets);
//    }
}
