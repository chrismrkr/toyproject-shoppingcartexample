import React from 'react';

const ItemTable = (props) => {
  return (
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
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ItemTable;