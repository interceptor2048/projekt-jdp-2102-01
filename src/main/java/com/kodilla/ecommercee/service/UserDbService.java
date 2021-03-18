package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDbService {

    @Autowired
    private final UserRepository repository;

    public List<User> getAllUsers() { return repository.findAll(); }

    public Optional<User> getUser(final Long userId) { return repository.findById(userId); }

    public void deleteUser(final Long userId) { repository.deleteById(userId); }

    public User saveUser(User user) { return repository.save(user); }
}
