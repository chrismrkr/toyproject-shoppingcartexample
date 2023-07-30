const fetchGet = (apiUrl) => {
    // "처리 중.." 팝업 띄우기
    return fetch(apiUrl)
        .then((resData) => {
            // "처리 중.." 팝업 종료
            debugger;
        })
        .catch((error) => {
            // "처리 중.." 팝업 종료
            debugger;
        });
}