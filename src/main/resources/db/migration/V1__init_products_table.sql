drop table if exists products;
create table products(
    id int primary key auto_increment,
    name varchar(100) not null,
    description varchar(1000),
    picture_path varchar(150)
)

