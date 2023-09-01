package ro.pao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PromotiiService {
    static List<Promotii> promotiiList = new ArrayList<>();
    // o lista unde stocam toate promotiile

    List<Promotii> showAllPromotii();

    Optional<Promotii> getPromotiibyId(UUID id);

    List<Promotii> getAllFromList();

    void addAllFromGivenList(List<Promotii> promotiiList);

    void addOnlyOne(Promotii promotii);
}
