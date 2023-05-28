package ro.pao.repository;

import ro.pao.model.Promotii;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PromotiiRepository {

    Optional<Promotii> getPromotiiBynumePromotie(Promotii numePromotie);

    Optional<List<Promotii>> getObjectBycodPromotional(Promotii codPromotional);

    void deletePromotiiBynumePromotie(Promotii numePromotie);

    void updatePromotiiBynumePromotie(Promotii numePromotie, Promotii newPromotii);

    void addNewPromotii(Promotii Promotii);

    Optional<Promotii> getPromotiiBynumePromotie();

    List<Promotii> getAll();

    void addAllFromGivenList(List<Promotii> PromotiiList);
}