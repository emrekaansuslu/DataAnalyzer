package com.midas.dataAnalyzer.task;

import com.midas.dataAnalyzer.model.CrawlerStatus;
import com.midas.dataAnalyzer.model.DataNew;
import com.midas.dataAnalyzer.model.Info;
import com.midas.dataAnalyzer.service.CrawlerStatusService;
import com.midas.dataAnalyzer.service.DataNewService;
import com.midas.dataAnalyzer.service.InfoService;
import com.midas.dataAnalyzer.service.SettingsService;
import com.midas.dataAnalyzer.util.FileOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

@Component
public class CreateInfoTask extends TimerTask {


    @Autowired
    SettingsService settingsService;

    @Autowired
    CrawlerStatusService crawlerStatusService;

    @Autowired
    FileOperations fileOperations;

    @Autowired
    InfoService infoService;

    @Autowired
    DataNewService dataNewService;

    @Override
    public void run() {

        Integer currentIndex = settingsService.getCurrentSettings().getStatusIndexNew();
        if(currentIndex != null && currentIndex.intValue() < 46703) {
            settingsService.updateExcelIndexNew(currentIndex.intValue() + 1);
            CrawlerStatus crawlerStatus = crawlerStatusService.findCrawlerStatusByExcelIndex(currentIndex);
            if( crawlerStatus != null) {
                DataNew dataNew = dataNewService.findDataNewByExcelIndex(crawlerStatus.getExcelIndex());
                Info info = new Info();
                info.setExcelNumber(0); // 0 for 2014-2020 , 1 for 2009-2014
                info.setExcelIndex(crawlerStatus.getExcelIndex());
                info.setPatientID(crawlerStatus.getPatientID());
                info.setDate(fileOperations.convertDate(crawlerStatus.getDate()));
                info.setStatus(crawlerStatus.getStatus().equalsIgnoreCase("Success"));
                info.setBiradsScore(crawlerStatus.getBirads());
                info.setImageCount(fileOperations.getImageCountFromFile(crawlerStatus.getPatientID(), crawlerStatus.getDate()));
                info.setBilateralScore(dataNew.getBilateralScore());
                info.setLeftIntensity(dataNew.getLeftDense());
                info.setRightIntensity(dataNew.getRightDense());
                info.setMicroCalcScore(dataNew.getMicrocalScore());
                info.setMacroCalcScore(dataNew.getMacrocalScore());
                infoService.insertInfo(info);

            }
        }


    }
}
