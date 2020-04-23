package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Item;
import pl.coderslab.model.User;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {


    List<Item> findAllByUser_IdAndArchivedIsFalse(Long id);
    Item findFirstByIdAndArchivedIsFalse(Long id);

//    int countItems();

    @Query("SELECT sum (i.importance) from Item i")
    int importanceSum();





}
