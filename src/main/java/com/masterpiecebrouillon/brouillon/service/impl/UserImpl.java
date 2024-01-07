package com.masterpiecebrouillon.brouillon.service.impl;

import com.masterpiecebrouillon.brouillon.dto.LoginDTO;
import com.masterpiecebrouillon.brouillon.dto.UserModelDTO;
import com.masterpiecebrouillon.brouillon.model.User;
import com.masterpiecebrouillon.brouillon.repository.UserRepository;
import com.masterpiecebrouillon.brouillon.repository.response.LoginResponse;
import com.masterpiecebrouillon.brouillon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserModelDTO userModelDTO) {
        User user = new User(
                userModelDTO.getUserId(),
                userModelDTO.getUserName(),
                userModelDTO.getEmail(),
                this.passwordEncoder.encode(userModelDTO.getPassword())
        );
        userRepository.save(user);
        return user.getUserName();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exits", false);
        }
    }
}


