package com.example.demo.dao;
import com.example.demo.dao.SongTitleDao;
import com.example.demo.model.SongTitle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

@Repository("mysql")
public class SongTitleDataAccess implements SongTitleDao {

    private static List<SongTitle> DB = new ArrayList<>();

    @Override
    public int insertSongTitle(UUID id, SongTitle songTitle) {
        DB.add(new SongTitle(id, songTitle.getFirst_half(), songTitle.getSecond_half()));
        return 0;
    }
}
