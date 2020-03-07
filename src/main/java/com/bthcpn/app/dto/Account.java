package com.bthcpn.app.dto;

import org.springframework.security.core.GrantedAuthority;


import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

import java.util.Collection;

@Data
public class Account implements UserDetails {
    private String id;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Collection<? extends GrantedAuthority>authorities;


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }


    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }


}
