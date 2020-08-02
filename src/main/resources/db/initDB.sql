DROP TABLE IF EXISTS conversations;
DROP TABLE IF EXISTS currencies;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id              SERIAL                              PRIMARY KEY,
    username        VARCHAR                             NOT NULL,
    password        VARCHAR                             NOT NULL
);

CREATE TABLE currencies
(
    name            VARCHAR                         NOT NULL,
    code            VARCHAR         PRIMARY KEY     NOT NULL,
    value           DOUBLE PRECISION                NOT NULL,
    nominal         INT                             NOT NULL,
    date            TIMESTAMP       DEFAULT now()   NOT NULL
);

CREATE TABLE conversations
(
    id                  SERIAL                      PRIMARY KEY,
    in_currency_code    VARCHAR                     NOT NULL,
    out_currency_code   VARCHAR                     NOT NULL,
    in_value            INT                         NOT NULL,
    out_value           INT                         NOT NULL,
    date                TIMESTAMP   DEFAULT now()   NOT NULL,
    user_id             INT                         NOT NULL,
    CONSTRAINT fk_in_currency_code
        FOREIGN KEY(in_currency_code)
            REFERENCES currencies(code),
    CONSTRAINT fk_out_currency_code
        FOREIGN KEY(out_currency_code)
            REFERENCES currencies(code),
    CONSTRAINT fk_user_id
        FOREIGN KEY(user_id)
            REFERENCES users(id)
);

