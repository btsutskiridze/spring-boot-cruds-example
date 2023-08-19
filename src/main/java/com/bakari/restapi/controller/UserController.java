package com.bakari.restapi.controller;

import com.bakari.restapi.dto.UserCreateDto;
import com.bakari.restapi.dto.UserPatchDto;
import com.bakari.restapi.dto.UserPutDto;
import com.bakari.restapi.model.User;
import com.bakari.restapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable("id") Long userId) {
        User user = this.userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        User createdUser = this.userService.create(userCreateDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<User> putUser(@PathVariable("id") Long userId, @Valid @RequestBody UserPutDto userPutDto) {
        User updatedUser = this.userService.put(userId, userPutDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<User> patchUser(@PathVariable("id") Long userId, @Valid @RequestBody UserPatchDto userPatchDto) {
        if (userPatchDto.isEmpty()) {
            throw new IllegalStateException("Request body of patch cannot be empty");
        }

        User updatedUser = this.userService.patch(userId, userPatchDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
        this.userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
