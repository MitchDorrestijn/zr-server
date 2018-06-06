package org.han.ica.oose.boterbloem.domain.domainobjects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {

    private String userName;
    private String token;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(String userName, String password, String token, List<GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.password = password;
        this.token = token;
        this.authorities = grantedAuthorities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return userName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return true;
    }


}
