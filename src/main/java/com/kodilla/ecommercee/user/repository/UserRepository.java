package com.kodilla.ecommercee.user.repository;

import com.kodilla.ecommercee.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();

    @Query
    Optional<User> findById(Long id);

    //@Query
    //List<User> findActiveUsers();

    @Override
    User save(User user);

    @Query
    void deleteById(Long id);
}
