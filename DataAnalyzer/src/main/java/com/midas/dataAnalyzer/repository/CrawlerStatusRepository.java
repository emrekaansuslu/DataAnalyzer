package com.midas.dataAnalyzer.repository;


import com.midas.dataAnalyzer.model.CrawlerStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrawlerStatusRepository extends MongoRepository<CrawlerStatus,String> {

    CrawlerStatus findCrawlerStatusByExcelIndex(String excelIndex);

    @Override
    <S extends CrawlerStatus> S save(S s);
}
