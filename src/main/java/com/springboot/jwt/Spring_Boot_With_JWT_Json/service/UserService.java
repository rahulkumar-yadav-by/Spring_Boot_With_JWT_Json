package com.springboot.jwt.Spring_Boot_With_JWT_Json.service;


import com.springboot.jwt.Spring_Boot_With_JWT_Json.model.User;
import com.springboot.jwt.Spring_Boot_With_JWT_Json.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User getUser(ObjectId userId){
        Optional<User>optionalUser = userRepository.findById(userId);
        return optionalUser.orElseGet(optionalUser::get);
    }


    public String saveUser(User user){
        User savedUser= userRepository.save(user);
       return ("{\nMessage :\nSuccessfully Created User " +
               "\nUser Data :\n\tId : "+ savedUser.getId()+"\n\tName : "+savedUser.getName()+"\n\tEmail : "+savedUser.getEmail()+"\n\tPassword : "+savedUser.getPassword()+"\n"+
               "Token :\n\t" +tokenService.createToken(savedUser.getId())+
               "\n}"
       );
    }


}
