package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Item;
import pl.coderslab.model.User;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {


    List<Item> findAllByUser_IdAndArchivedIsFalse(Long id);
    List<Item> findAllByUser_IdAndArchivedIsTrue(Long id);
    Long countItemsByUser_id(Long id);

    List<Item> findAllByUser_IdAndArchivedIsFalseOrderByNameAsc(Long id);
    List<Item> findAllByUser_IdAndArchivedIsFalseOrderByCategoryNameAsc(Long id);
    List<Item> findAllByUser_IdAndArchivedIsFalseOrderByImportanceAsc(Long id);


    Item findFirstByIdAndArchivedIsFalse(Long id);
    Item findFirstByIdAndArchivedIsTrue(Long id);

    @Query("select count(i) from Item i where i.user.id =:id")
    int countItems(Long id);

    @Query("SELECT sum (i.importance) from Item i where i.user.id =:id")
    int importanceSum(Long id);

    @Query("select avg (i.importance) from Item i where i.user.id =:id")
    int avgImportance(Long id);

//    @Query("select i from Item limit)
//    Item firstFiveByDate();





}
