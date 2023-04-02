package ro.pao.service;

import ro.pao.model.Tratament;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TratamentService {
    static List<Tratament> tratamentList = new ArrayList<>();
    // o lista unde stocam toate tratamentele

    List<Tratament> showAllTratament();

    Optional<Tratament> getTratamentbyId(UUID id);

    List<Tratament> getAllFromList();

    void addAllFromGivenList(List<Tratament> tratamentList);

    void addOnlyOne(Tratament tratament);
}
