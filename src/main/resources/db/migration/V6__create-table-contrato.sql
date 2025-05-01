create table contrato(

    id bigint auto_increment not null primary key,
    descricao text,
    valor double not null,
    status_contrato varchar(12) not null,
    data_inicio date not null,
    data_fim date not null,

    empresa_id bigint not null,
    trabalhador_id bigint,

    constraint fk_contrato_empresa foreign key (empresa_id) references empresa(id),
    constraint fk_contrato_trabalhador foreign key (trabalhador_id) references trabalhador(id)
);