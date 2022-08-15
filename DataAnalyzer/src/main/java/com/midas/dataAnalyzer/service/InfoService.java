package com.midas.dataAnalyzer.service;

import com.midas.dataAnalyzer.model.Filter;
import com.midas.dataAnalyzer.model.FilterList;
import com.midas.dataAnalyzer.model.Info;
import com.midas.dataAnalyzer.repository.InfoRepository;
import com.midas.dataAnalyzer.util.MongoDBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    InfoRepository infoRepository;

    @Autowired
    MongoDBConfig mongoDBConfig;

    public Info insertInfo(Info info) {
        Info tempInfo = infoRepository.findByExcelIndexAndPatientIDAndDate(info.getExcelIndex(),info.getPatientID(),info.getDate());
        if(tempInfo != null) {
            tempInfo.setExcelIndex(info.getExcelIndex());
            tempInfo.setPatientID(info.getPatientID());
            tempInfo.setDate(info.getDate());
            tempInfo.setDate(info.getDate());
            tempInfo.setStatus(info.getStatus());
            tempInfo.setImageCount(info.getImageCount());
            tempInfo.setBiradsScore(info.getBiradsScore());
            return infoRepository.save(tempInfo);
        } else {
            return infoRepository.save(info);
        }
    }

    public Page<Info> findAllInfosWithPage(int page, int size) {
        Pageable paging = new PageRequest(page,size);
        Page<Info> pagedResult = infoRepository.findAll(paging);
        return  pagedResult;
    }

    public List<Info>  findAll() {
        return (List<Info>) infoRepository.findAll();
    }

    public List<Info> findAllWithQuery(FilterList filterList) {

        Query customQuery = new Query();
        for (Filter filter: filterList.getList()) {
            customQuery.addCriteria(Criteria.where(filter.getFieldName()).regex(filter.getQueryText()));
        }
        List<Info> infoList = mongoDBConfig.mongoTemplate().find(customQuery,Info.class);

        return infoList;
    }

}
