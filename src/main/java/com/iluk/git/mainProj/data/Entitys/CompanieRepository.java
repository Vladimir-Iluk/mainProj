package com.iluk.git.mainProj.data.Entitys;

import org.springframework.data.repository.CrudRepository;

public interface CompanieRepository extends CrudRepository<Companie, Long> {
    Iterable<Companie> findAllByOrderByCompanyIdAsc();
    Iterable<Companie> findAllByOrderByCompanyIdDesc();
}
