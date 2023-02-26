package com.apiproject.openapi.services;

import com.apiproject.openapi.InMemoryDataBase;
import com.apiproject.openapi.dao.AudioItemRepository;
import com.apiproject.openapi.models.AudioItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AudioResourceServiceImpl implements AudioResourceService {
    @Autowired
    private AudioItemRepository audioItemRepository;

    @Override
    public List<AudioItem> getAudioItemList() {
        return this.audioItemRepository.getAudioItemList();
    }

    @Override
    public AudioItem getAudioItemById(Double id) {
        return this.audioItemRepository.findById(id);
    }

    @Override
    public Map<String, Integer> addNewAudioItemToDB(AudioItem audioItem) {
        Map<String,Integer> statusCode = new HashMap<>();
        if (this.audioItemRepository.addNewAudioItemToList(audioItem)) {
            statusCode.put("status",200);
        } else {
            statusCode.put("status",500);
        }

        return statusCode;
    }

    @Override
    public Integer getTotalCopiesSold() {
        return this.audioItemRepository.getTotalCopiesSold();
    }

    @Override
    public AudioItem getAudioItemByArtistsName(String name) {
        return this.audioItemRepository.getAudioItemByArtistsName(name);
    }

}
