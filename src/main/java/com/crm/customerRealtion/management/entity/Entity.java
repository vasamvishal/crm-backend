package com.crm.customerRealtion.management.entity;

import javax.persistence.Id;
import java.util.Objects;

@javax.persistence.Entity
public class Entity {
    @Id
    private Integer _id;
    private String name;
    private Integer age;
    private String colour;

    public Entity() {
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

    public Entity(Integer _id, String name, Integer age, String colour) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(_id, entity._id) &&
                Objects.equals(name, entity.name) &&
                Objects.equals(age, entity.age) &&
                Objects.equals(colour, entity.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, age, colour);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                '}';
    }
}
