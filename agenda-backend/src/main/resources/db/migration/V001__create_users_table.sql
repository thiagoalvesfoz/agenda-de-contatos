CREATE TABLE users (
    id_user BIGSERIAL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(250) NOT NULL,
            
    PRIMARY KEY(id_user)
);
