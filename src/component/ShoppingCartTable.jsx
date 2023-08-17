import React, {useState} from 'react';

const ShoppingCartTable = (props) => {
    return (
        <table>
            <thead>
                <tr>
                    <td>분류</td>
                    <td>상품</td>
                    <th>판매가</th>
                    <td>주문수량</td>
                </tr>
            </thead>
            <tbody>
            {Object.keys(props.shoppingCartList).map((key) => (
              <tr key={props.shoppingCartList[key]}>
                <td>{props.shoppingCartList[key].deliveryType}</td>
                <td>{props.shoppingCartList[key].itemName}</td>
                <td>{props.shoppingCartList[key].itemPrice}</td>
                <td>{props.shoppingCartList[key].orderCount}</td>
                <td>
                    <button onClick={(e)=>{props.removeItemInShoppingCart(e, key)}}>삭제</button>
                </td>
              </tr>
            ))}
            </tbody>
        </table>
    );
};

export default ShoppingCartTable;