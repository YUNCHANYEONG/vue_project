package com.practice.project.security.service;


import com.practice.project.entity.UserEntity;
import com.practice.project.model.Roles;
import com.practice.project.model.User;
import com.practice.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);

        if(userEntity.isPresent()){
            User user = User.UserEntityToUser(userEntity.get(), passwordEncoder);
            List<Roles> roles = new ArrayList<>();
            roles.add(Roles.findByRoleValue(userEntity.get().getAuthority()));
            user.setRoles(roles);

            return user;
        }else{
            throw new UsernameNotFoundException("User is not Auth");
        }

    }

}
