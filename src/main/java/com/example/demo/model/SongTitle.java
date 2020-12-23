package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class SongTitle {

    private final UUID id;
    private final String first_half;
    private final String second_half;

    public SongTitle(@JsonProperty("id") UUID id,
                     @JsonProperty("first_half") String first_half,
                     @JsonProperty("second_half") String second_half) {
        this.id = id;
        this.first_half = first_half;
        this.second_half = second_half;
    }

    public UUID getId() {
        return this.id;
    }

    public String getFirst_half() {
        return this.first_half;
    }

    public String getSecond_half() {
        return this.second_half;
    }
}
