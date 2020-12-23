package com.example.demo.api;

import com.example.demo.model.SongTitle;
import com.example.demo.service.SongTitleService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public void addSongTitle(@Validated @NonNull @RequestBody SongTitle songTitle) {
        songTitleService.addSongTitle(songTitle);
    }

    @GetMapping
    public List<SongTitle> getAllSongTitles(@RequestParam("id") Optional<UUID> id) {
        if (id.isPresent()) {
            List<SongTitle> foundList = new ArrayList<>();
            SongTitle foundId = songTitleService.getSongTitleById(id.get()).orElse(null);
            foundList.add(foundId);
            return foundList;
        }
        return songTitleService.getAllSongTitles();
    }

//    @GetMapping(path = "{id}")
//    public SongTitle getSongTitleById(@PathVariable("id") UUID id) {
//        return songTitleService.getSongTitleById(id).orElse(null);
//    }

    @DeleteMapping(path = "{id}")
    public void deleteSongTitleById(@PathVariable("id") UUID id) {
        songTitleService.deleteSongTitle(id);
    }

    @PutMapping(path = "{id}")
    public void updateSongTitle(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody SongTitle songTitleToUpdate) {
        songTitleService.updateSongTitle(id, songTitleToUpdate);
    }
 }
