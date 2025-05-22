package com.exam.Synchrony.service;


import com.exam.Synchrony.model.User;
import com.exam.Synchrony.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    void testRegisterUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        User registeredUser = userService.registerUser(user);

        assertEquals("testUser", registeredUser.getUsername());
    }

    @Test
    void testAuthenticate() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");

        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));
        Optional<User> authenticatedUser = userService.authenticate("testUser", "password");

        assertTrue(authenticatedUser.isPresent());
    }
}
