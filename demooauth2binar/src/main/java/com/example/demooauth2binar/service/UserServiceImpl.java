package com.example.demooauth2binar.service;

import com.example.demooauth2binar.model.User;
import com.example.demooauth2binar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public void createUserPostLogin(String name, String email) {
        User user = getByUsername(email);
        if(user == null){
            user = new User()
                    .setName(name)
                    .setEmail(email)
                    .setUsername(email);
            userRepository.save(user);
        }
    }

    public User getByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(userOptional.isEmpty()){
            return null;
        }
        return userOptional.get();
    }
}
