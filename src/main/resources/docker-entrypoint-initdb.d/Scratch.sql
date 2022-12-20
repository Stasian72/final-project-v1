drop database final_db;
drop table books;
drop table owners;
create database final_db;
create table books (
                          id serial primary key,
                          name varchar(255)  ,
                          author varchar(255) ,
                          iban INTEGER ,
                   owner varchar(255)

);

insert into books (name, author, iban, owner)
VALUES ('Война и мир', 'Толстой', 1111111, 'Стас'),
       ('Мертвые души', 'Гоголь', 2222222, 'Карен'),
       ('Конституция РФ', 'Народ', 333333333, 'Ольга');

create table owners (
                        id serial primary key,
                        owner_name varchar(255)  ,
                        email varchar(255)  ,
                        password varchar(255)
);
insert into owners(owner_name, email, password)
VALUES ('Стас','stas@alex.com', '0906'),
       ('Карен', 'karen@inbox.com', '123'),
       ('Ольга', 'olga@woman.com', '456');

select * from books;
