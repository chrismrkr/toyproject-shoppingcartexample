import React, {useState} from 'react';

const ItemTable = (props) => {
  const [itemList, setItemList] = useState(props.data);
  const [buyCountList, setBuyCountList] = useState([]);

  const changeBuyCountList = (index, e) => {
    if(e) {
      e.preventDefault();
    }

    let newList = [];
    buyCountList.forEach(ele => newList.push(ele));
    newList[index] = e ? e.target.value : null;
    setBuyCountList(newList);
    debugger;
  };

  const pickItems = (index, e) => {
    e.preventDefault();
    alert("장바구니에 저장되었습니다. " + buyCountList[index]);
    changeBuyCountList(index, null);
  };
  
  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>분류</th>
            <th>상품명</th>
            <th>판매가</th>
            <th>재고</th>
            <th>구매수량</th>
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
                <input type="text" onChange={(e)=>{changeBuyCountList(index, e)}} value={buyCountList[index]} placeholder='구매 수량을 입력하세요.'></input>
              </td>
              <td>
                <button onClick={(e)=>{pickItems(index, e)}}>장바구니 담기</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ItemTable;