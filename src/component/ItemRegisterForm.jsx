import React, {useState} from 'react';
import styles from '../css/ItemRegisterForm.module.css';

const ItemRegisterForm = (props) => {
    const [deliveryType, setDeliveryType] = useState();
    const [itemName, setItemName] = useState();
    const [itemPrice, setItemPrice] = useState();
    const [itemQuantity, setItemQuantity] = useState();

    const changeDeliveryType = (e) => {
        setDeliveryType(e.target.value);
    };
    const changeItemName = (e) => {
        setItemName(e.target.value);
    };
    const changeItemPrice = (e) => {
        setItemPrice(e.target.value);
    };
    const changeItemQuantity = (e) => {
        setItemQuantity(e.target.value);
    };
    const postItem = (e) => {
        e.preventDefault();
        e.stopPropagation();
        alert(deliveryType + " " + itemName + " " + itemPrice +" " + itemQuantity);
    }
    

    return (
        <div>
            <div class={styles.div_box}>
                <div class={styles.div_text}>
                    분류    
                </div>
                <select value={deliveryType} onChange={(e)=>{changeDeliveryType(e)}}>
                    <option>-------선택-------</option>
                    <option value="QuickDelivery">Quick Delivery</option>
                    <option value="MorningDelivery">Morning Delivery</option>
                    <option value="StandardDelivery">StandardDelivery</option>
                </select>

                <div class={styles.div_error}>
                </div>
            </div>
            <div class={styles.div_box}>
                <div class={styles.div_text}>
                    상품명
                </div>
                <input type="text" value={itemName} onChange={(e)=>{changeItemName(e)}}></input>
                <div class={styles.div_error}>

                </div>
            </div>
            <div class={styles.div_box}>
                <div class={styles.div_text}>
                    가격
                </div>
                <input type="text" value={itemPrice} onChange={(e)=>{changeItemPrice(e)}}></input>
                <div class={styles.div_error}>

                </div>
            </div>
            <div class={styles.div_box}>
                <div class={styles.div_text}>
                    수량
                </div>
                <input type="text" value={itemQuantity} onChange={(e)=>{changeItemQuantity(e)}}></input>
                <div class={styles.div_error}>
                    
                </div>
            </div>
            <div class={styles.div_button}>
                <button onClick={(e)=>{postItem(e)}}>등록</button>
            </div>
        </div>
    )
};

export default ItemRegisterForm;