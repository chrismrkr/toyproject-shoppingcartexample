import React, {useState} from 'react';

import styles from '../css/Contentsmain.module.css';
import NavigationBar from './NavigationBar';
import ItemTable from './ItemTable';

const ContentsMain = (props) => {
    return (
        <div className={styles.div_box}>
            <ItemTable data={props.itemList}></ItemTable>
            <NavigationBar changePage={props.changePage} pageNumber={props.pageNumber} totalPage={props.totalPage}></NavigationBar>
        </div>
    );
};

export default ContentsMain;