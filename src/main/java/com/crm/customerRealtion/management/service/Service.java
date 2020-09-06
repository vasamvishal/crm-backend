package com.crm.customerRealtion.management.service;

import com.crm.customerRealtion.management.entity.Entity;
import com.crm.customerRealtion.management.model.Request;
import com.crm.customerRealtion.management.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Repository repository;

    public List<Entity> getAllBooks() {
        List<Entity> allBooks = repository.findAll();
        if (allBooks.size() > 0) {
            return allBooks;
        }
        return new ArrayList<>();
    }

    public Entity save(Request request) {
        Entity entity = request.toEntity(request);
        return repository.save(entity);
    }

    public Entity update(Request request) {
        Optional<Entity> user = repository.findById(request.get_id());

        if (!user.isPresent()) {
            throw new ArithmeticException("id-" + request.get_id());
        }
        repository.deleteById(request.get_id());
        request.set_id(request.get_id());
        Entity entity = request.toEntity(request);
        return repository.save(entity);
    }

    public Request delete(Request request) {
        System.out.println(request);
        repository.deleteById(request.get_id());
        return request;
    }
}
