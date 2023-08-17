# 상품-장바구니 예제

Spring Framework 및 React 연습을 위해 상품 등록 조회 및 장바구니 담기 기능을 구현한 예제


## 1. Backend (branch : backend-main)

## Api

+ GET /items : 상품 조회

조회하여 화면에 렌더링 속도와 반응성을 위하여 페이징을 활용하였음.

+ POST /item : 상품 등록

## 2. Frontend (branch : main)

## 화면 구성

+ 상품 조회 화면 : 상품 조회 및 장바구니 담기 기능을 제공하는 페이지(GET /items)
+ 상품 등록 화면 : 상품을 신규 등록하는 페이지(POST /item 사용)
+ 장바구니 화면 : 장바구니에 담긴 상품을 조회하는 페이지

## 3. CORS 정책 위반 관련 트러블 슈팅



