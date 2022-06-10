CREATE TABLE `user`
(
    id        int         NOT NULL AUTO_INCREMENT primary key,
    name      varchar(255) NOT NULL,
    surname   varchar(255) not null,
    birthdate DATETIME     NOT NULL,
    role      int          NOT NULL,
    email     varchar(255) not null,
    password  varchar(255) not null,
    telephone varchar(255) not null
);