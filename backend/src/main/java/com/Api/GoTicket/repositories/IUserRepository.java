package com.Api.GoTicket.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Api.GoTicket.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;



@Repository
@Transactional
public interface IUserRepository extends JpaRepository<UserModel, Long> {

    UserModel save(UserModel model);



    @Query("SELECT u FROM UserModel u " +
            "WHERE (:name IS NULL OR u.name = :name) " +
            "  AND (:lastName IS NULL OR u.lastName = :lastName) " +
            "  AND (:email IS NULL OR u.email = :email)")
    List<UserModel> findUsersByFilters(
            @Param("name") String name,
            @Param("lastName") String lastName,
            @Param("email") String email);
    UserModel findByEmailAndPassword(String email, String password);

    UserModel findByEmail(String email);

    UserModel getUserByEmail(UserModel userModel);


    Optional<UserModel> findOneByEmail(String email);



}
