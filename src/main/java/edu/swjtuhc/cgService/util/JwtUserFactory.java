package edu.swjtuhc.cgService.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import edu.swjtuhc.cgService.model.JwtUser;
import edu.swjtuhc.cgService.model.SysUser;



public final class JwtUserFactory {
 
    private JwtUserFactory() {
    }
 
    public static JwtUser create(SysUser user) {
        return new JwtUser(
                user.getuId(),
                user.getAccount(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRoles()),
                user.getLastPasswordResetDate()
        );
    }
 
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
