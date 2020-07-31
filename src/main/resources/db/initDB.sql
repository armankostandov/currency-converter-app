DROP TABLE IF EXISTS currencies;

CREATE TABLE currencies
(
    id               SERIAL                            PRIMARY KEY,
    name             VARCHAR                           NOT NULL,
    code             VARCHAR                           NOT NULL,
    value            DOUBLE PRECISION                  NOT NULL,
    nominal          INT                               NOT NULL,
    date             TIMESTAMP           DEFAULT now() NOT NULL
);

