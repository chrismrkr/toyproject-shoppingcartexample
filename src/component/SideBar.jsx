import React, {useState} from 'react';
import styles from '../css/SideBar.module.css';

const SideBar = (props) => {
    const getItemList = () => {
        alert("상품 목록 가져오기 이벤트 발생");
        const findItems = []; // 여기에 GET /items 바인딩
        props.changeItemList(findItems);
    };
    const getItemRegisterForm = () => {
        alert("상품 등록 Form 가져오기 이벤트 발생");
    };

    return (
        <div className={styles.div_box}>
            <ul className={styles.ul_box}>
                <li onClick = {getItemList} className={styles.li_box}>상품 목록</li>
                <li onClick = {getItemRegisterForm} className={styles.li_box}>상품 등록</li>
                <li className={styles.li_box}>장바구니</li>
            </ul>
        </div>
    );
};

export default SideBar;