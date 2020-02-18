CREATE SCHEMA hes;
USE hes;

CREATE TABLE user_account
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY ,
    user_name   VARCHAR(255) NOT NULL UNIQUE ,
    password    VARCHAR(255) NOT NULL ,
    first_name  VARCHAR(255) NOT NULL ,
    last_name   VARCHAR(255) NOT NULL ,
    role        VARCHAR(16) NOT NULL ,
    status      VARCHAR(16) NOT NULL ,
    created_at  TIMESTAMP NOT NULL

);



