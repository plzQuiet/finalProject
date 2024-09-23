-- [INDEX]
-- 1. FOOD_TYPE
-- 2.CATEGORY
-- 3. MEMBER
-- 4. CALENDAR

-- FOOD_TYPE INSERT
INSERT INTO FOOD_TYPE VALUES( 0,'백반');
INSERT INTO FOOD_TYPE VALUES( 1,'분식');
INSERT INTO FOOD_TYPE VALUES( 2,'커피');

-- 카테고리
-- 레벨 1
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'도서관 안내',NULL);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'자료 검색',NULL);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'참여마당',NULL);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'이용자 마당',NULL);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'맛있는 도서관',NULL);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'내 서재',NULL);

-- 레벨 2
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'도서관 소개',1);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'이용안내',1);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'시설안내',1);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'통합자료 검색',2);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'희망 도서 신청',2);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'교육문화 프로그램',3);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'열람실',3);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'세미나실',3);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'공지사항',4);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'문의사항',4);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'자주 묻는 질문',4);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'책 후기 나눠요',4);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'구내식당',5);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'카페',5);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'나의 도서관',6);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'결제내역',6);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'회원정보',6);

--레벨 3
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'인사말',7);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'연혁',7);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'조직도',7);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'도서관 오시는 길',7);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'주변 도서관',7);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'이용시간',8);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'도서관 달력',8);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'간략 검색',10);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'상세 검색',10);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'도서현황',21);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'예약 및 신청',21);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'즐겨찾기',21);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'내 정보',23);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'정보수정',23);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'내 글 관리',23);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'비밀번호 변경',23);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'회원탈퇴',23);

-- 레벨 4
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'대출중인 도서',33);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'이전 대출내역',33);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'예약내역',33);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'신청내역',33);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'좌석 예약현황',34);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'공간 예약현황',34);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'클래스 신청현황',34);

-- 재원씨 알아서 가져와야해요...
--INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'구내식당',23);
--INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'카페',23);

INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'게시글',38);
INSERT INTO CATEGORY VALUES( SEQ_CAT_CODE.NEXTVAL,'댓글',38);
-- 잘못만들었으면 create에 가서 다시 만들고 다시 insert
commit;

-- MEMBER
-- 비밀번호 'p'
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01@kh.or.kr', 
    '$2a$10$i6IHXqyhAXEz/FWz/eTjUuESsOZDtfha2SSNtI06PgQE16RlP6ucS',
    '유저일', '01011111111', 'F', '19991231', DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user02@kh.or.kr', 
    '$2a$10$i6IHXqyhAXEz/FWz/eTjUuESsOZDtfha2SSNtI06PgQE16RlP6ucS',
    '유저이', '01022222222', 'M', '19981130', DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user03@kh.or.kr', 
    '$2a$10$i6IHXqyhAXEz/FWz/eTjUuESsOZDtfha2SSNtI06PgQE16RlP6ucS',
    '유저삼', '01033333333', 'F', '19971029', DEFAULT, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user04@kh.or.kr', 
    '$2a$10$i6IHXqyhAXEz/FWz/eTjUuESsOZDtfha2SSNtI06PgQE16RlP6ucS',
    '유저사', '01044444444', 'M', '19960928', DEFAULT, DEFAULT, DEFAULT, DEFAULT);

-- 관리자 아이디
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, 'admin', 
    '$2a$10$i6IHXqyhAXEz/FWz/eTjUuESsOZDtfha2SSNtI06PgQE16RlP6ucS',
    '관리자', '01012341234', 'M', '19950827', DEFAULT, DEFAULT, DEFAULT, 2);


COMMIT;

-- CALENDAR
-- 공휴일
-- 2024
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '신정', '2024-01-01', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '설 연휴', '2024-02-09', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '설', '2024-02-10', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '설 연휴', '2024-02-11', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '대체공휴일', '2024-02-12', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '삼일절', '2024-03-01', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '22대 국회의원 선거', '2024-04-10', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '근로자의 날(근로자만)', '2024-05-01', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '어린이날', '2024-05-05', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '부처님 오신 날', '2024-05-15', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '현충일', '2024-06-06', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '광복절', '2024-08-15', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '추석연휴', '2024-09-16', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '추석', '2024-09-17', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '추석연휴', '2024-09-18', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '개천절', '2024-10-03', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '한글날', '2024-10-09', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '크리스마스', '2024-12-25', NULL, 1);

-- 2025
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '신정', '2025-01-01', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '설 연휴', '2025-01-28', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '설', '2025-01-29', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '설 연휴', '2025-01-30', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '삼일절', '2025-03-01', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '대체공휴일', '2025-03-03', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '근로자의 날(근로자만)', '2025-05-01', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '어린이날', '2025-05-05', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '부처님 오신 날', '2025-05-05', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '대체공휴일', '2025-05-06', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '현충일', '2025-06-06', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '광복절', '2025-08-15', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '개천절', '2025-10-03', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '추석연휴', '2025-10-05', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '추석', '2025-10-06', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '추석연휴', '2025-10-07', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '대체공휴일', '2025-10-08', NULL, 1);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '한글날', '2025-10-09', NULL, 1);

INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '크리스마스', '2025-12-25', NULL, 1);

-- 휴관일(금요일)
-- 2024
-- 1월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-01-05', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-01-12', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-01-19', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-01-26', NULL, 2);

-- 2월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-02-02', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-02-09', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-02-16', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-02-23', NULL, 2);

-- 3월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-03-01', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-03-08', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-03-15', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-03-22', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-03-29', NULL, 2);

-- 4월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-04-05', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-04-12', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-04-19', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-04-26', NULL, 2);

-- 5월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-05-03', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-05-10', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-05-17', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-05-24', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-05-31', NULL, 2);

