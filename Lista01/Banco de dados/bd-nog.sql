
create database nog;
use nog;

CREATE TABLE sapinhos (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO sapinhos (nome, especie) VALUES ('Cacau', 'Incilius alvarius');