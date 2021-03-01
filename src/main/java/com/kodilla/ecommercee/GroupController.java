package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/api/groups")
public class GroupController {
    @GetMapping
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @PostMapping
    public void createGroup(@RequestBody GroupDto groupDto) {
    }

    @GetMapping("/{groupId}")
    public GroupDto getGroup(@PathVariable int groupId) {
        return new GroupDto(123, "First Group");
    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return new GroupDto(123, "Test content");
    }

}
