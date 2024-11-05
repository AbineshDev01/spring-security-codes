package dev.abinesh.springsecurityex.repository;

import dev.abinesh.springsecurityex.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
