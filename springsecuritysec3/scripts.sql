create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

INSERT IGNORE INTO `users` VALUES('rishabh','{noop}rishabh12345','1');
INSERT IGNORE INTO `authorities` VALUES('rishabh','read');

INSERT IGNORE INTO `users` VALUES('mohit','{bcrypt}$2a$12$2acCjdotaMutD6R4kf9xfevlrFWsCkW9jaWRHP2urwFW2KOKqgUY2','1');
INSERT IGNORE INTO `authorities` VALUES('mohit','admin');

INSERT IGNORE INTO `users` VALUES('rohan','{noop}rohan@11#2000','1');
INSERT IGNORE INTO `authorities` VALUES('rohan','read');

INSERT IGNORE INTO `users` VALUES('mohan','{bcrypt}$2a$12$xSbMmVgTe8eMp7ZsFpGXLuCExGHIh1T/3EeSdk/hEsXIcGE/.5QcC','1'); -- mohan@11#2000
INSERT IGNORE INTO `authorities` VALUES('mohan','read');

select * from users limit 10;
select * from authorities limit 10;

create table customer(
    id int NOT NULL AUTO_INCREMENT,
    email varchar(45) NOT NULL,
    pwd varchar(200) NOT NULL,
    role varchar(20) NOT NULL,
    PRIMARY KEY(id)
);

select * from customer limit 10;

insert into customer(email,pwd,role) values('rishabh@example.com','{noop}rishabh@01#2000','admin');
insert into customer(email,pwd,role) values('ajay@example.com','{bcrypt}$2a$12$wl46PXblkgkiF9TMRv5o7uDzepozJweGgtoruN1lf1egpuJLvrmce','user'); -- ajay@01#2000