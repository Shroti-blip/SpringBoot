package com.database2.database2.Assignment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface markSheetRepository extends CrudRepository<Marksheet,Integer> {
}
