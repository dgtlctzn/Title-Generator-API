package com.example.demo.dao;
import com.example.demo.dao.SongTitleDao;
import com.example.demo.model.SongTitle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class SongTitleDataAccess implements SongTitleDao {

    private static List<SongTitle> DB = new ArrayList<>();

    @Override
    public int insertSongTitle(UUID id, SongTitle songTitle) {
        DB.add(new SongTitle(id, songTitle.getFirst_half(), songTitle.getSecond_half()));
        return 0;
    }

    @Override
    public List<SongTitle> selectAllSongTitles() {
        return DB;
    }

    @Override
    public Optional<SongTitle> selectSongTitleById(UUID id) {
        return DB.stream().filter(songTitle -> songTitle.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteSongTitleById(UUID id) {
        Optional<SongTitle> maybeSongTitle = selectSongTitleById(id);
        if (!maybeSongTitle.isPresent()) {
            return 0;
        }
        DB.remove(maybeSongTitle.get());
        return 1;
    }

    @Override
    public int updateSongTitleById(UUID id, SongTitle songTitle) {
        return selectSongTitleById(id).map(songTitle1 -> {
            int indexOfSongTitleToUpdate = DB.indexOf(songTitle1);
            System.out.println(indexOfSongTitleToUpdate);
            if (indexOfSongTitleToUpdate >= 0) {
                DB.set(indexOfSongTitleToUpdate, new SongTitle(id,
                        songTitle.getFirst_half(),
                        songTitle.getSecond_half()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
