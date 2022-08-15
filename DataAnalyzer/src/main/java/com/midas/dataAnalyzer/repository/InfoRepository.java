package com.midas.dataAnalyzer.repository;

import com.midas.dataAnalyzer.model.Info;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends MongoRepository<Info,String> {


    Info findByExcelIndexAndPatientIDAndDate(String excelIndex,String patientID, String date);

}
