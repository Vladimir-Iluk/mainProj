package com.iluk.git.mainProj.data.Entitys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AgreementRepository extends CrudRepository<Agreement, Long> {

    Iterable<Agreement> findAllByOrderByAgreementIdAsc();
    Iterable<Agreement> findAllByOrderByAgreementIdDesc();
    @Query("SELECT a FROM Agreement a JOIN a.company c JOIN a.empl e " +
            "WHERE LOWER(a.pos) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "CAST(a.commission AS STRING) LIKE CONCAT('%', :searchTerm, '%') OR " +
            "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Iterable<Agreement> searchAcrossAllFields(@Param("searchTerm") String searchTerm);
}
