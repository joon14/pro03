/* member 생성완료 */
create table member (id varchar2(100) primary key, pw varchar2(2000) not null,
name varchar2(50) not null, tel varchar2(50), email varchar2(100),
addr1 varchar(1000) not null, addr2 varchar2(1000), postcode varchar(2000) not null,
regdate timestamp default sysdate);

select * from member;

drop table member;

/* book 생성완료 */
create table book (no int primary key, name varchar2(100),
genre varchar2(100), author varchar2(100), pub varchar2(100), 
content varchar2(2000), pub_date timestamp default sysdate, price int, 
img1 varchar2(2000), img2 varchar2(2000), img3 varchar2(2000));

create sequence bookseq start with 1 increment by 1 nocycle;

select * from book;

drop table book;

/* basket */
create table basket (no int primary key, name varchar2(100),
buy_amount int, price int, id varchar2(100));

select * from basket;

/* order */
create table order (no int primary key, name varchar2(100),
buy_amount int, price int, id varchar2(100), addr varchar2(2000), 
order_date);

select * from order;

/* sale */
create table sale (no int primary key, name varchar2(100),
buy_amount int, price int, sale_date);

select * from sale;


/* qna */
create table qna(no int primary key, plevel int, 
parno int, title varchar(50) not null, content varchar(2000) not null, 
resdate timestamp default sysdate,
aid varchar(50), foreign key(aid) references member(id));

create sequence qseq start with 1 increment by 1 nocycle;

select * from qna;

drop table qna;

/* notice 생성완료 + id 추가해야함 */
create table notice(no int primary key, 
title varchar(100) not null,
content varchar(1000) not null, resdate timestamp default sysdate, 
visited int default 0);

create sequence nseq start with 1 increment by 1 nocycle;

select * from notice;

delete from notice where no=3;

insert into notice values (nseq.nextval, '공지사항 테스트1', '테스트1', default, default);

drop table notice;

commit;