create table usuario(
    id bigint not null auto_increment,
    login varchar(100) not null unique,
    password varchar(100) not null,

    primary key(id)

);
alter table empresa add column usuario_id bigint not null unique;

alter table empresa add constraint fk_empresa_usuario
foreign key (usuario_id) references usuario(id);


