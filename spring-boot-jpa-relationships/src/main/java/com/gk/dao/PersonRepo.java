package com.gk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.entity.Person;
/**
 * 
 * @author Gangadhar
 *
 */
@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
