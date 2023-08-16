import React, {useState} from 'react';

import styles from '../css/ItemTable.module.css';

const ItemTable = (props) => {
  const [itemList, setItemList] = useState(props.data);
  const [selectedDeliveryType, setSelectedDeliveryType] = useState('');
  const [selectedItemName, setSelectedItemName] = useState('');
  const [selectedItemPrice, setSelectedItemPrice] = useState('');
  const [selectedItemQuantity, setSelectedItemQuantity] = useState('');
  const [orderCount, setOrderCount] = useState('');

  const pickItems = (item, e) => {
    e.preventDefault();
    setSelectedDeliveryType(item.deliveryType);
    setSelectedItemName(item.itemName);
    setSelectedItemPrice(item.itemPrice);
    setSelectedItemQuantity(item.itemQuantity);
  };
  const changeOrderCount = (e) => {
    setOrderCount(e.target.value);
  };
  const addToShoppingCart = (e) => {
    if(selectedItemName === '' || selectedItemName === undefined) {
      alert("주문할 상품을 선택해주세요.");
      return;
    }
    if(orderCount === '' || orderCount === undefined) {
      alert("주문 수량을 입력해주세요.");
      return;
    }
    if(orderCount <= selectedItemQuantity) {
      let shoppingCartItem = {};
      shoppingCartItem.deliveryType = selectedDeliveryType;
      shoppingCartItem.itemName = selectedItemName;
      shoppingCartItem.itemPrice = selectedItemPrice;
      shoppingCartItem.itemQuantity = selectedItemQuantity;
      shoppingCartItem.orderCount = orderCount;
      props.addItemInShoppingCart(shoppingCartItem);
      alert("장바구니 추가했습니다.")
      setSelectedDeliveryType('');
      setSelectedItemName('');
      setSelectedItemPrice('');
      setSelectedItemQuantity('');
    } else {
      alert("재고 수량보다 더 많이 주문할 수 없습니다.");
    }
    setOrderCount('');
  };

  
  return (
    <div>
      <div>
       <table>
         <thead>
           <tr>
             <th>분류</th>
             <th>상품명</th>
              <th>판매가</th>
              <th>재고</th>
            </tr>
          </thead>
          <tbody>
            {props.data.map((item, index) => (
              <tr key={index}>
                <td>{item.deliveryType}</td>
                <td>{item.itemName}</td>
                <td>{item.itemPrice}</td>
                <td>{item.itemQuantity}</td>
                <td>
                  <button onClick={(e)=>{pickItems(item, e)}}>선택</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div class={styles.selected_item_container}>
        <div class={styles.selected_item_component}>
          분류 {selectedDeliveryType}
        </div>
        <div class={styles.selected_item_component}>
          상품명 {selectedItemName}
        </div>
        <div class={styles.selected_item_component}>
          판매가 {selectedItemPrice}
        </div>
        <div class={styles.selected_item_component}>
          재고 {selectedItemQuantity}
        </div>
        <div class={styles.selected_item_component}>
          <input type="text" value={orderCount} onChange={(e)=>{changeOrderCount(e)}}placeholder='주문 수량을 입력하세요.'></input>
        </div>
        <button onClick={(e)=>{addToShoppingCart(e)}}>장바구니 담기</button>
      </div>
    </div>
  );
};

export default ItemTable;