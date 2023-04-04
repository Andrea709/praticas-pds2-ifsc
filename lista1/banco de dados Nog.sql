drop database nog;

create database if not exists nog;

use nog;

create table if not exists Pessoa (
	cpf int not null primary key,
    nome varchar(50)
);

insert into pessoa(cpf, nome) values (123, 'Nog');