package com.example.test4.dao;

import com.example.test4.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien,Integer> {

}
