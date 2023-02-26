package com.apiproject.openapi;

import com.apiproject.openapi.models.AudioItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h1>InMemoryDataBase</h1>
 * A singleton class that persist data inside it no matter how many time its instance is created.
 * It will give the same data across to the whole application context
 * */
@Getter
public class InMemoryDataBase {
    private Integer totalCopiesSold = 0;
    private List<AudioItem> audioItemList = new ArrayList<>();
    private ReentrantLock lock = new ReentrantLock();
    private static InMemoryDataBase instance = null;

    private InMemoryDataBase() {}
    public static InMemoryDataBase getInstance() {
        if (instance == null) {
            instance = new InMemoryDataBase();
            return instance;
        }

        return instance;
    }

    public void addAudioItem(AudioItem audioItem) {
        this.lock.lock();
        this.audioItemList.add(audioItem);
        this.totalCopiesSold += audioItem.getNumberOfCopiesSold();
        this.lock.unlock();
    }
}
