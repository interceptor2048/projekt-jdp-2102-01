package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import com.kodilla.ecommercee.service.UserDbService;
import com.kodilla.ecommercee.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("GroupController")
@RequestMapping("/v1/group")
public class GroupController {
    private final GroupMapper mapper;
    private final GroupDbService service;

    @Autowired
    UserDbService userDbService;

    @Autowired
    public GroupController(GroupMapper mapper, GroupDbService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping(value = "getAllGroups")
    public List<GroupDto> getGroups() {
        List<Group> groups = service.getAllGroups();
        return mapper.mapToGroupDtoList(groups);
    }

    @PostMapping(value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        Group group = mapper.mapToGroup(groupDto);
        service.saveGroup(group);
    }

    @GetMapping("getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        return mapper.mapToGroupDto(service.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto, @RequestParam Long userId, @RequestParam Long key) throws NotFoundException {
        userDbService.validateGeneratedKey(userId,key);
        Group group = mapper.mapToGroup(groupDto);
        Group savedGroup = service.saveGroup(group);
        return mapper.mapToGroupDto(savedGroup);
    }
}