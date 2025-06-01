package com.iluk.git.mainProj.data.Entitys;

import org.springframework.data.repository.CrudRepository;

public interface EmployerRepository extends CrudRepository<Employer, Long> {
    Iterable<Employer> findAllByOrderByEmployerIdAsc();
    Iterable<Employer> findAllByOrderByEmployerIdDesc();
}
