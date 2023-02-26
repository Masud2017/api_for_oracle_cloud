package com.apiproject.openapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class AudioItem {
    private Double id;
    private String artistName;
    private String trackTitle;
    private String albumTitle;
    private Integer trackNumber;
    private Integer year;
    private Integer numberOfReiview;
    private Integer numberOfCopiesSold;
}
