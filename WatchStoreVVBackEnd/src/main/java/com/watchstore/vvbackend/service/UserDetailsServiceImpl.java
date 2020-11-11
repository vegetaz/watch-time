package com.watchstore.vvbackend.service;

import com.watchstore.vvbackend.model.User;
import com.watchstore.vvbackend.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    final static Logger LOGGER = LoggerFactory.getLogger(UserDetailsService.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LOGGER.debug("Find user by email: {}", s);
        User user = userRepository.findByEmail(s).get();
        if (user == null) {
            LOGGER.debug("{} not found!", s);
            throw new UsernameNotFoundException("Email " + s + " not exits!");
        }
        List<String> role = user.getRole();
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        role.forEach(item -> {
            grantedAuthorityList.add(new SimpleGrantedAuthority(item));
        });
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails
                .User(user.getEmail(), user.getPassword(), grantedAuthorityList);
        return userDetails;
    }
}
