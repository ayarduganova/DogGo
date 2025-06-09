package nen.co.doggo.service;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.UserRequest;
import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.mapper.UserMapper;
import nen.co.doggo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

