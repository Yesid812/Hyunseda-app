DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
                        client_id BIGINT NOT NULL,
                        username VARCHAR(255),
                        email VARCHAR(255),
                        password VARCHAR(255),
                        CONSTRAINT pk_client PRIMARY KEY (client_id)
);
