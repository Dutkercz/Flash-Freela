alter table trabalhador add column usuario_id bigint not null unique;

alter table trabalhador add constraint fk_trabalhador_usuario
foreign key (usuario_id) references usuario(id);