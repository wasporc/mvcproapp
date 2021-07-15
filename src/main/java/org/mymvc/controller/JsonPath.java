package org.mymvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mymvc.entity.Product;
import org.mymvc.repo.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("json")
public class JsonPath {

    private static Logger logger = LoggerFactory.getLogger(JsonPath.class);
    private static Gson gson = new GsonBuilder().create();

    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "/product/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getList(){
        return gson.toJson(productDao.findAll());
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getById(@PathVariable Integer id){
        logger.info("id = {}", id);
        Product product = (Product) productDao.getById(id);
        logger.info(product.toString());
        return gson.toJson(product);
    }

    @GetMapping(value = "/product/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(){
        return gson.toJson(productDao.save(new Product("potato", 3.3)));
    }

}
