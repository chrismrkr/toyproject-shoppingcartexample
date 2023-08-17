package exercise.shoppingcartexample.repository;

import exercise.shoppingcartexample.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
