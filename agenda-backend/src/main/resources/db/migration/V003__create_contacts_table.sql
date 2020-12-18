CREATE TABLE contacts (
    id_contact BIGSERIAL,
    name VARCHAR(45) NOT NULL,
    id_user BIGINT NOT NULL,
            
    PRIMARY KEY(id_contact),
    FOREIGN KEY (id_user) REFERENCES users (id_user) ON DELETE
    CASCADE ON UPDATE CASCADE
);
