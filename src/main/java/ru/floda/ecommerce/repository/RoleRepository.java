package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
