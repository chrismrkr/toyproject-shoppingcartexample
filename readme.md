# 상품-장바구니 예제

Spring Framework 및 React 연습을 위해 상품 등록 조회 및 장바구니 담기 기능을 구현한 예제


## 1. Backend (branch : backend-main)

## Api

+ GET /items : 상품 조회

화면 렌더링 속도와 반응성을 위하여 페이징을 활용하였음.

+ POST /item : 상품 등록

## 2. Frontend (branch : main)

## 화면 구성

+ 상품 조회 화면 : 상품 조회 및 장바구니 담기 기능을 제공하는 페이지(GET /items)
+ 상품 등록 화면 : 상품을 신규 등록하는 페이지(POST /item 사용)
+ 장바구니 화면 : 장바구니에 담긴 상품을 조회하는 페이지

## 3. CORS 정책 위반 관련 트러블 슈팅

Frontend-Backend를 API 연동하면서 아래의 CORS 정책 위반 문제를 마주하였다.

```
Access to fetch at 'http://localhost:8080/items?page=0' from origin 'http://localhost:3000' has been blocked by CORS policy:
No 'Access-Control-Allow-Origin' header is present on the requested resource.
If an opaque response serves your needs, set the request's mode to 'no-cors' to fetch the resource with CORS disabled
```

### CORS 정책이란

CORS 정책을 이해하기 이전에 아래의 배경지식이 필요했다.

+ Origin : ip와 port. Origin은 리소스를 찾아가기 위한 기본적인 정보를 의미함
+ SOP(Same-Origin Policy) : 같은 출처(ip, port)에서만 리소스를 공유할 수 있다는 RFC 규약

그러나, API 통신과 같이 다른 출처(Origin)에서 리소스를 가져오는 경우가 많다.

그래서 SOP를 완화하고 CORS 정책을 지키면 리소스를 가져올 수 있는 방식이 등장했다. 즉, CORS 정책을 지키면 서로 다른 출처로부터 리소스를 가져올 수 있다는 것을 의미한다.

### CORS 정책이 필요한 이유

웹 사이트에서 스크립트를 통해 CSRF, XSS 공격이 가능하다.

+ CSRF, XSS 공격 부연 설명 : https://github.com/chrismrkr/WIL/blob/main/CS/computerNetwork.md#52-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EB%B3%B4%EC%95%88-%EC%A4%91%EC%9A%94-%EA%B0%9C%EB%85%90

이를 막기 위해 같은 출처인지 다른 출처인지 구분하는 로직이 필요하게 되었다.

### 위의 에러가 발생한 이유

브라우저에서는 출처를 구분하는 로직이 자체적으로 구현되어 있다.

만약, 서버에서 출처 비교 로직이 구현되어 있지 않다면 아래와 같은 흐름으로 request-response가 동작한다.

```
CORS 정책 위반 Request -> |Server| -> 출처 구분 로직 없으므로 정상 response
-> 브라우저에서의 출처 구분 판단 -> CORS 정책을 위반했으므로 브라우저가 response를 버림
```

위의 흐름에 의해서 처음으로 제시한 ```Access to fetch at 'http://localhost:8080/items?page=0' from origin 'http://localhost:3000' has been blocked by CORS policy``` 에러가 발생한 것이다.

ps. API 통신시 일반적으로 클라이언트는 총 2번의 request를 보낸다.(preflight Request : CORS 정책 확인을 위한 request, 실제 request) 

### 개발 환경에서 CORS 정책을 지키는 방법

#### 서버에 Access-Control-Allow-Origin 설정하기

스프링 기반 서버에서는 WebConfig 클래스를 설정하여 허용할 Cross Origin을 지정한다.

```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000");
    }
}
```

#### Webpack Dev Server로 리버스 프록싱하기

클라이언트 서버에 일종의 프록시 서버를 생성하는 방법이다.

클라이언트 프록시 서버의 매핑 룰에 의해 request-response 주소를 동일 출처로 변경하는 방법이다.

### 운영 환경에서 CORS 정책을 지키는 방법

+ API 서버에 Access-Control-Allow-Origin 설정
+ 리버스 프록시 서버 생성 : 클라이언트에서의 모든 request는 프록시서버가 받도록 하고, 적절한 경우에만 실제 API 서버에 요청을 하는 방식 
