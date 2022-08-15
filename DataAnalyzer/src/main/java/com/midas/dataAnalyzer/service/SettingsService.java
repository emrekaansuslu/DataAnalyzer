package com.midas.dataAnalyzer.service;

import com.midas.dataAnalyzer.model.Settings;
import com.midas.dataAnalyzer.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SettingsService {

    @Autowired
    SettingsRepository settingsRepository;

    public Settings updateExcelIndexNew(int index) {
        ArrayList<Settings> settings = (ArrayList<Settings>) settingsRepository.findAll();
        if( settings.size() != 1) {
            return null;
        } else {
            Settings temp = settings.get(0);
            temp.setStatusIndexNew(index);
            settingsRepository.save(temp);
        }
        return  null;
    }

    public Settings getCurrentSettings() {
        ArrayList<Settings> settings = (ArrayList<Settings>) settingsRepository.findAll();
        if( settings.size() != 1) {
            return null;
        } else {
            Settings temp = settings.get(0);
            return temp;
        }
    }

}
