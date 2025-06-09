package nen.co.doggo.service;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.UserRequest;
import nen.co.doggo.entity.UserEntity;
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
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserRequest userRequest) {
        UserEntity user = UserEntity.builder()
                .username(userRequest.username())
                .password(passwordEncoder.encode(userRequest.password()))
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .phone(userRequest.phone())
                .birthday(userRequest.birthday())
                .gender(userRequest.gender())
                .roles(Set.of(Role.USER))
                .isActive(true)
                .build();

        userRepository.save(user);
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

}

