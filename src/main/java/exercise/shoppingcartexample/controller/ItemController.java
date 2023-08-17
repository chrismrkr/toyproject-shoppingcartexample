package exercise.shoppingcartexample.controller;

import exercise.shoppingcartexample.dto.request.ItemRequestDto;
import exercise.shoppingcartexample.dto.response.ItemResponseDto;
import exercise.shoppingcartexample.entity.Item;
import exercise.shoppingcartexample.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Stream;


@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @GetMapping("/items")
    public Page<ItemResponseDto> selectAllItems(@RequestParam(name = "page") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<ItemResponseDto> all = itemService.findAll(pageable).map(
                item -> {
                    return ItemResponseDto.builder()
                            .itemName(item.getItemName())
                            .itemPrice(item.getItemPrice())
                            .itemQuantity(item.getItemQuantity())
                            .deliveryType(item.getDeliveryType().toString())
                            .build();
                }
        );
        return all;
    }

    @PostMapping("/item")
    public ItemResponseDto createItem(@Valid @RequestBody ItemRequestDto itemRequestDto) {
        Item item = itemService.addItem(itemRequestDto);
        ItemResponseDto response = ItemResponseDto.builder()
                .code(HttpStatus.OK.value())
                .deliveryType(item.getDeliveryType().toString())
                .itemName(item.getItemName())
                .itemPrice(item.getItemPrice())
                .itemQuantity(item.getItemQuantity()).build();
        return response;
    }

}
