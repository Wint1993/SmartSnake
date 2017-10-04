package com.sda.repository;

import com.sda.dto.WordEntryDTO;
import com.sda.model.WordEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordEntryRepository extends JpaRepository<WordEntry, Long> {

        WordEntry findFirstByUserFromUsernameOrderByLocalDateTimeDesc(String username);
        List<WordEntry> findAllByUserFromUsername(String username);
}