-- 6월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-06-07', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-06-14', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-06-21', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-06-28', NULL, 2);

-- 7월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-07-05', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-07-12', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-07-19', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-07-26', NULL, 2);

-- 8월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-08-02', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-08-09', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-08-16', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-08-23', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-08-30', NULL, 2);

-- 9월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-09-06', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-09-13', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-09-20', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-09-27', NULL, 2);

-- 10월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-10-04', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-10-11', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-10-18', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-10-25', NULL, 2);

-- 11월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-11-01', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-11-08', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-11-15', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-11-22', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-11-29', NULL, 2);

-- 12월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-12-06', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-12-13', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-12-20', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2024-12-27', NULL, 2);

-- 2025
-- 1월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-01-03', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-01-10', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-01-17', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-01-24', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-01-31', NULL, 2);

-- 2월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-02-07', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-02-14', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-02-21', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-02-28', NULL, 2);

-- 3월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-03-07', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-03-14', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-03-21', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-03-28', NULL, 2);

-- 4월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-04-04', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-04-11', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-04-18', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-04-25', NULL, 2);

-- 5월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-05-02', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-05-09', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-05-16', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-05-23', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-05-30', NULL, 2);

-- 6월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-06-06', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-06-13', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-06-20', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-06-27', NULL, 2);

-- 7월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-07-04', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-07-11', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-07-18', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-07-25', NULL, 2);

-- 8월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-08-01', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-08-08', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-08-15', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-08-22', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-08-29', NULL, 2);

-- 9월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-09-05', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-09-12', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-09-19', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-09-26', NULL, 2);

-- 10월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-10-03', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-10-10', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-10-17', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-10-24', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-10-31', NULL, 2);

-- 11월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-11-07', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-11-14', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-11-21', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-11-28', NULL, 2);

-- 12월
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-12-05', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-12-12', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-12-19', NULL, 2);
INSERT INTO CALENDAR VALUES( SEQ_CALENDAR_NO.NEXTVAL, '휴관일', '2025-12-26', NULL, 2);

-- 행사
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, '도서관 개관' ,'2024-04-11', '2024-04-11',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, 'Java 시험' ,'2024-05-17', '2024-05-17',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, 'SQL 시험' ,'2024-06-05', '2024-06-05',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, 'UI 시험' ,'2024-06-24', '2024-06-24',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, '서버 시험' ,'2024-07-15', '2024-07-15',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, '통합 시험' ,'2024-08-06', '2024-08-06',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, 'API 시험' ,'2024-08-14', '2024-08-14',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, '스프링, API 시험' ,'2024-09-05', '2024-09-05',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, '채팅 AOP 시험' ,'2024-09-12', '2024-09-12',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, '시험' ,'2024-09-23', '2024-09-23',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, '면접1' ,'2024-09-23', '2024-09-23',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, '면접2' ,'2024-09-24', '2024-09-24',3);
INSERT INTO CALENDAR VALUES(SEQ_CALENDAR_NO.NEXTVAL, '도서관 휴업' ,'2024-09-26', '2024-09-26',3);

COMMIT;

-------------------------------------------------------- 백반 ----------------------------------------------------- 
-- 첫번째 메뉴 --
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '오징어뭇국', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '된장국', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '삼계탕', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '콩나물국', DEFAULT, DEFAULT, NULL, NULL);
-- 금(휴관일) -- 
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '부대찌개', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '오이냉국', DEFAULT, DEFAULT, NULL, NULL);

-- 두번째 메뉴 -- 
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '콩나물무침', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '멸치볶음', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '가지무침', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '흑미밥', DEFAULT, DEFAULT, NULL, NULL);
-- 금(휴관일) -- 
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '치킨', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '오이김밥', DEFAULT, DEFAULT, NULL, NULL);

-- 세번째 메뉴 --
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '계란말이', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '오징어채무침', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '시금치나물', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '춘천닭갈비', DEFAULT, DEFAULT, NULL, NULL);
-- 금(휴관일) --
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '가자미양념튀김', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '오이소박이', DEFAULT, DEFAULT, NULL, NULL);

-- 네번째 메뉴 --
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '오이소박이', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '김', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '건새우마늘쫑볶음', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '진미채', DEFAULT, DEFAULT, NULL, NULL);
-- 금(휴관일) --
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '김치', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '오이무침', DEFAULT, DEFAULT, NULL, NULL);

-- 다섯번째 메뉴 --
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '불고기', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '비엔나소시지볶음', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '깍두기', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '콩자반', DEFAULT, DEFAULT, NULL, NULL);
-- 금(휴관일) --
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '미역줄기볶음', DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 0, '오이', DEFAULT, DEFAULT, NULL, NULL);


-- 스낵 --
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 1, '라볶이', DEFAULT, DEFAULT, '/resources/images/food/rabokki.jpeg', null);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 1, '돈까스', DEFAULT, DEFAULT, '/resources/images/food/porkCutlet.png', null);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 1, '순두부찌개', DEFAULT, DEFAULT, '/resources/images/food/20240917224828_02212.jpg', null);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 1, '게살버거', DEFAULT, DEFAULT, '/resources/images/food/20240917225648_64631.jpg', null);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 1, '찜닭', DEFAULT, DEFAULT, '/resources/images/food/20240917230123_22463.jpg', null);
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 1, '라면', DEFAULT, DEFAULT, '/resources/images/food/ramen.png', null);

