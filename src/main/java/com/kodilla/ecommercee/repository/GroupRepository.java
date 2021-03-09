package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findAll();

    Optional<Group> findById(Long id);

    Group save(Group group);

    void deleteById(Long id);
}
