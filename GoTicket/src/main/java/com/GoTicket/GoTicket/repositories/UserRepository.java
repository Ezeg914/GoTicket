package com.GoTicket.GoTicket.repositories;

import com.GoTicket.GoTicket.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
