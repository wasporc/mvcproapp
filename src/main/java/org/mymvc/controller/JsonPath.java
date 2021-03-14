package org.mymvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mymvc.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("json")
public class JsonPath {

    private static Gson gson = new GsonBuilder().create();

    @Autowired
    private ProductRepository repository;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String  get() {
        return  gson.toJson(repository.findAll());
    }

}