-- COFFEE
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 2, '아이스 아메리카노', 3500, DEFAULT, '/resources/images/food/iceAmericano.png', '아이스 아메리카노이다. 생명수이다.');
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 2, '아메리카노', 3500, DEFAULT, '/resources/images/food/hotAmericano.png', '뜨아거! 뜨거운 아메리카노이다. 뜨겁다.');
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 2, '자몽 허니 블랙티', 5700, DEFAULT, '/resources/images/food/jamongHoneyBlackTea.png', '자몽 허니 블랙티이다. 경진언니의 픽이다.');
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 2, '라면 국물', 500, DEFAULT, '/resources/images/food/ramenSoup.png', '라면 국물입니다. 슬러시컵에 드려요. 면은 없습니다.');
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 2, '라떼', 4000, DEFAULT, '/resources/images/food/20240918110806_17193.jpg', '라떼 is horse...');
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 2, '딸기라떼', 6000, DEFAULT, '/resources/images/food/20240918124706_49739.png', '딸기라떼입니다. 딸기게임 아세요?🍓🍓');
INSERT INTO FOOD VALUES(SEQ_FOOD_NO.NEXTVAL, 2, '구름라떼', 7500, DEFAULT, '/resources/images/food/20240918150204_10192.jpeg', '구름맛이 나요~! 왕!!하고 베어무세요!!!☁');
commit;

BEGIN
   FOR I IN 1..20 LOOP
      INSERT INTO BOARD 
      VALUES( SEQ_BOARD_NO.NEXTVAL,
                5, 15,
              I || '번째 공지사항',
              I || '번째 공지사항 내용 입니다.',
              DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
   END LOOP;
END;
/

BEGIN
   FOR I IN 1..100 LOOP
      INSERT INTO BOARD 
      VALUES( SEQ_BOARD_NO.NEXTVAL,
              CEIL(DBMS_RANDOM.VALUE(0,4)), 16,
              I || '번째 문의사항',
              I || '번째 문의사항 내용 입니다.',
              DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
   END LOOP;
END;
/
--DELETE FROM BOARD;
BEGIN
   FOR I IN 1..200 LOOP
      INSERT INTO BOARD 
      VALUES( SEQ_BOARD_NO.NEXTVAL,
             CEIL(DBMS_RANDOM.VALUE(0,4)), 18,
              I || '번째 후기글',
              I || '번째 후기글 내용 입니다.',
              DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
   END LOOP;
END;
/
commit;

-- 도서 샘플 데이터
-- 도서 정상 대출 중
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 5044, 1, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 4698, 1, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 12151, 1, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 6351, 1, DEFAULT, DEFAULT, DEFAULT);

-- 도서 연체
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 498, 1, SYSDATE - 20, SYSDATE - 6, DEFAULT);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 13661, 1, SYSDATE - 20, SYSDATE - 6, DEFAULT);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 4242, 1, SYSDATE - 20, SYSDATE - 6, DEFAULT);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 1535, 1, SYSDATE - 20, SYSDATE - 6, DEFAULT);

-- 도서 정상 반납
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 9, 1, SYSDATE - 10, SYSDATE + 4, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 10, 1, SYSDATE - 10, SYSDATE + 4, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 11, 1, SYSDATE - 10, SYSDATE + 4, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 12, 1, SYSDATE - 10, SYSDATE + 4, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 13, 1, SYSDATE - 10, SYSDATE + 4, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 14, 1, SYSDATE - 10, SYSDATE + 4, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 15, 1, SYSDATE - 10, SYSDATE + 4, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 16, 1, SYSDATE - 10, SYSDATE + 4, SYSDATE);

-- 도서 연체 반납
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 17, 1, SYSDATE - 20, SYSDATE - 6, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 18, 1, SYSDATE - 20, SYSDATE - 6, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 19, 1, SYSDATE - 20, SYSDATE - 6, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 20, 1, SYSDATE - 20, SYSDATE - 6, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 21, 1, SYSDATE - 20, SYSDATE - 6, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 22, 1, SYSDATE - 20, SYSDATE - 6, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 23, 1, SYSDATE - 20, SYSDATE - 6, SYSDATE);
INSERT INTO BORROW VALUES(SEQ_BOR_NO.NEXTVAL, 24, 1, SYSDATE - 20, SYSDATE - 6, SYSDATE);

-- 도서 예약
INSERT INTO B_RESERVATION VALUES(SEQ_BRESERVATION_NO.NEXTVAL, 3564, 1, DEFAULT);

-- 도서 신청
INSERT INTO BOOK_REQUEST VALUES(SEQ_RBOOK_NO.NEXTVAL,
    1, '하루키', '1Q84', '몰라', '신청합니다', DEFAULT,
    DEFAULT, DEFAULT, '추천합니다.'
);

-- 도서 즐겨찾기
INSERT INTO BOOK_LIKE VALUES(1, 1);


-------------------------------------클래스 게시판 INSERT-------------------------------------

-- 클래스 INSERT

-- 대체변수 인식 해결
SET DEFINE OFF;

