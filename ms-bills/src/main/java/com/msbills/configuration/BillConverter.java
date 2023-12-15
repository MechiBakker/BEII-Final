package com.msbills.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class BillConverter implements Converter<Jwt, Collection<GrantedAuthority>>{
    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String, Object> realmRoles = source.getClaim("realm_access");

        if (realmRoles == null && realmRoles.isEmpty()) {
            return new ArrayList<>();
        }

        Collection<GrantedAuthority> userAuthorities = ((List<String>) realmRoles.get("roles"))
                .stream().map(role -> ("ROLE_" + role))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return userAuthorities;
    }

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String, Object> realmRoles = source.getClaim("realm_access");

        if (realmRoles == null && realmRoles.isEmpty()) {
            return new ArrayList<>();
        }
        Collection<GrantedAuthority> groupAuthorities = ((List<String>) realmRoles.get("grupos"))
                .stream().map(role -> ("GROUP_" + role))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return groupAuthorities;
    }

    }
}
