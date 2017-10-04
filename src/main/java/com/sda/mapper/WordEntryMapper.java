package com.sda.mapper;

import com.sda.dto.WordEntryDTO;
import com.sda.model.WordEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WordEntryMapper {


    @Mapping(source = "userFrom", target = "from")
    WordEntryDTO toWordEntryDTO(WordEntry wordEntry);

    @Mapping(source = "from", target = "userFrom")
    WordEntry toWordEntry(WordEntryDTO wordEntryDTO);

    List<WordEntryDTO> toWordEntryDTOList(List<WordEntry> list);

    List<WordEntry> toWordEntryList(List<WordEntryDTO> list);
}
