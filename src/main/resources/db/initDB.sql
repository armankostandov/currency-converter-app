DROP TABLE IF EXISTS currencies;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;

CREATE TABLE currencies
(
    id               SERIAL                            PRIMARY KEY,
    name             VARCHAR                           NOT NULL,
    code             VARCHAR                           NOT NULL,
    value            DOUBLE PRECISION                  NOT NULL,
    nominal          INT                               NOT NULL,
    date             TIMESTAMP           DEFAULT now() NOT NULL
);

CREATE TABLE roles
(
    id              SERIAL                              PRIMARY KEY,
    name            VARCHAR                             NOT NULL
);

CREATE TABLE users
(
    id              SERIAL                              PRIMARY KEY,
    username        VARCHAR                             NOT NULL,
    password        VARCHAR                             NOT NULL
);