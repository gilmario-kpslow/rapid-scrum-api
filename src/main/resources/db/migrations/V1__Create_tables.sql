create schema scrum;
create table scrum.equipe(
    id serial not null primary key,
    nome varchar(50) unique not null
);

create table scrum.usuario (
    id serial not null primary key,
    nome varchar(40) not null,
    sobrenome varchar(40) not null,
    nome_login varchar(40) not null unique
);

create table scrum.senha (
    id serial not null primary key,
    usuario bigint not null,

    
);




