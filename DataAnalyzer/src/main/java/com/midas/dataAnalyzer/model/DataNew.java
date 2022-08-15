package com.midas.dataAnalyzer.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "data_new")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataNew {

    @Id
    private String Id;

    @Field("excel_index")
    private String excelIndex;

    @Field("Hasta No")
    private String patientID;

    @Field("Hasta Adı")
    private String patientName;

    @Field("Başvuru No")
    private String accessionNumber;

    @Field("Yaşı(Hzm.Tarihinde)")
    private String patientAge;

    @Field("Son Statu")
    private String lastStatus;

    @Field("Uygulama Tarihi")
    private String appliedDate;

    @Field("Hizmet Kodu")
    private String serviceCode;

    @Field("Hizmet Adı")
    private String serviceName;

    @Field("Sonuç Text")
    private String resultText;

    @Field("Rapor Text")
    private String reportText;

    @Field("Tanı")
    private String diagnosis;

    @Field("BI RADS")
    private String biradsScore;

    @Field("BILATERAL")
    private String bilateralScore;

    @Field("Sol Yoğunluk")
    private String leftDense;

    @Field("Sağ Yoğunluk")
    private String rightDense;

    @Field("Mikrokalsifikasyon")
    private String microcalScore;

    @Field("Makrokalsifikasyon")
    private String macrocalScore;




}
