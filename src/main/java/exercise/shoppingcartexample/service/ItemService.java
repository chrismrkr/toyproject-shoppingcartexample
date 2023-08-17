package exercise.shoppingcartexample.service;

import exercise.shoppingcartexample.dto.request.ItemRequestDto;
import exercise.shoppingcartexample.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    Item addItem(ItemRequestDto item);
    List<Item> findAll();
    Page<Item> findAll(Pageable pageable);
}
