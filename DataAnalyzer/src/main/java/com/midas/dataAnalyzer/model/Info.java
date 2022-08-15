package com.midas.dataAnalyzer.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Info {

    @Id
    private String id;

    @Field("excel_number")
    private Integer excelNumber;
    @Field("excel_index")
    private String excelIndex;
    @Field("patientID")
    private String patientID;
    @Field("date")
    private String date;
    @Field("status")
    private Boolean status;
    @Field("imageCount")
    private Integer imageCount;
    @Field("biradsScore")
    private String biradsScore;
    @Field("bilateralScore")
    private String bilateralScore;
    @Field("leftIntensity")
    private String leftIntensity;
    @Field("rightIntensity")
    private String rightIntensity;
    @Field("microCalcScore")
    private String microCalcScore;
    @Field("macroCalScore")
    private String macroCalcScore;


    public String getQueryAxis(String axisName) {
        switch (axisName) {
            case "patientID":
                return  getPatientID();
            case "date":
                return getDate();
            case "status":
                return getStatus().toString();
            case "imageCount":
                return getImageCount().toString();
            case "biradsScore":
                return getBiradsScore();
            case "bilateralScore":
                return getBilateralScore();
            case "leftIntensity":
                return getLeftIntensity();
            case "rightIntensity":
                return getRightIntensity();
            case "microCalcScore":
                return getMicroCalcScore();
            case "macroCalScore":
                return getMacroCalcScore();
            default:
                return "";
        }
    }


}
