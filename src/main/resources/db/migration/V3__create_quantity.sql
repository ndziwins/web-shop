drop table if exists quantity;
create table quantity(
    id int primary key auto_increment,
    quantity int
);

alter table products add column quantity_id int;
alter table products add foreign key (quantity_id) references quantity (id);