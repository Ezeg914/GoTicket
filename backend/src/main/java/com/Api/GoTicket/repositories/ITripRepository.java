package com.Api.GoTicket.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Api.GoTicket.models.TripModel;

@Repository
public interface ITripRepository extends JpaRepository<TripModel, Long>{

    @Query("SELECT t FROM TripModel t " +
            "WHERE (:companyName IS NULL OR t.company.name = :companyName) " +
            "  AND (:cityFromName IS NULL OR t.city_from.name = :cityFromName) " +
            "  AND (:cityToName IS NULL OR t.city_to.name = :cityToName)")
    Page<TripModel> findFilteredTrips(
            @Param("companyName") String companyName,
            @Param("cityFromName") String cityFromName,
            @Param("cityToName") String cityToName,
            Pageable pageable);
}