package it.unimol.gelid.repositories;


import it.unimol.gelid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsernameAndPassword(String username, String password);
    boolean existsByUsernameIgnoreCase(String username);
}
