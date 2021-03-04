package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupDbService {
    @Autowired
    private final GroupRepository repository;

    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    public Optional<Group> getGroup(final Long groupId) {
        return repository.findById(groupId);
    }

    public Group saveGroup(Group group) {
        return repository.save(group);
    }
}
