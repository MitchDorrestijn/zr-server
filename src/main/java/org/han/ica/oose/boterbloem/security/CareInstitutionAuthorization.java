package org.han.ica.oose.boterbloem.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

/**
 * This interface provides a short custom annotation when a zorginstelling is authorized to do a request
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@PreAuthorize("hasRole(T(org.han.ica.oose.boterbloem.utils.enumerations.Roles).ROLE_ZORGINSTELLING)")
public @interface CareInstitutionAuthorization {
}