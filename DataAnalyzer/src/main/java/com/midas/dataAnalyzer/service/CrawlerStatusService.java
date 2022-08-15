package com.midas.dataAnalyzer.service;


import com.midas.dataAnalyzer.model.CrawlerStatus;
import com.midas.dataAnalyzer.repository.CrawlerStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlerStatusService {

    @Autowired
    private CrawlerStatusRepository crawlerStatusRepository;

    public List<CrawlerStatus> findAllCrawlerStatus() {
        return crawlerStatusRepository.findAll();
    }
    public CrawlerStatus findCrawlerStatusByExcelIndex(int excelIndex) {
        return crawlerStatusRepository.findCrawlerStatusByExcelIndex(String.valueOf(excelIndex));
    }

}
