SELECT * FROM telefone_user as fone 
INNER JOIN tb_user as userp 
on fone.user_id = userp.id;