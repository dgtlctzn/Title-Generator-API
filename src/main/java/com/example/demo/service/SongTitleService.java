package com.example.demo.service;

import com.example.demo.dao.SongTitleDao;
import com.example.demo.model.SongTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SongTitleService {

    private final SongTitleDao songTitleDao;

    @Autowired
    public SongTitleService(@Qualifier("mysql") SongTitleDao songTitleDao) {
        this.songTitleDao = songTitleDao;
    }

    public int addSongTitle(SongTitle songTitle) {
        return songTitleDao.insertSongTitle(songTitle);
    }
}
