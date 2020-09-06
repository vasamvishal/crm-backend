package com.crm.customerRealtion.management.service;

import com.crm.customerRealtion.management.entity.Entity;
import com.crm.customerRealtion.management.model.BookRequest;
import com.crm.customerRealtion.management.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Repository bookRepository;

    public List<Entity> getAllBooks() {
        List<Entity> allBooks = bookRepository.findAll();
        if (allBooks.size() > 0) {
            return allBooks;
        }
        return new ArrayList<>();
    }

    public Entity save(BookRequest request) {
        Entity entity = request.toEntity(request);
        return bookRepository.save(entity);
    }

    public Entity update(BookRequest request) {
        Optional<Entity> user = bookRepository.findById(request.get_id());

        if (!user.isPresent()) {
            throw new ArithmeticException("id-" + request.get_id());
        }
        bookRepository.deleteById(request.get_id());
        request.set_id(request.get_id());
        Entity entity = request.toEntity(request);
        return bookRepository.save(entity);
    }

    public BookRequest delete(BookRequest request) {
        System.out.println(request);
        bookRepository.deleteById(request.get_id());
        return request;
    }
}
