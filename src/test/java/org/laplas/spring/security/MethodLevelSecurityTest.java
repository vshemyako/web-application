package org.laplas.spring.security;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Simple test cases to verify and examine method-level security offered by Spring Security framework.
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ConfigurationMarker.class)
public class MethodLevelSecurityTest {

    @Autowired
    private UserService userService;

    @Test
    @WithMockUser
    public void shouldBeAllowedToRequestSecuredName() {
        String expectedName = "user";
        String actualName = userService.getSecuredName();
        assertEquals(expectedName, actualName);
    }

    @Test
    @WithMockUser(roles = "authenticated")
    public void shouldBeAllowedToRequestRolesAllowedName() {
        String expectedName = "user";
        String actualName = userService.getRolesAllowedName();
        assertEquals(expectedName, actualName);
    }

    @Test(expected = AccessDeniedException.class)
    @WithAnonymousUser
    public void shouldBeRestrictedToRequestName() {
        userService.getSecuredName();
    }
}
