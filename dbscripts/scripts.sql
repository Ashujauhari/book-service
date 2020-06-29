CREATE database IF NOT EXISTS  books_database;
use books_database;

create table if not exists  book (id int, title varchar(255), author varchar(255), price double);

insert into book values(1,"The Power of Positive Thinking", "Norman Vincent Peale", 668);
insert into book values(2,"The 5 Second Rule", "Mel Robbins", 410);