--1. sns
insert into BOARD values(4000, 5, 12, 'SNS를 활용한 전자책 만들기 과정 교육', '■ 교육개요<br><br>ㅇ 과 정 명 : SNS를 활용한 전자책 만들기<br><br>ㅇ 교육일정 : 2023. 9. 13.(수)~ 9. 22.(금)<br><br>- 매주 수·금요일 09:30~11:30(2시간) / 총 4차시 8시간<br><br>ㅇ 교육장소 : 국립중앙도서관 디지털도서관 대회의실(B3)<br><br>ㅇ 교 육 비 : 무료<br><br>ㅇ 교육내용 : 블로그 등을 활용한 효과적인 글쓰기 방법과 전자책 제작 노하우 전수<br><br><br><br>9. 13.(수) 09:30~11:30<br><br>효과적인 SNS 글쓰기<br><br><br>9. 15.(금) 09:30~11:30<br><br>위퍼블 설치 및 기본 활용법<br><br><br>9. 20.(수) 09:30~11:30<br><br>전자책 편집 기본<br><br><br>9. 22.(금) 09:30~11:30<br><br>표지 디자인 및 유통 판로 탐색<br><br> <br><br>■ 모집안내<br><br>ㅇ 모집대상 : 블로그 등 SNS 운영중이신 분(만 16세 이상)<br><br>ㅇ 모집인원 : 30명<br><br>ㅇ 모집기간 : 2023. 8. 7.(월) 09:00 ~ 8. 27.(일) 24:00<br><br>ㅇ 지원방법 : 신청서 온라인 작성 및 제출<br><br>ㅇ 교육대상자 발표 : 9. 1.(금) (교육대상자에 한해 개별 연락)<br><br> <br><br> <br><br>■ 문의처<br><br>ㅇ 1인 미디어 아카데미 교육담당자<br><br>- 전 화 : 010-5176-9181<br><br>- 이메일 : arkim@imcapsule.com', TO_DATE('2024-09-23 12:06:32', 'YYYY-MM-DD HH24:MI:SS'), null, default, 'N', default);
insert into BOARD_IMG values (SEQ_IMG_NO.NEXTVAL, 4000, '/resources/images/scheduling/', 'sns.jpg', 'sns.jpg', 0);
insert into CLASS_SCHEDULE values(4000, TO_DATE('2024-10-01', 'YYYY-MM-DD'), TO_DATE('2024-10-10', 'YYYY-MM-DD') ,  TO_DATE('2024-09-19', 'YYYY-MM-DD') ,  TO_DATE('2024-09-24', 'YYYY-MM-DD') , 2);

--2. media
insert into BOARD values(4001, 5, 12, '미디어 정보 올바르게 활용하기 교육', '■ 교육개요<br><br>   ㅇ 교 육 명: 미디어 정보 올바르게 활용하기<br><br>   ㅇ 교육일시: 2024. 8. 28.(수) ~ 8. 30.(금) 14:00~16:00 (총 3차시/6시간)<br><br>   ㅇ 교육장소:  국립중앙도서관 디지털도서관 대회의실(B3)<br><br>   ㅇ 교 육 비: 무료<br><br><br><br>■ 교육내용<br><br><br>1차시  2024. 8. 28.(수)  14:00~16:00<br><br>디지털 미디어 시대의 독서<br><br>이지연 (연세대학교 교수)<br><br>2차시  2024. 8. 29.(목)  14:00~16:00<br><br>디지털 정보의 신뢰성 평가와 팩트체크 방법<br><br>황용석 (건국대학교 교수)<br><br><br>3차시  2024. 8. 30.(금)  14:00~16:00<br><br>윤리적인 정보 활용과 디지털 시민<br><br>윤미선 (서울여자대학교 교수)<br><br><br><br>■ 모집개요<br><br>   ㅇ 모집대상 : 도서관 이용자<br><br>   ㅇ 모집정원 : 30명 (선착순)<br><br>   ㅇ 모집기간: 2024. 7. 29.(월) ~ 8. 18.(일)  8. 25.(일) *모집기간 연장<br><br>   ㅇ 신청방법: 신청서 온라인 작성 및 제출<br><br>       * 국립중앙도서관 누리집(nl.go.kr) &gt; 신청·참여 &gt; 교육/문화프로그램 &gt; 미디어 활용 및 창작 교육<br><br>   ㅇ 교육대상자 발표: 2024. 8. 21.(수), 10:00 (개별 연락)<br><br><br><br>■ 유의사항<br><br>   ㅇ 프로그램 참여 시 모든 교육 일정에 필수적으로 참여 가능하신 분만 지원 바랍니다.<br><br>   ㅇ 교육 신청 후 사전 고지 없이 불참 시, 향후 모집정원 초과 교육 프로그램 선발에서 제외될 수 있습니다.<br><br><br><br>■ 교육문의<br><br>   ㅇ 디지털 정보활용 교육 담당자(010-5187-9181) / hjkim@imcapsule.com', TO_DATE('2024-09-23 12:06:33', 'YYYY-MM-DD HH24:MI:SS'), null, default, 'N', default);
insert into BOARD_IMG values (SEQ_IMG_NO.NEXTVAL, 4001, '/resources/images/scheduling/', 'media.jpg', 'media.jpg', 0);
insert into CLASS_SCHEDULE values(4001, TO_DATE('2024-10-11', 'YYYY-MM-DD'), TO_DATE('2024-10-15', 'YYYY-MM-DD') ,  TO_DATE('2024-09-19', 'YYYY-MM-DD') ,  TO_DATE('2024-09-24', 'YYYY-MM-DD') , 2);

