package com.iluk.git.mainProj.data.Entitys;

import org.springframework.data.repository.CrudRepository;

public interface AgreementRepository extends CrudRepository<Agreement, Long> {
    Iterable<Agreement> findAllByOrderByAgreementIdAsc();
    Iterable<Agreement> findAllByOrderByAgreementIdDesc();
}
