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

    public User saveUser(User user) {
        LocalDateTime now=LocalDateTime.now();
        user.setLocalDateTime(now);
        return repository.save(user);
    }

    public Long generateRandomKey(final Long id) {
     User user = repository.getUserById(id);
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(user.getLocalDateTime(), now);
        if (duration.toHours() > 1 || user.getLocalDateTime() == null) {
            long generatedLong = new Random().nextLong();
            user.setUserKey(generatedLong);
            user.setLocalDateTime(now);
            repository.save(user);
            return generatedLong;
        } else {
            return null;
        }
    }
        public boolean validateGeneratedKey(Long id, Long key) throws NotFoundException {
            User user = repository.getUserById(id);
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(user.getLocalDateTime(), now);
            if(user.getUserKey() != null && user.getUserKey().equals(key)
                    && duration.toHours() < 1 ) {
                return true;
            } else {
                throw new NotFoundException("Either Your key is wrong, or 1 hour timestamp expired");
            }
        }
    }


