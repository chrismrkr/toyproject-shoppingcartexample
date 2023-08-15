import React, {useState} from 'react';
import styles from '../css/SideBar.module.css';

const SideBar = (props) => {

    const loadItemList = async (e) => {
        e.preventDefault();
        e.stopPropagation();
        // 1. GET /items?page=0
        try {
            let response = await fetch("http://localhost:8080/items?page=0", {"method":"GET"});
            let jsonData = await response.json();
            // 2. set newItemList, newPageNumber, newTotalPage      
            const newItemList = jsonData.content;
            const newPagerNumber = jsonData.number;
            const newTotalPage = jsonData.totalPages;
            props.setNewItemList(newItemList, newPagerNumber, newTotalPage);
        } 
        catch(error) {
            console.log("error 발생");
        }
        props.selectTab("ITEM_LIST");
    };
    const getItemRegisterForm = () => {
        props.selectTab("ITEM_REGISTER");
    };
    const getShoppingCartForm = () => {
        props.selectTab("SHOPPING_CART");
    }

    return (
        <div className={styles.div_box}>
            <ul className={styles.ul_box}>
                <li onClick = {(e) => {loadItemList(e)}} className={styles.li_box}>상품 목록</li>
                <li onClick = {getItemRegisterForm} className={styles.li_box}>상품 등록</li>
                <li onClick = {getShoppingCartForm} className={styles.li_box}>장바구니</li>
            </ul>
        </div>
    );
};

export default SideBar;