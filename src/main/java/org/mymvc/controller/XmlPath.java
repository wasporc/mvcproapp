package org.mymvc.controller;

import org.mymvc.entity.Product;
import org.mymvc.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("xml")
public class XmlPath {

    @Autowired
    private ProductRepository repository;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Product> get() {
        return repository.findAll();
    }
}
