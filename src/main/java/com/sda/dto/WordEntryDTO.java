package com.sda.dto;
import java.time.LocalDateTime;

public class WordEntryDTO {

    private Long id;
    private String word;
    private UserDTO from;
    private LocalDateTime localDateTime;

    public WordEntryDTO(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public UserDTO getFrom() {
        return from;
    }

    public void setFrom(UserDTO from) {
        this.from = from;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime (LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

}
