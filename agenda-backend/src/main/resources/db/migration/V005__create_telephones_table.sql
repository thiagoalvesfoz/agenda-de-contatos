CREATE TABLE telephones (
    id_telephone BIGSERIAL,
    telephone VARCHAR(45) NOT NULL,
    id_contact BIGINT NOT NULL,
    id_telephoneType BIGINT NOT NULL,
    
            
    PRIMARY KEY(id_telephone),
    FOREIGN KEY (id_contact) REFERENCES contacts (id_contact),
    FOREIGN KEY (id_telephoneType) REFERENCES telephone_types (id_telephoneType)
);

