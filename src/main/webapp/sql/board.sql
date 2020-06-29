create table board(
	seq number(5) primary key,
	title varchar2(200),
	writer varchar2(20),
	content varchar2(2000),
	regdate date default sysdate,
	cnt number(5) default 0
);
create table users(
	id varchar2(8) primary key,
	password varchar2(8),
	name varchar2(20),
	role varchar2(5)
);