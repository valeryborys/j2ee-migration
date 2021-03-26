package com.softeq.jm.service;

import com.softeq.jm.repository.SpringUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SpringUserService implements UserDetailsService {

    private final SpringUserRepository userRepository;

    @Autowired
    public SpringUserService(SpringUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.softeq.jm.model.User userByEmail = userRepository.getUserByEmail(s);
        if (userByEmail == null){
            throw new UsernameNotFoundException("Email does not found");
        }
        UserDetails user = User.withUsername(userByEmail.getEmail()).password(userByEmail.getPassword()).authorities("USER").build();
        return user;
    }

    public boolean saveUser(com.softeq.jm.model.User user) {
        com.softeq.jm.model.User userByEmail = userRepository.getUserByEmail(user.getEmail());

        if (userByEmail != null) {
            return false;
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}