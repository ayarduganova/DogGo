package nen.co.doggo.security.service;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.repository.UserRepository;
import nen.co.doggo.security.user.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.getUserEntityByUsername(username);
        return user.map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}

