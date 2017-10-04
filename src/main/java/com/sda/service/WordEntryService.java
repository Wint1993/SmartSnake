package com.sda.service;

import com.sda.dto.WordEntryDTO;
import org.springframework.stereotype.Service;

@Service
public interface WordEntryService {

    WordEntryDTO create(String word);

    String findAll();

    WordEntryDTO findLastWord();

    boolean compareTwoWords(WordEntryDTO was, String word);
}
