package com.sda.service.impl;

import com.sda.dto.WordEntryDTO;
import com.sda.mapper.WordEntryMapper;
import com.sda.model.User;
import com.sda.model.WordEntry;
import com.sda.repository.UserRepository;
import com.sda.repository.WordEntryRepository;
import com.sda.service.WordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordEntryServiceImpl implements WordEntryService {

    @Autowired
    private WordEntryRepository wordEntryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WordEntryMapper wordEntryMapper;

    @Autowired
    private WordApiServiceImpl wordApiService;

    @Override
    public WordEntryDTO create(String word) {

        validateY(word);
        wordApiService.checkIfExist(word);
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        User user1 = userRepository.findUserByUsername(username);

        WordEntryDTO wordEntryDTO = new WordEntryDTO();
        WordEntry wordEntry = wordEntryMapper.toWordEntry(wordEntryDTO);
        wordEntry.setLocalDateTime(LocalDateTime.now());
        wordEntry.setWord(word);
        wordEntry.setUserFrom(user1);

        if (findLastWord() != null) {
            if (compareTwoWords(findLastWord(), word)) {
                return wordEntryMapper.toWordEntryDTO(wordEntryRepository.save(wordEntry));
            } else {
                throw new RuntimeException("Words do not match");
            }
        } else {
            return wordEntryMapper.toWordEntryDTO(wordEntryRepository.save(wordEntry));
        }
    }

    private void validateY(String word) {
        String[] parts = word.split("");
        int size = parts.length;
        String a = parts[size - 1];
        if (a.equals("y") || a.equals("Y")) {
            throw new RuntimeException("The word ends with Y");
        }
    }

    @Override
    public String findAll(){

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        List<String> example = new ArrayList<String>();
        wordEntryRepository.findAllByUserFromUsername(username).stream().forEach(c->example.add(c.getWord()));
        String listString = example.stream().map(Object::toString).collect(Collectors.joining(", "));
        return listString;
    }

    @Override
    public WordEntryDTO findLastWord() {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return wordEntryMapper.toWordEntryDTO(wordEntryRepository.findFirstByUserFromUsernameOrderByLocalDateTimeDesc(username));
    }

    @Override
    public boolean compareTwoWords(WordEntryDTO lastWord, String currentWord) {

        String[] parts = lastWord.getWord().split("");
        String a = parts[parts.length - 1].toUpperCase();
        String[] parts1 = currentWord.split("");
        String b = parts1[0].toUpperCase();

        if (b.equals(a)) {
            return true;
        } else {
            return false;
        }
    }



}
