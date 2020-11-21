create table admins(
id int identity not null,
username varchar(20),
password varchar(20));
insert into admins values('zs','123456');
select* from admins;

create table goods(
id int identity not null,
name varchar(20), 
cover varchar(20), 
image1 varchar(20), 
image2 varchar(20), 
price int, 
intro varchar(20), 
stock int, 
type_id int);
select* from goods;
select * from goods where name like '%'+'a'+'%' order by id asc;

create table items(
id int identity not null, 
price int,
amount int, 
order_id int,
good_id int);
select* from items;

create table orders(
id int identity not null,
user_id int,
user_name varchar(20),
good_id int,
good_name varchar(20), 
price int,
amount int,
paytype varchar(20),
phone varchar(20),
address varchar(20),
systime varchar(20));

create table users(
id int identity not null,
username varchar(20),
password varchar(20),
name varchar(20),
phone varchar(20),
address varchar(20));
select* from users;