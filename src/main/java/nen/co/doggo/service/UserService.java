package nen.co.doggo.service;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.req.UserRequest;
import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.mapper.UserMapper;
import nen.co.doggo.repository.UserRepository;
import nen.co.doggo.security.user.Role;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    public void editUser(UserEntity user, String blockAction, Map<String, String> form, String btnAction) {
        if(btnAction.equals("delete")){
            deleteUser(user);
        }
        else {
            if ("yes".equals(blockAction)) {
                user.setActive(!user.isActive());
            }

            Set<Role> newRoles = new HashSet<>();
            for (String key : form.keySet()) {
                if (Role.getStringRoles().contains(key)) {
                    newRoles.add(Role.valueOf(key));

                }
            }
            if(user.getRoles().contains(Role.ADMIN)){
                user.setAdmin(true);
            }

            user.setRoles(newRoles);

            saveUser(user);
        }
    }

    private void deleteUser(UserEntity user){
        userRepository.delete(user);
    }

    public void addRole(UserEntity user, Role role) {
        user.getRoles().add(role);
        userRepository.save(user);
    }
}

