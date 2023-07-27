import React, {useState} from 'react';
import Logo from './Logo';
import styles from '../css/Header.module.css';

const Header = () => {
    return (
        <div className={styles.header_div}>
            <Logo className={styles.header_logo}></Logo>
        </div>
    );
};

export default Header;