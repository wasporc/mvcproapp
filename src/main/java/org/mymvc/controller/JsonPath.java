package org.mymvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mymvc.entity.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("json")
public class JsonPath {

    private static Gson gson = new GsonBuilder().create();

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String  get() {
        return  gson.toJson(new Product(1,"Red key", 1));
    }

}
