create table empresa(

    id bigint auto_increment,
    nome varchar(250) not null,
    cnpj varchar(14) not null unique,
    email varchar(100) not null unique,
    telefone varchar(15) not null,
    rua varchar(250) not null,
    numero varchar(10) not null,
    bairro varchar(250) not null,
    cidade varchar(250) not null,
    cep varchar(8) not null,
    uf varchar(2) not null,
    pais varchar(100) not null,
    status varchar(10) not null,

    primary key (id)



);