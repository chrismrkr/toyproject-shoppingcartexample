import React, {useState} from 'react';

import styles from '../css/Contentsmain.module.css';
import NavigationBar from './NavigationBar';
import ItemTable from './ItemTable';
import ItemRegisterForm from './ItemRegisterForm';
import ShoppingCartTable from './ShoppingCartTable';

const ContentsMain = (props) => {
    let [shoppingCart, setShoppingCart] = useState({});

    const addItemInShoppingCart = (shoppingCartItem) => {
        shoppingCartItem.orderCount = parseInt(shoppingCartItem.orderCount);
        shoppingCart[shoppingCartItem.itemName] = shoppingCartItem;    
        setShoppingCart(shoppingCart);
    };
    const removeItemInShoppingCart = async (e, itemName) => {
        e.preventDefault();
        const newShoppingCart = { ...shoppingCart };
        delete newShoppingCart[itemName];
        setShoppingCart(newShoppingCart);
    };

    switch(props.tabSelector) {
        case "ITEM_LIST":
            if(props.itemList.length == 0) {
                return (
                    <div className={styles.div_box}>
                        등록된 상품이 존재하지 않습니다.
                    </div>
                )
            }
            return (
                <div className={styles.div_box}>
                    <ItemTable data={props.itemList} addItemInShoppingCart={addItemInShoppingCart}></ItemTable>
                    <NavigationBar changePage={props.changePage} pageNumber={props.pageNumber} totalPage={props.totalPage}></NavigationBar>
                </div>
            );
        
        case "ITEM_REGISTER":
            return (
                <div className={styles.div_box}>
                    <ItemRegisterForm></ItemRegisterForm>
                </div>
            );

        case "SHOPPING_CART":
            return (
                <div className={styles.div_box}>
                    <ShoppingCartTable shoppingCartList={shoppingCart} removeItemInShoppingCart={removeItemInShoppingCart}></ShoppingCartTable>
                </div>
            );

        default:
            return null;
    }
};

export default ContentsMain;