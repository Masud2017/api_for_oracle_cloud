package com.apiproject.openapi.services;

import com.apiproject.openapi.dao.AudioItemRepository;
import com.apiproject.openapi.models.AudioItem;

import java.util.List;
import java.util.Map;

public interface AudioResourceService {
    public List<AudioItem> getAudioItemList();
    public AudioItem getAudioItemById(Double id);
    public Map<String,Integer> addNewAudioItemToDB (AudioItem audioItem);
    public Integer getTotalCopiesSold();
    public AudioItem getAudioItemByArtistsName(String name);
}
