package exercise.shoppingcartexample.entity;

import exercise.shoppingcartexample.enumtype.DeliveryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    public static class Builder {
        private String itemName;
        private int itemPrice;
        private int itemQuantity;
        private DeliveryType deliveryType;

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

        public Builder deliveryType(DeliveryType deliveryType) {
            this.deliveryType = deliveryType;
            return this;
        }
        public Item build() {
            return new Item(this);
        }
    }
    public static Builder builder() {
        return new Builder();
    }
    private Item(Builder builder) {
        this.itemName = builder.itemName;
        this.itemPrice = builder.itemPrice;
        this.itemQuantity = builder.itemQuantity;
        this.deliveryType = builder.deliveryType;
    }
}
