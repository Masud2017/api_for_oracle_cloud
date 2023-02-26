package com.apiproject.openapi.dao;

import com.apiproject.openapi.InMemoryDataBase;
import com.apiproject.openapi.models.AudioItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AudioItemRepository {
    @Autowired
    private InMemoryDataBase inMemoryDataBase;

    public AudioItem findById(Double id) {
        for (AudioItem audioItem : inMemoryDataBase.getAudioItemList()) {
            if (audioItem.getId().equals(id)) {
                return audioItem;
            }
        }
        return null;
    }

    public AudioItem findByAudioItemByTrackNumber(Integer trackNumber) {
        for (AudioItem audioItem : inMemoryDataBase.getAudioItemList()) {
            if (audioItem.getTrackNumber().equals(trackNumber)) {
                return audioItem;
            }
        }
        return null;
    }

    public List<AudioItem> getAudioItemList() {
        return this.inMemoryDataBase.getAudioItemList();
    }

    public boolean addNewAudioItemToList(AudioItem audioItem) {
        try {
            this.inMemoryDataBase.addAudioItem(audioItem);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer getTotalCopiesSold() {
        return this.inMemoryDataBase.getTotalCopiesSold();
    }

    public AudioItem getAudioItemByArtistsName(String name) {
        for (AudioItem item : this.inMemoryDataBase.getAudioItemList()) {
            if (item.getArtistName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
