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
            "WHERE (:companyId IS NULL OR t.company.id = :companyId) " +
            "  AND (:cityFromId IS NULL OR t.city_from.id = :cityFromId) " +
            "  AND (:cityToId IS NULL OR t.city_to.id = :cityToId)")
    Page<TripModel> findFilteredTrips(
            @Param("companyId") Long companyId,
            @Param("cityFromId") Long cityFromId,
            @Param("cityToId") Long cityToId,
            Pageable pageable);
}