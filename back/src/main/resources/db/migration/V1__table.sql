CREATE TABLE IF NOT EXISTS roles
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id BIGINT NOT NULL,
    state BOOLEAN NOT NULL Default true,
    date DATE NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles(id);

CREATE TABLE IF NOT EXISTS health_units
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    city VARCHAR(120) NOT NULL,
    name VARCHAR(120) NOT NULL,
    neighborhood VARCHAR(120) NOT NULL,
    street VARCHAR(120) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS adms
(
    id BIGINT AUTO_INCREMENT  NOT NULl,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE adms ADD CONSTRAINT fk_adm_id  FOREIGN KEY ( user_id ) REFERENCES users(id);

CREATE TABLE IF NOT EXISTS doctors
( 
    id BIGINT AUTO_INCREMENT NOT NULl,
    specialty VARCHAR(64) NOT NULL,
    crm VARCHAR(20) NOT NULL,
    user_id BIGINT NOT NULL,
    health_unit_id BIGINT NOT NULL,
    UNIQUE (crm),
    PRIMARY KEY (id) 
);

ALTER TABLE doctors ADD CONSTRAINT fk_unit_id FOREIGN KEY ( health_unit_id ) REFERENCES health_units(id);
ALTER TABLE doctors ADD CONSTRAINT fk_doctor_id  FOREIGN KEY ( user_id ) REFERENCES users(id);

CREATE TABLE IF NOT EXISTS patients
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    user_id BIGINT NULL,
    UNIQUE (cpf),
    PRIMARY KEY (id)
);

ALTER TABLE patients ADD CONSTRAINT fk_patient_id  FOREIGN KEY ( user_id ) REFERENCES users(id);

CREATE TABLE IF NOT EXISTS consultations (
    id BIGINT AUTO_INCREMENT NOT NULL,
    state VARCHAR(64) NOT NULL Default "Ativado",
    description VARCHAR(255) NULL,
    date VARCHAR(20) NOT NULL,
    time VARCHAR(20) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    crm VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

