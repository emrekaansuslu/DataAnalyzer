package com.midas.dataAnalyzer.service;

import com.midas.dataAnalyzer.model.DataNew;
import com.midas.dataAnalyzer.repository.DataNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataNewService {

    @Autowired
    DataNewRepository dataNewRepository;

    public DataNew findDataNewByExcelIndex(String excelIndex) {
        return dataNewRepository.findDataNewByExcelIndex(excelIndex);
    }
}
