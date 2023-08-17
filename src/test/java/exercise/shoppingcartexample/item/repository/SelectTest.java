package exercise.shoppingcartexample.item.repository;

import exercise.shoppingcartexample.entity.Item;
import exercise.shoppingcartexample.enumtype.DeliveryType;
import exercise.shoppingcartexample.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SelectTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("findAll 페이징 쿼리 테스트")
    void pageQueryTest() {
        // given
        Item item1 = Item.builder().itemName("item1")
                .itemQuantity(10)
                .itemPrice(1000)
                .deliveryType(DeliveryType.MorningDelivery).build();
        Item item2 = Item.builder().itemName("item2")
                .itemQuantity(10)
                .itemPrice(1000)
                .deliveryType(DeliveryType.MorningDelivery).build();
        Item item3 = Item.builder().itemName("item3")
                .itemQuantity(10)
                .itemPrice(1000)
                .deliveryType(DeliveryType.MorningDelivery).build();
        Item item4 = Item.builder().itemName("item1")
                .itemQuantity(10)
                .itemPrice(1000)
                .deliveryType(DeliveryType.MorningDelivery).build();
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);
        // when
        Pageable pageable1 = PageRequest.of(0, 3);
        Pageable pageable2 = PageRequest.of(1, 3);
        Page<Item> all1 = itemRepository.findAll(pageable1);
        Page<Item> all2 = itemRepository.findAll(pageable2);
        // then
        assertEquals(2, all1.getTotalPages());
        assertEquals(4, all1.getTotalElements());
    }
}
