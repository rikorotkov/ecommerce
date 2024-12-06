package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}