package com.sda.controller;

import com.sda.dto.WordEntryDTO;
import com.sda.service.WordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/words")
public class WordController {

    @Autowired
    private WordEntryService wordEntryService;

    @RequestMapping(value = "/create", method = POST)
    public WordEntryDTO create( @RequestParam(value ="word") @RequestBody String word){
        return wordEntryService.create(word);
    }

    @RequestMapping(value = "/all", method = GET)
    public String findAll(){
       return "Wpisane słowa: " + wordEntryService.findAll();
   }


}
