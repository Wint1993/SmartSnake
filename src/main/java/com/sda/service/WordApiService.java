package com.sda.service;

import org.springframework.stereotype.Service;

@Service
public interface WordApiService {

    void checkIfExist(String text);
}
