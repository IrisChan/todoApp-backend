DROP TABLE IF EXISTS todoitem;
create table todoitem (id integer not null auto_increment,
 description varchar(255),
 owner varchar(255),
 isDone bit, primary key (id)
);


######
#DROP TABLE IF EXISTS todoitem;
#create table todoitem (id int not null identity,
# description varchar(255),
# owner varchar(255),
# isDone bit, primary key (id)
#);
###