package com.example.demo.dao;

import com.example.demo.model.SongTitle;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface SongTitleDao {

    int insertSongTitle(UUID id, SongTitle songTitle);

    default int insertSongTitle(SongTitle songTitle) {
        UUID id = UUID.randomUUID();
        return insertSongTitle(id, songTitle);
    }

    List<SongTitle> selectAllSongTitles();

    Optional<SongTitle> selectSongTitleById(UUID id);

    int deleteSongTitleById(UUID id);

    int updateSongTitleById(UUID id, SongTitle songTitle);
}