--3. copilot
insert into BOARD values(4002, 5, 12, 'AI 비서 MS Copilot 활용(중급) 교육', '■ 모집 개요<br><br>  ㅇ모집대상: Copilot을 활용하여 업무 능력을 높이고 싶은 도서관 이용자<br><br>  ㅇ모집정원: 30명<br><br>  ㅇ모집기간: 2024. 8. 19.(월)~9. 8.(일)<br><br>  ㅇ선발방법: 지원서 심사 후 합격자에 한해 개별 통보<br><br>  ㅇ 지원방법: 신청서 온라인 작성 및 제출<br><br>     *국립중앙도서관 누리집(nl.go.kr) &gt; 신청·참여 &gt; 교육/문화프로그램 &gt; 미디어 활용 및 창작 교육<br><br>  ㅇ결과발표: 2024. 9. 13.(금), 10:00<br><br><br><br><br>■ 교육 개요<br><br>  ㅇ 교육일시: 2024. 9. 25.(수)~9. 27.(금), 10:00~12:00 (총 3차시/6시간)<br><br>  ㅇ 교육장소: 국립중앙도서관 디지털도서관 대회의실(B3)<br><br>  ㅇ 교육비: 무료<br><br>  ㅇ 교육혜택: 노트북 제공<br><br>  <br><br>■ 유의사항<br><br>  ㅇ 프로그램 참여 시 모든 교육 일정에 필수적으로 참여할 수 있는 분만 지원 바랍니다.<br><br>  ㅇ 교육 신청 후 사전 고지 없이 불참 시, 향후 모집 정원 초과 교육 프로그램 선발에서 제외될 수 있습니다.<br><br><br><br>■ 교육문의<br><br>  ㅇ AI 리터러시 아카데미 담당자<br><br>    - 전 화 : 010-5187-9181<br><br>    - 이메일 : hjkim@imcapsule.com', TO_DATE('2024-09-23 12:06:34', 'YYYY-MM-DD HH24:MI:SS'), null, default, 'N', default);
insert into BOARD_IMG values (SEQ_IMG_NO.NEXTVAL, 4002, '/resources/images/scheduling/', 'copilot.jpg', 'copilot.jpg', 0);
insert into CLASS_SCHEDULE values(4002, TO_DATE('2024-10-16', 'YYYY-MM-DD'), TO_DATE('2024-10-20', 'YYYY-MM-DD') ,  TO_DATE('2024-09-19', 'YYYY-MM-DD') ,  TO_DATE('2024-09-24', 'YYYY-MM-DD') , 2);

--4. art
insert into BOARD values(4003, 5, 12, 'Midjourney로 체험하는 AI 아트의 세계(실전응용) 교육', '■ 교육개요<br><br>ㅇ과 정 명 : Midjourney로 체험하는 AI 아트의 세계(실전응용)<br><br>ㅇ교육일정: 2024 . 6. 27.(목) ~ 28.(금), 10:00~12:00 (목·금요일/ 총 2차시 /4시간)<br><br>ㅇ교육장소: 국립중앙도서관 디지털도서관 대회의실(B3)<br><br>ㅇ교 육 비 : 무료 및 노트북 제공<br><br>ㅇ교육내용: Midjourney를 활용하여 프롬프트 작성과 작품 만들기 활동<br><br>차시<br><br>일시<br><br>교육 내용<br><br>1<br><br>6. 27.(목) 10:00~12:00<br><br> Midjourney 설치부터 효과적인 프롬프트 작성법<br><br>2<br><br>6. 28.(금) 10:00~12:00<br><br> Midjourney로 나만의 AI 작품 만들기<br><br><br><br><br><br>■ 모집안내<br><br>ㅇ 모집대상 : 예비 AI 크리에이터<br><br>ㅇ 모집정원 : 30명<br><br>ㅇ 지원자격 : 생성형 AI를 활용하여 이미지를 만들고 싶은 16세 이상 도서관 이용자  *생성형 AI 유료결제가 가능한 분<br><br>ㅇ 모집기간 : 2024. 5. 20.(월) ~ 6. 9.(일)<br><br>ㅇ 지원방법 : 신청서 온라인 작성 및 제출<br><br>*국립중앙도서관 누리집(nl.go.kr) &gt; 신청·참여 &gt; 교육/문화프로그램 &gt; 미디어 활용 및 창작 교육<br><br>ㅇ 결과발표 : 2024. 6. 14.(금), 10:00 (지원서 심사 후 합격자에 한해 개별 통보)<br><br><br><br>■ 유의사항<br><br>ㅇ 해당 교육과정은  Midjourney 유료버전으로 진행됩니다. 교육 시 신청자 본인 카드로 결제 후 교육이 진행될 예정입니다.<br><br>ㅇ 프로그램 참여 시 모든 교육 일정에 필수적으로 참여할 수 있는 분만 지원 바랍니다. <br><br>ㅇ 교육 신청 후 사전 고지 없이 불참 시, 향후 모집정원 초과 교육 프로그램 선발에서 제외될 수 있습니다.<br><br><br><br>■ 문의처<br><br>ㅇ AI 리터러시 아카데미 담당자<br><br>- 전 화 : 010-5187-9181<br><br>- 이메일 : hjkim@imcapsule.com', TO_DATE('2024-09-23 12:06:35', 'YYYY-MM-DD HH24:MI:SS'), null, default, 'N', default);
insert into BOARD_IMG values (SEQ_IMG_NO.NEXTVAL, 4003, '/resources/images/scheduling/', 'art.jpg', 'art.jpg', 0);
insert into CLASS_SCHEDULE values(4003, TO_DATE('2024-10-11', 'YYYY-MM-DD'), TO_DATE('2024-10-15', 'YYYY-MM-DD') ,  TO_DATE('2024-09-19', 'YYYY-MM-DD') ,  TO_DATE('2024-09-24', 'YYYY-MM-DD') , 2);

