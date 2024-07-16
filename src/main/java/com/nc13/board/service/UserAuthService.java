package com.nc13.board.service;

import com.nc13.board.model.entity.UsersEntity;
import com.nc13.board.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UsersEntity users = usersRepository.findBy(username)
//                .orElseThrow(() -> new UsernameNotFoundException("username"));
        return null;
    }
}
