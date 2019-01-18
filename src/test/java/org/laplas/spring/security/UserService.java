package org.laplas.spring.security;

import javax.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Business-layer class offering user-management functionality.
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
@Service
public class UserService {

    /**
     * @return name of already authenticated user.
     */
    @Secured("ROLE_USER")
    public String getSecuredName() {
        return getName();
    }

    @RolesAllowed("authenticated")
    public String getRolesAllowedName() {
        return getName();
    }

    private String getName() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
    }
}
