package com.masterpiecebrouillon.brouillon.service;

import com.masterpiecebrouillon.brouillon.dto.LoginDTO;
import com.masterpiecebrouillon.brouillon.dto.UserModelDTO;
import com.masterpiecebrouillon.brouillon.response.LoginResponse;

public interface UserService {
    String addUser(UserModelDTO userModelDTO);
    LoginResponse loginUser(LoginDTO loginDTO);

}
