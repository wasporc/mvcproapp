package org.mymvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mymvc.repo.ProductDao;
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
    private ProductDao productDao;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getList(){
        return gson.toJson(productDao.findAll());
    }

}
