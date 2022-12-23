create database bookstoredb;
use bookstoredb;

create table `book` (
	`bookid` int not null,
    `bookname` varchar(45) not null,
    `publisher` varchar(45) not null,
    `price` int not null,
    primary key (`bookname`)
);

create table `customer` (
	`custid` int not null,
    `name` varchar(45) not null,
    `address` varchar(45) not null,
    `phone` varchar(45) not null,
    primary key (`custid`)
);

create table `order` (
	`orderid` int not null,
    `custid` int not null,
    `bookid` int not null,
    `saleprice` int not null,
    `orderdate` date not null,
    primary key (`orderid`)
);

insert into book values(1, '자바', '굿프로그래밍', 23000);
insert into book values(2, 'C언어', '컴퓨터의신', 11000);
insert into book values(3, '파이썬', '그레이트코딩', 22000);

insert into customer values(1, '홍길동', '서울특별시', '010-1234-5678');
insert into customer values(2, '심청이', '인천광역시', '010-1122-3344');
insert into customer values(3, '이슬이', '경기도 성남시', '010-3455-6788');

insert into `order` values(1, 2, 1, 23000, '2022-03-14');
insert into `order` values(2, 3, 2, 11000, '2022-04-24');
insert into `order` values(3, 1, 3, 22000, '2022-05-31');