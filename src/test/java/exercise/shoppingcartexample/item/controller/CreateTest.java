package exercise.shoppingcartexample.item.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class CreateTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("1. 생성 성공")
    void success() throws Exception {
        // given
        String body = "{ " +
                "\"itemName\": \"item1\", " +
                "\"itemPrice\": 10000, " +
                "\"itemQuantity\": 30, " +
                "\"deliveryType\": \"QuickDelivery\""+
                "}";
        // when
        MvcResult result = mockMvc.perform(post("/item")
                        .contentType("application/json")
                        .content(body)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // then
        MockHttpServletResponse response = result.getResponse();
        log.info("[result] : {} ", response.getContentAsString());
    }
    @Test
    @DisplayName("2. 생성 실패 : itemPrice 누락")
    void fail1() throws Exception {
        // given
        String body = "{ " +
                "\"itemName\": \"item1\", " +
                //"\"itemPrice\": 10000, " +
                "\"itemQuantity\": 30, " +
                "\"deliveryType\": \"QuickDelivery\""+
                "}";
        // when
        MvcResult result = mockMvc.perform(post("/item")
                        .contentType("application/json")
                        .content(body)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // then
        MockHttpServletResponse response = result.getResponse();
        log.info("[result] : {} ", response.getContentAsString());
    }
    @Test
    @DisplayName("3. 생성 실패 : itemName 누락")
    void fail2() throws Exception {
        // given
        String body = "{ " +
                //"\"itemName\": \"item1\", " +
                "\"itemPrice\": 10000, " +
                "\"itemQuantity\": 30, " +
                "\"deliveryType\": \"QuickDelivery\""+
                "}";
        // when
        MvcResult result = mockMvc.perform(post("/item")
                        .contentType("application/json")
                        .content(body)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // then
        MockHttpServletResponse response = result.getResponse();
        log.info("[result] : {} ", response.getContentAsString());
    }
    @Test
    @DisplayName("4. 생성 실패 : itemQuantity 누락")
    void fail3() throws Exception {
        // given
        String body = "{ " +
                "\"itemName\": \"item1\", " +
                "\"itemPrice\": 10000, " +
                //"\"itemQuantity\": 30, " +
                "\"deliveryType\": \"QuickDelivery\""+
                "}";
        // when
        MvcResult result = mockMvc.perform(post("/item")
                        .contentType("application/json")
                        .content(body)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // then
        MockHttpServletResponse response = result.getResponse();
        log.info("[result] : {} ", response.getContentAsString());
    }
    @Test
    @DisplayName("5. 생성 실패 : deliveryType 누락")
    void fail4() throws Exception {
        // given
        String body = "{ " +
                "\"itemName\": \"item1\", " +
                "\"itemPrice\": 10000, " +
                "\"itemQuantity\": 30 " +
                //"\"deliveryType\": \"QuickDelivery\""+
                "}";
        // when
        MvcResult result = mockMvc.perform(post("/item")
                        .contentType("application/json")
                        .content(body)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // then
        MockHttpServletResponse response = result.getResponse();
        log.info("[result] : {} ", response.getContentAsString());
    }
    @Test
    @DisplayName("6. 생성 실패 : itemName, itemPrice, itemQuantity 누락")
    void fail6() throws Exception {
        // given
        String body = "{ " +
                //"\"itemName\": \"item1\", " +
                //"\"itemPrice\": 10000, " +
                //"\"itemQuantity\": 30 " +
                "\"deliveryType\": \"QuickDelivery\""+
                "}";
        // when
        MvcResult result = mockMvc.perform(post("/item")
                        .contentType("application/json")
                        .content(body)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // then
        MockHttpServletResponse response = result.getResponse();
        log.info("[result] : {} ", response.getContentAsString());
    }
    @Test
    @DisplayName("7. 생성 실패 : itemName, itemPrice, deliveryType 누락")
    void fail7() throws Exception {
        // given
        String body = "{ " +
                //"\"itemName\": \"item1\", " +
                //"\"itemPrice\": 10000, " +
                "\"itemQuantity\": 30 " +
                //"\"deliveryType\": \"QuickDelivery\""+
                "}";
        // when
        MvcResult result = mockMvc.perform(post("/item")
                        .contentType("application/json")
                        .content(body)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // then
        MockHttpServletResponse response = result.getResponse();
        log.info("[result] : {} ", response.getContentAsString());
    }
}
