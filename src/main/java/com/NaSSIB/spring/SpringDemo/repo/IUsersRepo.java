package com.NaSSIB.spring.SpringDemo.repo;

import org.springframework.data.repository.CrudRepository;
import com.NaSSIB.spring.SpringDemo.entity.UserDto;

public interface IUsersRepo extends CrudRepository<UserDto, Integer> {

  Object findByEmail(String email);


}
