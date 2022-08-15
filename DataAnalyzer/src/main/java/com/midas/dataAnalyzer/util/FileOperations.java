package com.midas.dataAnalyzer.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Component
public class FileOperations {

    private final String mainDataPath = "/data/HACETTEPE_2014_2020/";

    public int getImageCountFromFile(String patientID, String date) {
        String patientFolderPath = mainDataPath+patientID;
        File patientFolder = new File(patientFolderPath);
        if( patientFolder.exists()) {
           return (int) Arrays.stream(patientFolder.listFiles()).filter(file -> file.getName().contains(patientID+"_"+date)).count();
        } else {
            return 0;
        }
    }

    public  String convertDate(String date) {
        try {
            Date patientDate = new SimpleDateFormat("yyyyMMdd").parse(date);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return  sdf.format(patientDate);
        } catch (Exception e) {
            System.out.println("Error while converting date");
            return  date;
        }
    }
}
