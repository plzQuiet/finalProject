# [Team 조용히해조] 도서관 홈페이지

## 목차
- [프로젝트 소개](#프로젝트-소개)
- [팀 구성 및 역할](#팀-구성-및-역할)
- [개발 환경](#개발-환경)
- [ERD](#erd)
- [주요 기능](#주요-기능)
- [화면 구성](#화면-구성)
- [개발 일정](#개발-일정)

---

## 프로젝트 소개
### 주제
- **독서활동 관리 시스템**
- 개인 및 단체의 독서활동을 효율적으로 지원하기 위한 웹 애플리케이션.

### 기획 의도
- 독서 활성화를 위한 플랫폼의 필요성에 따라, 사용자가 도서를 검색하고 신청하며, 개인 서재를 통해 독서 습관을 관리하도록 설계.
- 관리자 페이지를 통해 도서 관리 및 이용 현황 모니터링 기능 제공.

---

## 팀 구성 및 역할
| 이름       | 역할        | 주요 담당 페이지                        |
|------------|-------------|------------------------------------|
| **양세희** | 팀장        | 도서관 안내 페이지                     |
| **이재원** | 팀원        | 자료 검색, 내 서재, 관리자 페이지       |
| **김승연** | 팀원        | 맛있는 도서관 페이지                   |
| **유경진** | 팀원        | 이용자 마당 페이지                     |
| **최세현** | 팀원        | 참여 마당 페이지                       |

---

## 개발 환경
### Back-End
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white)
![Servlet & JSP](https://img.shields.io/badge/Servlet%20&%20JSP-1E90FF?style=for-the-badge&logo=Java&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=ApacheTomcat&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white)

### Front-End
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white)
![jQuery](https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white)

### Tools
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-007ACC?style=for-the-badge&logo=VisualStudioCode&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white)
![SourceTree](https://img.shields.io/badge/SourceTree-0052CC?style=for-the-badge&logo=SourceTree&logoColor=white)
![Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=Figma&logoColor=white)

---

## ERD
- 데이터베이스 설계를 통해 사용자, 도서, 예약, 신청 등 데이터를 효율적으로 관리.
![image](https://github.com/user-attachments/assets/ff3fde41-7e22-41f6-9e8d-cc55552a711f)


---

## 주요 기능

---

### 도서관 안내 페이지
#### 도서관 소개
- 인사말
- 연혁
- 조직도
- 도서관 오시는 길 관리 (조회, 작성, 수정, 삭제)

#### 도서관 달력
- 도서관 이용 시간 관리
- 도서관 달력 (API) 일정 관리 (조회, 작성, 수정, 삭제)

#### 주변 도서관
- 주변 도서관 관리 (조회, 작성, 수정, 삭제)
- 시설 안내 조회

---

### 자료 검색 페이지
#### 통합 자료 검색
- 간략 검색: 전체, 도서명, 저자 선택 검색
- 상세 검색: 서명, 저자, 출판사, 발행 연도 검색
- 도서 즐겨찾기
- 도서 예약

#### 희망 도서 신청
- 희망 도서 관리:
  - 신청
  - 수정
  - 삭제
  - 승인 / 거절

---

### 참여 마당 페이지
#### 교육문화 프로그램
- 프로그램 목록 및 신청 상태 조회
- 제목 및 내용 검색

#### 교육문화 프로그램 상세 게시글
- 게시글 조회
- 목록 이동
- 신청 버튼 (마감 인원 및 기간에 따라 활성화)
- 게시글 관리:
  - 홈페이지 스위퍼 추가
  - 글, 기간 작성 / 수정 / 삭제

#### 열람실 및 세미나실
- 이용 안내 조회
- 로그인 시 예약 가능
- 열람실 예약:
  - 일자 / 시간 선택 시 좌석 조회
  - 사용 가능 좌석 선택 후 예약 가능
- 세미나실 예약:
  - 달력 API로 일자 선택
  - 타임슬롯 조회 및 예약 가능
  - 예약 조건:
    - 사용 가능 슬롯만 선택
    - 최대 3시간, 연속된 시간만 선택 가능

---

### 이용자 마당 페이지
#### 공지사항
- 게시글 목록 및 상세 조회
- 게시글 검색
- 게시글 관리 (작성, 수정, 삭제)
- 조회수 표시

#### 문의사항
- 게시글 목록 및 상세 조회
- 게시글 검색
- 게시글 관리 (작성, 수정, 삭제)
- 작성자 이름 암호화 (예: 홍길동 → 홍*동)
- 게시글 상태 선택 (공개 / 비공개)

#### 책 후기 나눠요
- 게시글 목록 및 상세 조회
- 게시글 검색
- 게시글 관리 (작성, 수정, 삭제)
- 댓글 관리 (작성, 수정, 삭제)

---

### 맛있는 도서관 페이지
#### 구내 식당
- 메뉴 관리 (조회, 작성, 수정, 삭제)
- 식권 수량 선택 후 구매 (카카오 API 활용)

#### 카페
- 메뉴 관리 (조회, 작성, 수정, 삭제)
- 메뉴 및 수량 선택 후 구매 (카카오 API 활용)

---

### 내 서재 페이지
- 대출 도서 관리
- 즐겨찾기 관리
- 이전 대출 조회
- 예약 / 신청 내역 조회 및 관리 (수정, 삭제)
- 클래스 내역 조회 및 관리
- 결제 내역 조회
- 내 정보 관리:
  - 글/댓글 조회
  - 정보 수정
  - 비밀번호 변경
  - 회원 탈퇴

---

### 로그인 페이지
- 비밀번호 초기화
- 아이디 찾기
- 회원가입 이동
- 아이디 저장
- 유효성 검사

---

### 회원 관리 페이지
- 아이디 중복 검사
- 유효성 검사
- 이메일 인증

---

### 관리자 페이지
- 회원 정보 관리
- 게시글 관리
- 댓글 관리
- 클래스 신청 관리 (조회, 수정, 삭제)

## 화면 구현
[화면 구현 설명.pdf](https://github.com/user-attachments/files/18340817/_.pdf)


---

## 개발 일정
- **총 개발 기간**: 2024.08.13 ~ 2024.09.26
- **주요 일정**:
  - 프로젝트 주제 선정: 2024.08.13 ~ 2024.08.16
  - 자료 조사: 2024.08.16 ~ 2024.08.19
  - 기획 보고서 작성: 2024.08.19 ~ 2024.08.20
  - 와이어프레임, 유스케이스, 요구사항 정의서 작성: 2024.08.21 ~ 2024.08.28
  - ERD, 테이블 정의서 작성: 2024.08.25 ~ 2024.09.03
  - 화면 페이지 구현: 2024.08.30 ~ 2024.09.09
  - 백엔드 작업: 2024.09.09 ~ 2024.09.20
  - 최종본 오류검사 및 정리: 2024.09.21 ~ 2024.09.25
