create table Todo(todoId int(11) primary key auto_increment,title varchar(150),description text,
isCompleted tinyint(1) default 0,scheduledAt datetime, createdDateTime timestamp default current_timestamp,
completedOn datetime,isdeleted tinyint(1) default 0);