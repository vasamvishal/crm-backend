package com.crm.customerRealtion.management.controller;

import com.crm.customerRealtion.management.entity.Entity;
import com.crm.customerRealtion.management.model.Request;
import com.crm.customerRealtion.management.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3006")
@Controller
public class crmController {
    @Autowired
    Service service;

    @GetMapping(path = "/getAll")

    public ResponseEntity<List<Entity>> getAllBooks(
    ) {
        try {
            List<Entity> books = service.getAllBooks();
            System.out.println(books);
            return ResponseEntity.ok().body(books);
        } catch (Exception e) {
            System.out.println("EException" + e);
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(path = "/users/save")
    public ResponseEntity<Entity> saveBooks(@RequestBody Request request) {
        try {
            Entity data = service.save(request);
            if (data != null) {
                System.out.println("data" + data);
                return ResponseEntity.ok().body(data);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(path = "/users/edit")
    public ResponseEntity<Entity> update(
            @RequestBody Request request) {
        try {
            Entity servicevalue = service.update(request);
            return ResponseEntity.ok().body(servicevalue);
        } catch (ArithmeticException e) {
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            System.out.println(e);
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(path = "/users/delete")
    public ResponseEntity<Request> delete(
            @RequestBody Request request) {
        try {
            Request deleteService = service.delete(request);
            return ResponseEntity.ok().body(deleteService);
        } catch (ArithmeticException e) {
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
