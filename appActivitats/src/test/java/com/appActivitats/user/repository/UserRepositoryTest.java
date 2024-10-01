package com.appActivitats.entity.user.repository;

import com.appActivitats.entity.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId("ave123maria");
        user.setFirstName("Dani");
        user.setLastName("Diaz");
        user.setEmail("dani@test.com");
        userRepository.save(user);
    }

    @Test
    void testFindById() {
        Optional<User> foundUser = userRepository.findByid("ave123maria");
        assertTrue(foundUser.isPresent());
        assertEquals(user.getId(), foundUser.get().getId());
    }

    @Test
    void testFindByFirstName() {
        Optional<User> foundUser = userRepository.findByfirstName("Dani");
        assertTrue(foundUser.isPresent());
        assertEquals("Dani", foundUser.get().getFirstName());
    }

    @Test
    void testFindByLastName() {
        Optional<User> foundUser = userRepository.findBylastName("Diaz");
        assertTrue(foundUser.isPresent());
        assertEquals("Diaz", foundUser.get().getLastName());
    }

    @Test
    void testFindByEmail() {
        Optional<User> foundUser = userRepository.findByEmail("dani@test.com");
        assertTrue(foundUser.isPresent());
        assertEquals("dani@test.com", foundUser.get().getEmail());
    }

    @Test
    void testFindAllByOrderByRegistrationDate() {
        List<User> users = userRepository.findAllByOrderByRegistrationDate();
        assertFalse(users.isEmpty());
    }

    @Test
    void testDeleteByFirstName() {
        userRepository.deleteByfirstName("Dani");
        Optional<User> foundUser = userRepository.findByfirstName("Dani");
        assertFalse(foundUser.isPresent());
    }
}