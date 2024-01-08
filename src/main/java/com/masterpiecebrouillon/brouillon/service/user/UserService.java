package com.masterpiecebrouillon.brouillon.service.user;

import com.masterpiecebrouillon.brouillon.dto.login.LoginDTO;
import com.masterpiecebrouillon.brouillon.dto.user.UserModelDTO;
import com.masterpiecebrouillon.brouillon.repository.response.LoginResponse;

public interface UserService {
    String addUser(UserModelDTO userModelDTO);
    LoginResponse loginUser(LoginDTO loginDTO);

}
