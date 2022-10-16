package net.codejava.repository;

import net.codejava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

	public boolean existsByEmail(String email);
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);

}
