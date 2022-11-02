package com.carrezerv.company.controller;

import com.carrezerv.company.dto.UserEntityDto;
import com.carrezerv.company.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rezer-cars")
@RequiredArgsConstructor
public class UserEntityController {
    private final UserEntityService userEntityService;

    @PostMapping("/user")
    public void createUser(@RequestBody UserEntityDto userEntityDto) {

        userEntityService.create(userEntityDto);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserEntityDto>> getAll() {
        List<UserEntityDto> userEntityDtoList = userEntityService.getAll();
        return ResponseEntity.ok(userEntityDtoList);
    }

    @PatchMapping("/user/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody UserEntityDto userEntityDto) {
        userEntityService.update(id, userEntityDto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userEntityService.deleteById(id);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntityDto> findById(@PathVariable Integer id) {
        UserEntityDto user = userEntityService.findById(id);
        return ResponseEntity.ok(user);
    }
}
