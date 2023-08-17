package exercise.shoppingcartexample.item.controller;

import exercise.shoppingcartexample.entity.Item;
import exercise.shoppingcartexample.enumtype.DeliveryType;
import exercise.shoppingcartexample.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class SelectTestPageQuery {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ItemRepository itemRepository;
    @Test
    @DisplayName("페이징 쿼리 조회 성공")
    void test() throws Exception {
        // given
        Item item1 = Item.builder().itemName("name1")
                .itemPrice(1000)
                .itemQuantity(10)
                .deliveryType(DeliveryType.MorningDelivery)
                .build();
        Item item2 = Item.builder().itemName("name2")
                .itemPrice(1000)
                .itemQuantity(10)
                .deliveryType(DeliveryType.MorningDelivery)
                .build();
        Item item3 = Item.builder().itemName("name3")
                .itemPrice(1000)
                .itemQuantity(10)
                .deliveryType(DeliveryType.MorningDelivery)
                .build();
        Item item4 = Item.builder().itemName("name4")
                .itemPrice(1000)
                .itemQuantity(10)
                .deliveryType(DeliveryType.MorningDelivery)
                .build();
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);
        // when
        MvcResult result = mockMvc.perform(get("/items")
                        .contentType("application/json")
                        .queryParam("size", "3")
                        .queryParam("page", "0")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // then
        MockHttpServletResponse response = result.getResponse();
        log.info("[result] : {} ", response.getContentAsString());
    }
    @Test
    @DisplayName("페이징 쿼리 실패 : 데이터가 없는 경우")
    void test2() throws Exception {
        // given
        // when
        MvcResult result = mockMvc.perform(get("/items")
                        .contentType("application/json")
                        .queryParam("size", "3")
                        .queryParam("page", "0")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // then
        MockHttpServletResponse response = result.getResponse();
        log.info("[result] : {} ", response.getContentAsString());
    }
}
