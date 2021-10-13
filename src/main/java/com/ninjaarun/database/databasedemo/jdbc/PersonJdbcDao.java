package com.ninjaarun.database.databasedemo.jdbc;

import com.ninjaarun.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll()
    {
        return     jdbcTemplate.query("Select * from Person", new BeanPropertyRowMapper<Person>(Person.class));

    }
hh
    public Person findSpecificData(String loca)
    {
        return jdbcTemplate.queryForObject
                ("select * from Person where location=?", new Object[]{loca},
                        new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject
                ("select * from person where id=?", new Object[] { id },
                        new BeanPropertyRowMapper<Person>(Person.class));
    }

    public  int deleteById(int id)
    {
        return jdbcTemplate.update("delete from Person where id = ?", id);
    }

    public int insertData(int id, String name, String location)
    {
        return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (?, ?, ?, ?)",
                id, name, location, "2021-09-10 00:00:00.0");
    }




}
