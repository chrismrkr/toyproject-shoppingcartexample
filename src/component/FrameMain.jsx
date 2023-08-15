import React, {useState} from 'react';
import SideBar from './SideBar';
import Header from './Header';
import ContentsMain from './ContentsMain';

const FrameMain = () => {
    const [itemList, setItemList] = useState([]);
    const [pageNumber, setPageNumber] = useState();
    const [totalPage, setTotalPage] = useState();
    const [tabSelector, setTabSelector] = useState();
    
    const selectTab = (tabName) => {
        setTabSelector(tabName);
    };
    const setNewItemList = (newItemList, newPageNumber, newTotalPage) => {
        const tmpItemList = [];
        newItemList.forEach(item => {
            tmpItemList.push(item);
        });
        setItemList(tmpItemList);
        setPageNumber(newPageNumber);
        setTotalPage(newTotalPage);
    }
    const changePage = async (param, e) => {
        e.preventDefault();
        e.stopPropagation();
        let nextPageNumber;
        if(param == "next") {
            // setNewPageNumber    
            nextPageNumber = (pageNumber+1) % totalPage;
        } else {
            // setNewPageNumber
            nextPageNumber = (totalPage + pageNumber - 1) % totalPage;
        }
        // 1. GET /items?page=newPageNumber
        try {
            let response = await fetch("http://localhost:8080/items?page="+(nextPageNumber), {"method":"GET"});
            let jsonData = await response.json();
            // 2. set newItemList, newPageNumber, newTotalPage      
            const newItemList = jsonData.content;
            const newTotalPage = jsonData.totalPages;
            const newPageNumber = jsonData.number;
            debugger;
            // 2. setTotalPage
            // 3. setItemList
            setItemList(newItemList);
            setPageNumber(newPageNumber);
            setTotalPage(newTotalPage);
        } catch(error) {
            console.log(error);
        }
    }

    return (
        <div>
            <Header></Header>
            <SideBar selectTab={selectTab} setNewItemList={setNewItemList}></SideBar>
            <ContentsMain changePage={changePage} itemList={itemList} pageNumber={pageNumber} totalPage={totalPage} tabSelector={tabSelector}></ContentsMain>
        </div>
    );
};

export default FrameMain;