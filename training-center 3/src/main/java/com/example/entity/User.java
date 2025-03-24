package com.example.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L; //  Fix serializable warning

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String firstName;

    private String lastName;
    private String gender;
    private Date birthday;
    private String city;
    private String phoneNo;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // Admin, Trainer, Student

    private String authorities; // ✅ Ensure authorities field exists

    // ✅ Implements getAuthorities() correctly
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.authorities == null || this.authorities.isEmpty()) {
            return List.of();
        }
        return Arrays.stream(this.authorities.split(","))
                     .map(SimpleGrantedAuthority::new)
                     .collect(Collectors.toList());
    }

    // ✅ Uses email as username
    @Override
    public String getUsername() {
        return email;
    }

    // ✅ Required Security Methods (Return True for Now)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public String getPassword() {
        return password;
    }

}
