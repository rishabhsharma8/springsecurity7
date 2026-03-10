create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

INSERT IGNORE INTO `users` VALUES('rishabh','{noop}rishabh12345','1');
INSERT IGNORE INTO `authorities` VALUES('rishabh','read');

INSERT IGNORE INTO `users` VALUES('mohit','{bcrypt}$2a$12$2acCjdotaMutD6R4kf9xfevlrFWsCkW9jaWRHP2urwFW2KOKqgUY2','1');
INSERT IGNORE INTO `authorities` VALUES('mohit','admin');