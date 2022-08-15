package com.midas.dataAnalyzer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "status_new")
@Data
@AllArgsConstructor
@Getter
@Setter
public class CrawlerStatus {

    @Id
    private String id;


    private String patientID;
    private String expectedImageCount;
    private String crawledImageCount;
    private String status;
    private String errorReason;
    private String isAnonymized;
    private String isAnonymizeTry;

    @Field("excel_index")
    private String excelIndex;

    private String date;
    private String birads;
    private String savingPath;

}
