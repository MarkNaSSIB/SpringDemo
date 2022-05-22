package com.NaSSIB.spring.SpringDemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NaSSIB.spring.SpringDemo.entity.UserDto;
import com.NaSSIB.spring.SpringDemo.repo.IUsersRepo;

@Service
public class UserServiceImpl implements IUserService {

  private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  IUsersRepo userRepository;

  @Override
  public UserDto registerNewUserAccount(UserDto userDto) {
    if (emailExist(userDto.getEmail())) {
      log.debug("There is an account with that email address: " + userDto.getEmail());
    }

    return userRepository.save(userDto);


  }

  private boolean emailExist(String email) {
    return userRepository.findByEmail(email) != null;
  }
}
