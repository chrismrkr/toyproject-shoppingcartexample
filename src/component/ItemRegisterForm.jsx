import React, {useState} from 'react';
import styles from '../css/ItemRegisterForm.module.css';

const ItemRegisterForm = (props) => {
    const [deliveryType, setDeliveryType] = useState();
    const [deliveryTypeError, setDeliveryTypeError] = useState(null);
    
    const [itemName, setItemName] = useState();
    const [itemNameError, setItemNameError] = useState(null);

    const [itemPrice, setItemPrice] = useState();
    const [itemPriceError, setItemPriceError] = useState(null);

    const [itemQuantity, setItemQuantity] = useState();
    const [itemQuantityError, setItemQuantityError] = useState(null);
    

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
    const postItem = async (e) => {
        e.preventDefault();
        e.stopPropagation();
        const requestBody = {
            'deliveryType': deliveryType,
            'itemName': itemName,
            'itemPrice': itemPrice,
            'itemQuantity': itemQuantity
        };
        let responseBody;
        const request = new Request("http://localhost:8080/item", {
            method: 'POST',
            headers : {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(requestBody)
        });
        try {
            const response = await fetch(request);
            responseBody = await response.json();
            debugger;
        } catch(error) {
            alert("서버와의 연결에 실패했습니다.");
        }

        if(responseBody.code != 400) {
            alert("상품 등록이 완료되었습니다.");
            setDeliveryType('');
            setItemName('');
            setItemPrice('');
            setItemQuantity('');
        } else {
            setDeliveryTypeError(responseBody.fieldErrors.deliveryType);
            setItemNameError(responseBody.fieldErrors.itemName);
            setItemPriceError(responseBody.fieldErrors.itemPrice);
            setItemQuantityError(responseBody.fieldErrors.itemQuantity);
        }
    };
    
    return (
        <div>
            <div class={styles.div_box}>
                <div class={styles.div_text}>
                    분류    
                </div>
                <select value={deliveryType} onChange={(e)=>{changeDeliveryType(e)}}>
                    <option value="">-------선택-------</option>
                    <option value="QuickDelivery">Quick Delivery</option>
                    <option value="MorningDelivery">Morning Delivery</option>
                    <option value="StandardDelivery">StandardDelivery</option>
                </select>
                <div class={styles.div_error}>
                    {deliveryTypeError}
                </div>
            </div>
            <div class={styles.div_box}>
                <div class={styles.div_text}>
                    상품명
                </div>
                <input type="text" value={itemName} onChange={(e)=>{changeItemName(e)}}></input>
                <div class={styles.div_error}>
                    {itemNameError}
                </div>
            </div>
            <div class={styles.div_box}>
                <div class={styles.div_text}>
                    가격
                </div>
                <input type="text" value={itemPrice} onChange={(e)=>{changeItemPrice(e)}}></input>
                <div class={styles.div_error}>
                    {itemPriceError}
                </div>
            </div>
            <div class={styles.div_box}>
                <div class={styles.div_text}>
                    수량
                </div>
                <input type="text" value={itemQuantity} onChange={(e)=>{changeItemQuantity(e)}}></input>
                <div class={styles.div_error}>
                    {itemQuantityError}
                </div>
            </div>
            <div class={styles.div_button}>
                <button onClick={(e)=>{postItem(e)}}>등록</button>
            </div>
        </div>
    )
};

export default ItemRegisterForm;