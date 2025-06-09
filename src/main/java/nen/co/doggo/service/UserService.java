package nen.co.doggo.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.UserRequest;
import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.mapper.UserMapper;
import nen.co.doggo.repository.UserRepository;
import nen.co.doggo.security.user.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void signUp(UserRequest userRequest) {
        userRepository.save(userMapper.toEntity(userRequest));
    }

    public boolean exist(String username){
        return userRepository.existsByUsername(username);
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public void editProfileInfo(UserEntity user, UserRequest userRequest) {
        userRepository.save(userMapper.updateEntityFromRequest(userRequest, user));
    }
}

