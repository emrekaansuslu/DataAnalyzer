package com.midas.dataAnalyzer.repository;

import com.midas.dataAnalyzer.model.DataNew;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataNewRepository extends MongoRepository<DataNew,String> {

    DataNew findDataNewByExcelIndex(String excelIndex);
}
