create table trabalhador (
    id bigint primary key auto_increment,
    nome varchar(255) not null,
    cpf varchar(11) not null unique,
    email varchar(255) not null,
    telefone varchar(20) not null,
    nascimento date not null,
    avaliacao double default 0.0,
    total_de_trabalhos int default 0,
    rua varchar(250) not null,
    numero varchar(10) not null,
    bairro varchar(250) not null,
    cidade varchar(250) not null,
    cep varchar(8) not null,
    uf varchar(2) not null,
    pais varchar(100) not null,
    status varchar(10) not null,

);