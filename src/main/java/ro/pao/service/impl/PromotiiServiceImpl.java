package ro.pao.service.impl;

import ro.pao.service.PromotiiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PromotiiServiceImpl implements PromotiiService {
    private static List<Promotii> promotiiList = new ArrayList<>();

    public List<Promotii> showAllPromotii() {
        return promotiiList;
    }

    @Override
    public Optional<Promotii> getPromotiibyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Promotii> getAllFromList() {
        return promotiiList;
    }

    @Override
    public void addAllFromGivenList(List<Promotii> promotiiList) {
        promotiiList.addAll(promotiiList);
    }

    @Override
    public void addOnlyOne(Promotii promotii) {
        promotiiList.add(null);
    }
}
