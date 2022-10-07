package ru.brinicle.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.brinicle.authorization.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
