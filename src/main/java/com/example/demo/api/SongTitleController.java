package com.example.demo.api;

import com.example.demo.model.SongTitle;
import com.example.demo.service.SongTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/songtitle")
@RestController
public class SongTitleController {

    private final SongTitleService songTitleService;

    @Autowired
    public SongTitleController(SongTitleService songTitleService) {
        this.songTitleService = songTitleService;
    }

    @PostMapping
    public void addSongTitle(@RequestBody SongTitle songTitle) {
        songTitleService.addSongTitle(songTitle);
    }

    @GetMapping
    public List<SongTitle> getAllSongTitles() {
        return songTitleService.getAllSongTitles();
    }
}
