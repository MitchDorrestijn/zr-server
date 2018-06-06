package org.han.ica.oose.boterbloem.utils.enumerations;

import org.springframework.security.core.GrantedAuthority;

/**
 * This enum provides th availible user roles
 */
public enum Roles implements GrantedAuthority {
    ROLE_ADMIN, ROLE_ZORGINSTELLING;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthority() {
        return name();
    }
}
