package org.mymvc.controller;

import org.mymvc.entity.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("xml")
public class XmlPath {
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_XML_VALUE)
    public Product get() {
        return new Product(2, "Blue key", 2);
    }
}
