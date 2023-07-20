package com.Api.GoTicket.repositories;

import org.springframework.stereotype.Repository;
import com.Api.GoTicket.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long>{
}
