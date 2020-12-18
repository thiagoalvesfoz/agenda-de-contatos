CREATE TABLE emails (
    id_email BIGSERIAL,
    email VARCHAR(45) NOT NULL,
    id_contact BIGINT NOT NULL,
            
    PRIMARY KEY(id_email),
    FOREIGN KEY (id_contact) REFERENCES contacts (id_contact)
);

