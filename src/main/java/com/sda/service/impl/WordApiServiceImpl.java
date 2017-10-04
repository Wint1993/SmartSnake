package com.sda.service.impl;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sda.service.WordApiService;
import org.springframework.stereotype.Service;

@Service
public class WordApiServiceImpl implements WordApiService{

    @Override
    public void checkIfExist(String text) {

       try {
           int i = Unirest.get("https://wordsapiv1.p.mashape.com/words/"+text)
                   .header("X-Mashape-Key", "ZbaE6jc9DOmshCoOHXdBiIm3gLwop1GjndnjsnzkpxOt4By2ly")
                   .header("Accept", "application/json")
                   .asJson().getStatus();
       } catch (UnirestException e) {
           throw new RuntimeException("\n" +
                   "" +
                   "The word does not exist");
       }
    }




}