--5. gpt
insert into BOARD values(4004, 5, 12, 'Chat GPT를 활용한 글쓰기(실전응용) 교육', '■ 교육개요<br>ㅇ과 정 명 : 「Chat GPT를 활용한 글쓰기」<br><br>ㅇ교육일정: 2024 . 5. 23.(목) ~ 24.(금), 10:00~12:00 (목·금요일/ 총 2차시 /4시간)<br><br>ㅇ교육장소: 국립중앙도서관 디지털도서관 대회의실(B3)<br><br>ㅇ교 육 비 : 무료 및 노트북 제공<br><br>ㅇ교육내용: Chat GPT를 활용하여 고급 프롬프트 실습 및 챗봇 만들기 활동<br><br><br><br>차시<br><br>교육일시<br><br>강의 주제<br><br>1<br><br>5. 23.(목) 10:00~12:00<br><br>Chat GPT 고급 프롬프트 엔지니어링 실습<br><br>2<br><br>5. 24.(금) 10:00~12:00<br><br>MY GPTs로 나만의 챗봇 만들기<br><br><br><br><br><br>■ 모집안내<br><br>ㅇ 모집대상 :  예비 AI 크리에이터<br><br>ㅇ 모집정원 : 30명<br><br>ㅇ 지원자격 : 생성형 AI를 활용하여 글을 쓰고 싶은 만 16세 도서관 이용자  *생성형 AI 유료결제가 가능한 분<br><br>ㅇ 모집기간 : 2024. 4. 15.(월) ~ 5. 5.(일)<br><br>ㅇ 지원방법 : 신청서 온라인 작성 및 제출<br><br>*국립중앙도서관 누리집(nl.go.kr) &gt; 신청·참여 &gt; 교육/문화프로그램 &gt; 미디어 활용 및 창작 교육<br><br>ㅇ 교육대상자 선정 발표 : 2024. 5. 10.(금), 10:00 (지원서 심사 후 합격자에 한해 개별 통보)<br><br><br><br><br><br>■ 유의사항<br><br>ㅇ 해당 교육과정은  Chat GPT 4.0 유료버전으로 진행됩니다. 교육 시 신청자 본인 카드로 결제 후 교육이 진행될 예정입니다.<br><br>ㅇ 프로그램 참여 시 모든 교육 일정에 필수적으로 참여할 수 있는 분만 지원 바랍니다.<br><br><br>■ 문의처<br><br>ㅇ 디지털정보활용교육 담당자<br><br>- 전 화 : 010-5187-9181<br><br>- 이메일 : hjkim@imcapsule.com', TO_DATE('2024-09-23 12:06:36', 'YYYY-MM-DD HH24:MI:SS'), null, default, 'N', default);
insert into BOARD_IMG values (SEQ_IMG_NO.NEXTVAL, 4004, '/resources/images/scheduling/', 'gpt.jpg', 'gpt.jpg', 0);
insert into CLASS_SCHEDULE values(4004, TO_DATE('2024-11-01', 'YYYY-MM-DD'), TO_DATE('2024-11-05', 'YYYY-MM-DD') ,  TO_DATE('2024-09-19', 'YYYY-MM-DD') ,  TO_DATE('2024-09-24', 'YYYY-MM-DD') , 2);

--6. AI
insert into BOARD values(4005, 5, 12, '인공지능 기술 윤리 교육', '■ 교육개요<br><br>ㅇ 교 육 명 : 인공지능 기술 윤리 교육<br><br>ㅇ 교육일정 : 2023. 10. 23.(월) 14:00~16:00<br><br>ㅇ 교육방법 : Zoom을 활용한 실시간 온라인 교육<br><br>ㅇ 교 육 비 : 무료<br><br>ㅇ 교육내용 : 인간과 AI의 공존을 위한 윤리와 대응<br><br> <br><br>■ 모집안내<br><br>ㅇ 모집대상 : 도서관 이용자(만 16세 이상)<br><br>ㅇ 모집인원 : 200명(선착순)<br><br>ㅇ 모집기간 : 2023. 10. 4.(수) ~ 10. 16.(월)<br><br>ㅇ 지원방법 : 신청서 온라인 작성 및 제출 ☞신청 바로가기<br><br>ㅇ 결과발표 : 2023. 10. 18.(수) (개별 연락)<br><br> <br><br>■ 유의사항<br><br>ㅇ 프로그램 참여 시 교육 일정에 필수적으로 참여 가능하신 분만 지원 바랍니다. <br><br> <br><br>■ 문의처<br><br>ㅇ 디지털정보활용교육 담당자<br><br>- 전 화 : 010-5187-9181<br><br><br><br>- 이메일 : hjkim@imcapsule.com', TO_DATE('2024-09-23 12:06:37', 'YYYY-MM-DD HH24:MI:SS'), null, default, 'N', default);
insert into BOARD_IMG values (SEQ_IMG_NO.NEXTVAL, 4005, '/resources/images/scheduling/', 'AI.jpg', 'AI.jpg', 0);
insert into CLASS_SCHEDULE values(4005, TO_DATE('2024-11-10', 'YYYY-MM-DD'), TO_DATE('2024-11-15', 'YYYY-MM-DD') ,  TO_DATE('2024-09-19', 'YYYY-MM-DD') ,  TO_DATE('2024-09-24', 'YYYY-MM-DD') , 2);

