package exercise.shoppingcartexample.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemRequestDto {
    @NotBlank(message = "상품명을 입력해주세요.")
    private String itemName;
    @NotNull(message = "상품 가격을 입력해주세요.")
    private Integer itemPrice;
    @NotNull(message = "상품 재고를 입력해주세요.")
    private Integer itemQuantity;
    @NotBlank(message = "배송 종류를 선택해주세요.")
    private String deliveryType;

    public static class Builder {
        private String itemName;
        private int itemPrice;
        private int itemQuantity;
        private String deliveryType;

        public Builder itemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder itemPrice(int itemPrice) {
            this.itemPrice = itemPrice;
            return this;
        }

        public Builder itemQuantity(int itemQuantity) {
            this.itemQuantity = itemQuantity;
            return this;
        }

        public Builder deliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
            return this;
        }
        public ItemRequestDto build() {
            return new ItemRequestDto(this);
        }
    }
    private ItemRequestDto(Builder builder) {
        this.itemName = builder.itemName;
        this.itemPrice = builder.itemPrice;
        this.itemQuantity = builder.itemQuantity;
        this.deliveryType = builder.deliveryType;
    }
    public static Builder builder() {
        return new Builder();
    }
}
