package com.crm.customerRealtion.management.repository;

import com.crm.customerRealtion.management.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Repository extends JpaRepository<Entity, Integer> {

//    @Transactional
//    @Modifying
//    @Query(value="update Entity c set c.age = :age and c.name=:name and c.colour=:colour WHERE c._id = :_id",nativeQuery = true)
//    Entity updateQuantity(@Param("_id") Integer _id, @Param("name") String name, @Param("age") Integer age,@Param("colour") String colour);
}
