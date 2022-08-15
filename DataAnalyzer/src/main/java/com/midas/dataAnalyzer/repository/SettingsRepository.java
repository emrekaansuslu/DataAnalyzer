package com.midas.dataAnalyzer.repository;

import com.midas.dataAnalyzer.model.Settings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends MongoRepository<Settings,String> {
}
