create table telefone_user(
	id bigint not null, 
    numero varchar(15) not null,
    tipo varchar(30) not null, 
    user_id bigint not null, 
    constraint telefone_id primary key(id));