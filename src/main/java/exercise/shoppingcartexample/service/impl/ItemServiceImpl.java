package exercise.shoppingcartexample.service.impl;

import exercise.shoppingcartexample.dto.request.ItemRequestDto;
import exercise.shoppingcartexample.entity.Item;
import exercise.shoppingcartexample.enumtype.DeliveryType;
import exercise.shoppingcartexample.repository.ItemRepository;
import exercise.shoppingcartexample.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public Item addItem(ItemRequestDto requestDto) {
        Item newItem = Item.builder()
                .itemName(requestDto.getItemName())
                .itemPrice(requestDto.getItemPrice())
                .itemQuantity(requestDto.getItemQuantity())
                .deliveryType(DeliveryType.valueOf(requestDto.getDeliveryType()))
                .build();
        Item save = itemRepository.save(newItem);
        return save;
    }
    @Override
    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        return items;
    }
    @Override
    public Page<Item> findAll(Pageable pageable) {
        Page<Item> items = itemRepository.findAll(pageable);
        return items;
    }

    @PostConstruct
    void saveInitItem() {
        for(int i=1; i<25; i++) {
            ItemRequestDto quickDelivery = ItemRequestDto.builder().itemName("item" + i)
                    .itemPrice(1000 + i * 20)
                    .itemQuantity(i + 5)
                    .deliveryType("QuickDelivery")
                    .build();
            Item build = Item.builder()
                    .itemName(quickDelivery.getItemName())
                    .itemPrice(quickDelivery.getItemPrice())
                    .itemQuantity(quickDelivery.getItemQuantity())
                    .deliveryType(DeliveryType.valueOf(quickDelivery.getDeliveryType()))
                    .build();
            itemRepository.save(build);
        }
    }
}