--7. text
insert into BOARD values(4006, 5, 12, '연구자를 위한 텍스트 마이닝','<br>국립중앙도서관 연구정보실은 텍스트 마이닝 기본 개념 이해 및 실습 과정인 ''연구자를 위한 텍스트 마이닝 활용'' 교육을 운영합니다.<br><br>텍스트 데이터 분석 역량을 강화하여 연구에 새로운 시사점을 얻고자 하는 분들의 많은 지원 바랍니다.<br><br>■ 교육개요<br><br>ㅇ 교육일시 : (입문 2기) 7.26.(수)~7.28.(금) 14:00~17:00 / 총 3회 9시간<br><br>※입문 1기와 2기는 동일 과정임<br><br>ㅇ 교육대상 : 국립중앙도서관 회원 각 30명(선착순, 연구정보실 회원 우선 선발)<br><br>ㅇ 교육방법 : 대면실습교육<br><br>ㅇ 교육장소 : 디지털도서관 B2 문화소강당<br><br>ㅇ 교 육 비 : 무료<br><br>ㅇ 교육내용 : 포스터 참고<br><br>■ 신청안내 : 7월 3일 오전 10시부터 신청 가능<br><br>ㅇ 신청방법 : 신청서 온라인 작성 (7월 3일 10시 게시글 왼쪽 하단 ''신청서 작성'' 버튼 생성)<br><br>ㅇ 모집기간 : 7. 3.(월) 10:00 ~ 7. 10.(월) 18:00 *조기마감될 수 있습니다.<br><br> *입문 1, 2기 동시모집<br><br> -입문 1, 2기는 동일 과정이므로, 중복 신청 불가<br><br> -신청 후 기수 변경 불가<br><br>ㅇ 교육대상자 발표 : 7. 12.(수) (개별 연락)<br><br>■ 유의사항<br><br>ㅇ 교육 신청 후 사전 고지 없이 불참 시, 향후 모집정원 초과 교육 프로그램 선발에서 제외될 수 있습니다.<br><br>ㅇ 전 일정(3차시) 모두 참석이 가능한 분만 신청하여 주시기 바랍니다.<br><br>ㅇ 강의자료 공유 및 배포 등의 행위는 저작권, 초상권 등의 침해 우려가 있으므로 엄격히 금합니다.<br><br>■ 문의처<br><br>ㅇ 디지털정보활용교육 담당자: 010-5187-9181, hjkim@imcapsule.com', TO_DATE('2024-09-23 12:06:38', 'YYYY-MM-DD HH24:MI:SS'),  null, default, 'N', default);
insert into BOARD_IMG values (SEQ_IMG_NO.NEXTVAL, 4006, '/resources/images/scheduling/', 'text.jpg', 'text.jpg', 0);
insert into CLASS_SCHEDULE values(4006, TO_DATE('2024-11-10', 'YYYY-MM-DD'), TO_DATE('2024-11-15', 'YYYY-MM-DD') ,  TO_DATE('2024-09-20', 'YYYY-MM-DD') ,  TO_DATE('2024-09-30', 'YYYY-MM-DD') , 2);

--8. Gephi
insert into BOARD values(4007, 5, 12, '디지털 인문학과 연결망 분석: Gephi 실습 교육', '국립중앙도서관 연구정보실에서는 연구자를 위한 "디지털 인문학과 연결망 분석: Gephi 실습" 교육을 실시합니다.<br><br>전통적인 인문학 연구과정에 정보기술을 활용한 데이터 분석 및 설계 방법을 알아보고자 하는 연구자분들의 많은 참여 바랍니다.<br><br>■ 교육개요<br><br>ㅇ 교육명: 디지털 인문학과 연결망 분석: Gephi 실습<br><br>ㅇ 교육일시: 2023. 6. 21.(수)~6. 23.(금) 14:00~17:00 (총 3차시/9시간)<br><br>ㅇ 교육대상: 국립중앙도서관 회원 30명(연구정보실 회원 우선 선발)<br><br>ㅇ 교육방법: 대면실습교육<br><br>ㅇ 교육장소: 디지털도서관 B3 대회의실<br><br>ㅇ 교육비: 무료<br><br>ㅇ 교육내용: 포스터 참고<br><br>■ 신청안내: 6월 5일 오전 10시부터 신청 가능<br><br>ㅇ 신청방법: 신청서 온라인 작성 (6월 5일 10시 게시글 왼쪽 하단 "신청서 작성" 버튼 생성)<br><br>ㅇ 모집기간: 6. 5.(월) 10:00 ~ 6. 12.(월) 18:00 *조기마감될 수 있습니다.<br><br>ㅇ 교육대상자 발표: 6. 14.(수) (개별 연락)<br><br>■ 유의사항<br><br>ㅇ 교육 신청 후 사전 고지 없이 불참 시, 향후 모집정원 초과 교육 프로그램 선발에서 제외될 수 있습니다.<br><br>ㅇ 전 일정 모두 참석이 가능한 분만 신청하여 주시기 바랍니다.<br><br>ㅇ 강의자료 공유 및 배포 등의 행위는 저작권, 초상권 등의 침해 우려가 있으므로 엄격히 금합니다.<br><br>■ 문의처<br><br>ㅇ 디지털정보활용교육 담당자: 010-5187-9181, hjkim@imcapsule.com', TO_DATE('2024-09-23 12:06:38', 'YYYY-MM-DD HH24:MI:SS'), null, default, 'N', default);
insert into BOARD_IMG values (SEQ_IMG_NO.NEXTVAL, 4007, '/resources/images/scheduling/', 'Gephi.jpg', 'Gephi.jpg', 0);
insert into CLASS_SCHEDULE values(4007, TO_DATE('2024-11-10', 'YYYY-MM-DD'), TO_DATE('2024-11-15', 'YYYY-MM-DD') ,  TO_DATE('2024-09-20', 'YYYY-MM-DD') ,  TO_DATE('2024-09-30', 'YYYY-MM-DD') , 2);

