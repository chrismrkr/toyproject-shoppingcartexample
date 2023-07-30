import React, {useState} from 'react';
import styles from '../css/NavigationBar.module.css';


const NavigationBar = (props) => {
    return (
        <div className={styles.main_div}>
            <button onClick={(e)=>{props.changePage("prev", e)}}>&lt;</button>
            {props.pageNumber+1}/{props.totalPage}
            <button onClick={(e)=>{props.changePage("next", e)}}>&gt;</button>
        </div>
    );
};

export default NavigationBar;