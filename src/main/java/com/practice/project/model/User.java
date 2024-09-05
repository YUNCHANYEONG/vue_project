package com.practice.project.model;


import com.practice.project.entity.UserEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    private String userid;
    private String email;
    private String password;
    private List<Roles> Roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleKey()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public static User UserEntityToUser(UserEntity userEntity, PasswordEncoder passwordEncoder){
        User user = new User();
        user.setUserid(userEntity.getUserid());
        user.setEmail(userEntity.getEmail());
        user.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return user;
    }
}
