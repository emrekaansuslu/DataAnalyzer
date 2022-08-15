package com.midas.dataAnalyzer.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "settings")
@Data
@AllArgsConstructor
@Getter
@Setter
public class Settings {


    @Id
    @Generated
    public String Id;
    @Field("statusIndexNew")
    public Integer statusIndexNew;
    @Field("statusIndexOld")
    public Integer statusIndexOld;
}
