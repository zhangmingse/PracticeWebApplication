create database testdatabase1;

create table testtable1(
	testid INT NOT NULL AUTO_INCREMENT,
	testtitle varchar(100) NOT NULL,
	testcontent varchar(400) NOT NULL,
	testauthor varchar(40) NOT NULL,
	primary key(testid)
);




insert into testtable1(testtitle,testcontent,testauthor) 
values("trump regard african people as shithole","just as the title said","press");

insert into testtable1(testtitle,testcontent,testauthor) 
values("Jane give birth","A couple of beautifual twins","press");

select * from testtable1;


create table user_table(
	userid INT NOT NULL AUTO_INCREMENT,
	username varchar(50) NOT NULL,
	userpass varchar(100) NOT NULL,
	primary key(userid)
);

insert into user_table(username,userpass) 
values("Trump","fakenews");
insert into user_table(username,userpass) 
values("Obama","blackpeople");
insert into user_table(username,userpass) 
values("Tonny","ironman");

create table online_info(
	online_info_id INT NOT NULL AUTO_INCREMENT,
	sessionid varchar(50) NOT NULL,
	username varchar(50) NOT NULL,
	ip varchar(50) NOT NULL,
	page varchar(50) NOT NULL,
	u_timestamp varchar(50) NOT NULL,
	primary key(online_info_id)
);


create user 'testuser1'@'127.0.0.1' IDENTIFIED BY 'mysqlPASSWORD()110';

grant select,insert,update,delete on testdatabase1.testtable1 to 'testuser1'@'127.0.0.1';