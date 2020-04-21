package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    //Item findByUserId(Long id);


}
