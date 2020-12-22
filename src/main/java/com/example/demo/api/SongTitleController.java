package com.example.demo.api;

import com.example.demo.model.SongTitle;
import com.example.demo.service.SongTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
