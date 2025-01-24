use mydb;
create table person(
id int PRIMARY KEY AUTO_INCREMENT,
first_name varchar(20),
last_name varchar(20),
age int,
license_id int,
FOREIGN KEY (license_id)
REFERENCES license(id)	
);

create table license(
id int PRIMARY KEY AUTO_INCREMENT,
type varchar(20),
valid_from date,
valid_to date
);


select * from person;

select * from license;