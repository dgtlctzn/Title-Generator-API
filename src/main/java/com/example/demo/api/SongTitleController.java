package com.example.demo.api;

import com.example.demo.model.SongTitle;
import com.example.demo.service.SongTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping(path = "{id}")
    public SongTitle getSongTitleById(@PathVariable("id") UUID id) {
        return songTitleService.getSongTitleById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSongTitleById(@PathVariable("id") UUID id) {
        songTitleService.deleteSongTitle(id);
    }

    @PutMapping(path = "{id}")
    public void updateSongTitle(@PathVariable("id") UUID id, @RequestBody SongTitle songTitleToUpdate) {
        songTitleService.updateSongTitle(id, songTitleToUpdate);
    }
 }
