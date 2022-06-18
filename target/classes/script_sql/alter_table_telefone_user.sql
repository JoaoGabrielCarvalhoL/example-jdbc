alter table telefone_user add foreign key (user_id) references tb_user(id); 

ALTER TABLE telefone_user 
MODIFY id bigint not null auto_increment unique;