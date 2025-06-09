package nen.co.doggo.mapper;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.UserResponse;
import nen.co.doggo.security.user.Role;
import org.mapstruct.Mapping;
import nen.co.doggo.dto.UserRequest;
import nen.co.doggo.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserMapper implements StandartMapper<UserRequest, UserEntity, UserResponse> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity toEntity(UserRequest userRequest) {
        return UserEntity.builder()
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
    }

    @Override
    public UserEntity updateEntityFromRequest(UserRequest userRequest, UserEntity userEntity) {
        userEntity.setFirstName(userRequest.firstName());
        userEntity.setLastName(userRequest.lastName());
        userEntity.setGender(userRequest.gender());
        userEntity.setBirthday(userRequest.birthday());
        userEntity.setEmail(userRequest.email());
        userEntity.setPhone(userRequest.phone());

        return userEntity;
    }

    @Override
    public UserResponse toResponse(UserEntity userEntity) {
        return null;
    }

}
