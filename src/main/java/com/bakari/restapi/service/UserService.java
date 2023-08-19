package com.bakari.restapi.service;

import com.bakari.restapi.dto.UserCreateDto;
import com.bakari.restapi.dto.UserPatchDto;
import com.bakari.restapi.dto.UserPutDto;
import com.bakari.restapi.model.User;
import com.bakari.restapi.repository.UserRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User getUser(Long userId) throws IllegalStateException {
        Optional<User> userOpt = this.userRepository.findUserById(userId);

        if (userOpt.isEmpty()) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }

        return userOpt.get();
    }

    public User create(UserCreateDto userCreateDto) {
        User user = userMapper.map(userCreateDto, User.class);

        return this.userRepository.save(user);
    }

    public User put(Long id, UserPutDto userPutDto) {
        User user = this.getUser(id);

        userMapper.map(userPutDto, user);

        return this.userRepository.save(user);
    }

    public User patch(Long id, UserPatchDto userPatchDto) {
        User user = this.getUser(id);

        userMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        userMapper.map(userPatchDto, user);

        return this.userRepository.save(user);
    }


    public void delete(Long userId) throws IllegalStateException {
        try {
            this.userRepository.deleteById(userId);
        } catch (Exception e) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
    }
}
