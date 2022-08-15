package com.midas.dataAnalyzer.controller;


import com.midas.dataAnalyzer.model.Filter;
import com.midas.dataAnalyzer.model.FilterList;
import com.midas.dataAnalyzer.model.Info;
import com.midas.dataAnalyzer.model.ResponseObject;
import com.midas.dataAnalyzer.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("info/")
public class InfoController {

    @Autowired
    private InfoService infoService;


    @CrossOrigin
    @GetMapping(value = "getAll")
    public ResponseEntity<List<Info>> getInfoList() {

        try {
            return new ResponseEntity<>(infoService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(value = "biradsScore")
    public ResponseEntity<List<ResponseObject>> getBiradsScore() {
        try {
            HashMap<String,Integer> biradsCount = new HashMap<>();
            ArrayList<Info> infos = (ArrayList<Info>) infoService.findAll();
            for (Info info:infos) {
                if(biradsCount.containsKey(info.getBiradsScore())) {
                    int tableValue = biradsCount.get(info.getBiradsScore());
                    biradsCount.replace(info.getBiradsScore(), tableValue+info.getImageCount());
                } else {
                    biradsCount.put(info.getBiradsScore(),info.getImageCount());
                }
            }

            ArrayList<ResponseObject> responseList = new ArrayList<>();
            for(String key : biradsCount.keySet()) {
                ResponseObject ro = new ResponseObject(key,biradsCount.get(key));
                responseList.add(ro);
            }


            return new ResponseEntity<>(responseList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @CrossOrigin
    @PostMapping(value="/filteredInfoList",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResponseObject>> sendFilteredInfoList(@RequestBody FilterList filterList) {
        try {
            HashMap<String,Integer> filterCount = new HashMap<>();
            ArrayList<Info> infos;
            if(filterList.getList().size() > 0) {
                infos = (ArrayList<Info>) infoService.findAllWithQuery(filterList);
            } else {
                infos = (ArrayList<Info>) infoService.findAll();
            }
            for (Info info:infos) {
                if(filterCount.containsKey(info.getQueryAxis(filterList.getAxis()))) {
                    int tableValue = filterCount.get(info.getQueryAxis(filterList.getAxis()));
                    filterCount.replace(info.getQueryAxis(filterList.getAxis()), tableValue+info.getImageCount());
                } else {
                    filterCount.put(info.getQueryAxis(filterList.getAxis()),info.getImageCount());
                }
            }

            ArrayList<ResponseObject> responseList = new ArrayList<>();
            for(String key : filterCount.keySet()) {
                ResponseObject ro = new ResponseObject(key,filterCount.get(key));
                responseList.add(ro);
            }


            return new ResponseEntity<>(responseList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
