DROP TABLE IF EXISTS todoitem;
create table todoitem (id integer not null identity,
 title varchar(255),
 description varchar(255),
 isDone bit, 
 targetDate date, primary key (id)
);