--9. increase
insert into BOARD values(4008, 5, 12, '문해력 향상을 위한 미디어 아카데미 교육', '국립중앙도서관과 한국언론진흥재단에서는 미디어 리터러시의 기본적인 이해와 정보 분별 능력 향상을 위한 <br>&lt;문해력 향상을 위한 미디어 아카데미&gt;를 다음과 같이 공동 개최합니다.<br><br>미디어에 대한 비판적 사고 등 문해력 향상에 관심 있는 분들의 많은 참여를 바랍니다.<br><br><br><br><br><br>■ 교육개요<br><br>- 교 육  명: 문해력 향상을 위한 미디어 아카데미<br><br>- 교육일시: 2023. 6. 1.(목) ~ 6. 9.(금) 10:00~12:00 (매주 목/금 4차시, 8시간)<br><br>- 교육대상: 문해력 향상에 관심있는 도서관 이용자(만 16세 이상,) / 선착순 50명<br><br>-  교육방법: 대면교육<br><br>-  교 육 비: 무료<br><br><br><br>■ 신청방법<br><br>- 신청기간: 5. 1.(월) ~ 5. 19.(금)<br><br>- 신청방법: 신청서 온라인 작성 및 제출<br><br>- 모집방법: 기간내 선착순 모집<br><br>- 교육대상자 발표: 5. 24.(수) (개별연락)<br><br><br><br>■ 교육내용<br><br>차시<br><br>일시<br><br>강의주제(안)<br><br>강사진<br><br>1차시<br><br>2023.6.1.(목)<br><br>10:00~12:00<br><br>당신의 “미디어” 문해력<br><br>민 정 홍<br><br>당신의 문해력&gt; PD<br><br>2차시<br><br>2023.6.2.(금)<br><br>10:00~12:00<br><br>디지털 시민성과 미디어 리터러시<br><br>김 아 미<br><br>서울대학교 빅데이터혁신공유대학 연구부 교수<br><br>3차시<br><br>2023.6.8.(목)<br><br>10:00~12:00<br><br>유튜브는 책을 집어삼킬 것인가?<br><br>김 성 우<br><br>응용언어학자<br><br>(제2언어 리터러시 연구자)<br><br>4차시<br><br>2023.6.9.(금)<br><br>10:00~12:00<br><br>AI 시대에 살아남는 힘, 문해력<br><br>정 재 민<br><br>KAIST 문술미래전략대학원 교수<br><br> <br><br>■ 협조사항<br><br>1. 전 차시 일정 모두 참석이 가능하신 분만 신청해주시기 바랍니다.<br><br>2. 전 교육 일정(4차시)에 참석하여 수료한 교육생분들께 수료증을 발급하여 드립니다.<br><br>3. 신청 취소자 발생 시 대기자에게 교육 기회를 드립니다.<br><br>4. 강의 중 강의자료 공유 및 배포, 강의장면 녹화 등의 행위는 저작권, 초상권 등의 침해 우려가 있으므로 엄격히 금합니다.<br><br> <br><br>■ 교육문의<br><br>- 디지털정보활용교육 담당자(010-5187-9181) / hjkim@imcapsule.com<br><br>', TO_DATE('2024-09-23 12:06:40', 'YYYY-MM-DD HH24:MI:SS'), null, default, 'N', default);
insert into BOARD_IMG values (SEQ_IMG_NO.NEXTVAL, 4008, '/resources/images/scheduling/', 'increase.jpg', 'increase.jpg', 0);
insert into CLASS_SCHEDULE values(4008, TO_DATE('2024-11-10', 'YYYY-MM-DD'), TO_DATE('2024-11-15', 'YYYY-MM-DD') ,  TO_DATE('2024-09-23', 'YYYY-MM-DD') ,  TO_DATE('2024-10-01', 'YYYY-MM-DD') , 2);

--10. Rlanguage
INSERT INTO BOARD VALUES (4009, 5, 12, 'R언어 통계활용으로 논문 작성하기(심화) 교육','국립중앙도서관 연구정보실에서는 연구자를 위한 "R언어 통계활용으로 논문작성하기[심화]" 교육을 실시합니다.<br><br>통계 데이터 분석 역량을 심화과정을 통해 강화하고자 하는 연구자분들의 많은 참여 바랍니다.<br><br>(R에 대한 사전지식을 갖춘 연구자를 위한 심화과정이니 확인 후 신청하시기 바랍니다.)<br><br><br><br>■ 교육개요<br><br>ㅇ 교 육 명 : R언어 통계활용으로 논문작성하기[심화]<br><br>ㅇ 교육일시 : 2023. 5. 17.(수)~5. 19.(금) 14:00~17:00 (총 3차시/9시간)<br><br>ㅇ 교육대상 : 국립중앙도서관 회원 30명(연구정보실 회원 우선 선발)<br><br>ㅇ 교육방법 : 대면실습교육<br><br>ㅇ 교육장소 : 디지털도서관 문화소강당<br><br>ㅇ 교 육 비 : 무료<br><br>ㅇ 교육내용 : 포스터 참고<br><br><br><br>■ 신청안내 : 5월 1일 오전 10시부터 신청 가능<br><br>ㅇ 신청방법 : 신청서 온라인 작성 (게시글 왼쪽 하단 ''신청서 작성'' 클릭)<br><br>ㅇ 모집기간 : 5. 1.(월) 10:00 ~ 5. 9.(화) 18:00 *조기마감될 수 있습니다.<br><br>ㅇ 교육대상자 발표 : 5. 10.(수) (개별 연락)<br><br><br><br>■ 유의사항<br><br>ㅇ 교육 신청 후 사전 고지 없이 불참 시, 향후 모집정원 초과 교육 프로그램 선발에서 제외될 수 있습니다.<br><br>ㅇ 전 일정 모두 참석이 가능한 분만 신청하여 주시기 바랍니다.<br><br>ㅇ 강의자료 공유 및 배포 등의 행위는 저작권, 초상권 등의 침해 우려가 있으므로 엄격히 금합니다.', TO_DATE('2024-09-23 12:06:45', 'YYYY-MM-DD HH24:MI:SS'), NULL, DEFAULT, 'N', DEFAULT);
INSERT INTO BOARD_IMG VALUES (SEQ_IMG_NO.NEXTVAL, 4009, '/resources/images/scheduling/', 'Rlanguage.jpg', 'Rlanguage.jpg', 0);
INSERT INTO CLASS_SCHEDULE VALUES (4009, TO_DATE('2024-12-10', 'YYYY-MM-DD'), TO_DATE('2024-12-15', 'YYYY-MM-DD'), TO_DATE('2024-09-30', 'YYYY-MM-DD'), TO_DATE('2024-10-10', 'YYYY-MM-DD'), 2);


COMMIT;