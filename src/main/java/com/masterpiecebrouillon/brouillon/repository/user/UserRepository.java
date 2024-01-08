package com.masterpiecebrouillon.brouillon.repository.user;

import com.masterpiecebrouillon.brouillon.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
