import React, {useState} from 'react';

import styles from '../css/Contentsmain.module.css';
import NavigationBar from './NavigationBar';
import ItemTable from './ItemTable';
import ItemRegisterForm from './ItemRegisterForm';

const ContentsMain = (props) => {
    const [shoppingCart, setShoppingCart] = useState({});

    const addItemInShoppingCart = (shoppingCartItem) => {
        shoppingCartItem.orderCount = parseInt(shoppingCartItem.orderCount);
        shoppingCart[shoppingCartItem.itemName] = shoppingCartItem;    
        setShoppingCart(shoppingCart);
    };

    switch(props.tabSelector) {
        case "ITEM_LIST":
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

                </div>
            );

        default:
            return null;
    }
};

export default ContentsMain;