package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Item;
import pl.coderslab.model.User;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {


    List<Item> findAllByUser_Id(Long id);

//    @Query("select i from Item i where i.user.id = :id ")
//    List<Item> findAllByUser_Id(@Param("id") Long id);



}
