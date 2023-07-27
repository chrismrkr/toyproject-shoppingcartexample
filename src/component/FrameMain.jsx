import React, {useState} from 'react';
import SideBar from './SideBar';
import Header from './Header';
import ContentsMain from './ContentsMain';

const FrameMain = () => {
    const [itemList, setItemList] = useState([]);
    const [pageNumber, setPageNumber] = useState();
    const [totalPage, setTotalPage] = useState();

    const changeItemList = (items) => {
        const newItemList = [];
        items.forEach(item => {
            newItemList.push(item);
        });
        setItemList(newItemList);
    }

    return (
        <div>
            <Header></Header>
            <SideBar changeItemList={changeItemList}></SideBar>
            <ContentsMain></ContentsMain>
        </div>
    );
};

export default FrameMain;