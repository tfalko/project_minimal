package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
