package com.crm.customerRealtion.management.model;

import com.crm.customerRealtion.management.entity.Entity;

import java.util.Objects;

public class BookRequest {
    Integer _id;
    String name;
    Integer age;
    String colour;

    public BookRequest(Integer _id, String name, Integer age, String colour) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.colour = colour;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRequest that = (BookRequest) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, age, colour);
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                '}';
    }

    public Entity toEntity(BookRequest request) {
        return new Entity(request._id,request.name, request.age,request.colour);
    }
}