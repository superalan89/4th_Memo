# JAVA UTIL

## 1. SimpleDateFormat
날짜-시간 형식으로 나타내주는 유틸로 (yyyy년 MM월 dd일 hh시 mm분 ss초)의 형태를 띄운다.

**currentTimeMillis** : 1970년 1월 1일 00:00:00을 기준으로 현재 시간의 차이를 long 형으로 반환.


 ## 2. Scanner

문자열을 입출력 할 수 있게 해준 자나 유틸로 다양한 타입의 입력 값들을 읽어드리기 위한 편리한 방법을 제공


**Scanner scan = new Scanner (System.in);**
Scanner는 System.in 외에 다양한 인자를 읽어들여 파싱 및 처리를 해준다.

**message = scan.nextLine();**
scanner의 nextLine() 메소드는 Scan한 소스의 다음 문자열 라인을 읽어 온다.

## 3. ArrayList

배열의 발전된 형태로, 객체들을 삽입, 삭제, 검색 할 수 있는 컨테이너 클래스

<장점 및 특징>
- 배열의 길이 제한 단점을 극복
- 삽입되는 객체의 수가 많아지면 자동으로 크기 조절이 됨
- 아이템을 벡터의 맨 마지막이나 중간에 삽입이 가능
- ArrayList 맨 뒤에 객체 추가 : 벡터 공간이 모자르면 자동으로 늘려줌
- ArrayList 중간에 객체 삽입 : 뒤에 존재하던 객체는 한칸씩 뒤로 이동
- 임의의 위치에 있는 객체 삭제 : 객체 삭제 후 한칸씩 앞으로 자동 이동

## MVC

![MVC](/img/mvc.png "MVC")

MVC란 Model View Controller의 약자로 에플리케이션을 세가지의 역할로 구분한 개발 방법론이다. 아래의 그림처럼 사용자가 Controller를 조작하면 Controller는 Model을 통해서 데이터를 가져오고 그 정보를 바탕으로 시각적인 표현을 담당하는 View를 제어해서 사용자에게 전달하게 된다.

**1.Controller(컨트롤러)**<br>
사용자가 접근한 URL에 따라서 사용자의 요청사항을 파악한 후에 그 요청에 맞는 데이터를 Model에 의뢰하고 데이터를 View에 반영해서 사용자에게 알려준다.

**2.Model(데이터 DB파일 저장소)**<br>
일반적으로 CI의 모델은 데이터베이스 테이블에 대응된다. 이를테면 Topic이라는 테이블은 topic_model이라는 Model을 만든다. 그런데 이 관계가 강제적이지 않기 때문에 규칙을 일관성 있게 정의하는 것이 필요하다.

**3.View(화면 입출력)**<br>
View는 클라이언트 측 기술인 html/css/javascript들을 모아둔 컨테이너이다.
