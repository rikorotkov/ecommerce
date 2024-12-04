package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
