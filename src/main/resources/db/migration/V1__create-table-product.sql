create table product (
id varchar(10) not null unique,
name varchar(100),
price_in_cents int(10) not null,
primary key(id));