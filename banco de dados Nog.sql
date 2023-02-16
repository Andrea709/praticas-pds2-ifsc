create database nog;


create table Pessoa (
	cpf int not null primary key,
    nome varchar(50)
);

insert into pessoa(cpf, nome) values (123, 'Nog');