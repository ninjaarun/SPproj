package com.ninjaarun.database.databasedemo.jpa;

import com.ninjaarun.database.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {

    //connect to the database
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);//JPA
    }
}