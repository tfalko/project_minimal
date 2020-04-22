package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Item;
import pl.coderslab.model.User;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {


    List<Item> findAllByUser_Id(Long id);

}
