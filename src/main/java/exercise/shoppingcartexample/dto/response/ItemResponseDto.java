package exercise.shoppingcartexample.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemResponseDto {

    private int code;
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String deliveryType;
    public static class Builder {
        private int code;
        private String itemName;
        private int itemPrice;
        private int itemQuantity;
        private String deliveryType;
        public Builder code(int code) {
            this.code = code;
            return this;
        }
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

        public ItemResponseDto build() {
            return new ItemResponseDto(this);
        }
    }
    private ItemResponseDto(Builder builder) {
        this.code = builder.code;
        this.itemName = builder.itemName;
        this.itemPrice = builder.itemPrice;
        this.itemQuantity = builder.itemQuantity;
        this.deliveryType = builder.deliveryType;
    }
    public static Builder builder() {
        return new Builder();
    }
}
