package com.app.repository;

import com.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
<<<<<<< HEAD
    User findByUsername(String username);
    User findByEmail(String email); // Add this method
}
=======
<<<<<<< HEAD
    User findByUsername(String username);
    User findByEmail(String email); // Add this method
=======
	User findByUsername(String username);
    // Add custom query methods if needed
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
}
>>>>>>> b854fc5e188cba5df25932dc753a0015f9a67bb7
