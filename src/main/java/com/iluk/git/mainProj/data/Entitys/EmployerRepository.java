package com.iluk.git.mainProj.data.Entitys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployerRepository extends CrudRepository<Employer, Long> {

    Iterable<Employer> findAllByOrderByEmployerIdAsc();
    Iterable<Employer> findAllByOrderByEmployerIdDesc();

    @Query(value = "SELECT * FROM employers e WHERE " +
            "LOWER(e.last_name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.first_name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.middle_name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.qualification) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.activity_type) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(e.other_info) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "CAST(e.expected_salary AS CHAR) LIKE CONCAT('%', :searchTerm, '%')",
            nativeQuery = true)
    Iterable<Employer> searchAcrossAllFields(@Param("searchTerm") String searchTerm);
}
