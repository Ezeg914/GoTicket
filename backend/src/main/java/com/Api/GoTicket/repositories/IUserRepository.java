package com.Api.GoTicket.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Api.GoTicket.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT u FROM UserModel u " +
            "WHERE (:name IS NULL OR u.name = :name) " +
            "  AND (:lastName IS NULL OR u.lastName = :lastName) " +
            "  AND (:email IS NULL OR u.email = :email)")
    List<UserModel> findUsersByFilters(
            @Param("name") String name,
            @Param("lastName") String lastName,
            @Param("email") String email);
}
