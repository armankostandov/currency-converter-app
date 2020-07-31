DROP TABLE IF EXISTS currencies;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS conversations;

CREATE TABLE currencies
(
    id              SERIAL                              PRIMARY KEY,
    name            VARCHAR                             NOT NULL,
    code            VARCHAR                             NOT NULL,
    value           DOUBLE PRECISION                    NOT NULL,
    nominal         INT                                 NOT NULL,
    date            TIMESTAMP           DEFAULT now()   NOT NULL
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

CREATE TABLE conversations
(
    id              SERIAL                              PRIMARY KEY,
    in_currency_id  INT                                 NOT NULL,
    out_currency_id INT                                 NOT NULL,
    in_value        INT                                 NOT NULL,
    out_value       INT                                 NOT NULL,
    date            TIMESTAMP           DEFAULT now()   NOT NULL,
    user_id         INT                                 NOT NULL,
    CONSTRAINT fk_in_currency_id
        FOREIGN KEY(in_currency_id)
            REFERENCES currencies(id),
    CONSTRAINT fk_out_currency_id
        FOREIGN KEY(out_currency_id)
            REFERENCES currencies(id),
    CONSTRAINT fk_user_id
        FOREIGN KEY(user_id)
            REFERENCES users(id)
);

