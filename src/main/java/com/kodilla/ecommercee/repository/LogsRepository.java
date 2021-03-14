package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Logs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface LogsRepository extends CrudRepository<Logs, Long> {
    List<Logs> findAll();
    Logs save(Logs log);
}
