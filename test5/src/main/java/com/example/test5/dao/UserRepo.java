package com.example.test5.dao;

import com.example.test5.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {


}
