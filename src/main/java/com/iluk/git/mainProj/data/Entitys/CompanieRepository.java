package com.iluk.git.mainProj.data.Entitys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompanieRepository extends CrudRepository<Companie, Long> {
    Iterable<Companie> findAllByOrderByCompanyIdAsc();
    Iterable<Companie> findAllByOrderByCompanyIdDesc();
    @Query("SELECT c FROM Companie c WHERE " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.activityType) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.address) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.phone) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Iterable<Companie> searchAcrossAllFields(@Param("searchTerm") String searchTerm);
}
