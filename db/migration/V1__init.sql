create table categories
(
    id bigserial primary key,
    title varchar(255)
);
insert into categories (title)
values ('Trainee');

create table students
(
    id bigserial primary key,
    name       varchar(255),
    age       int,
    category_id bigint references categories (id)
);
-- insert into products (title, price, category_id)
insert into students (name, age, category_id)

values ('Steve', 21, 1),
       ('Bob', 20, 1),
       ('John', 23, 1),
       ('Peter', 19, 1),
       ('David', 18, 1),
       ('Oliver', 24, 1),
       ('Jonathan', 21, 1),
       ('Stuart', 22, 1),
       ('Nancy', 21, 1),
       ('Helen', 20, 1),
       ('Angela', 18, 1),
       ('Sara', 24, 1),
       ('William', 19, 1),
       ('James', 23, 1),
       ('Benjamin', 22, 1),
       ('Lucas', 24, 1),
       ('Elvis', 21, 1),
       ('Adrian', 22, 1),
       ('Jeffrey', 24, 1),
       ('Brandon', 22, 1),
       ('Dale', 19, 1);

