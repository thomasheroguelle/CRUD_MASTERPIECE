package com.masterpiecebrouillon.brouillon.controller;

import com.masterpiecebrouillon.brouillon.dto.LoginDTO;
import com.masterpiecebrouillon.brouillon.dto.UserModelDTO;
import com.masterpiecebrouillon.brouillon.repository.response.LoginResponse;
import com.masterpiecebrouillon.brouillon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
//    @PostMapping(path = "/save")
//    public String saveUser(@RequestBody UserModelDTO userModelDTO)
//    {
//        String id = userService.addUser(userModelDTO);
//        return id;
//    }
@PostMapping(path = "/save")
public ResponseEntity<String> saveUser(@RequestBody UserModelDTO userModelDTO) {
    String userName = userService.addUser(userModelDTO);
    return ResponseEntity.ok("User created with username: " + userName);
}
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
