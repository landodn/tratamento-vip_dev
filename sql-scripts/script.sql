--tipo usuario
INSERT INTO  tipo_usuario(id_tipo_usuario,descricao) VALUES (nextval('tipousuario_sequence'),'CLIENTE');
INSERT INTO  tipo_usuario(id_tipo_usuario,descricao) VALUES (nextval('tipousuario_sequence'),'PROFISSIONAL');
INSERT INTO  tipo_usuario(id_tipo_usuario,descricao) VALUES (nextval('tipousuario_sequence'),'SALÃO'); 
INSERT INTO  tipo_usuario(id_tipo_usuario,descricao) VALUES (nextval('tipousuario_sequence'),'ADMIN');

--tipo endereco
INSERT INTO  tipo_endereco(id_tipo_endereco,descricao) VALUES (nextval('tipoendereco_sequence'),'RESIDENCIAL');
INSERT INTO  tipo_endereco(id_tipo_endereco,descricao) VALUES (nextval('tipoendereco_sequence'),'COMERCIAL');
INSERT INTO  tipo_endereco(id_tipo_endereco,descricao) VALUES (nextval('tipoendereco_sequence'),'OUTROS'); 

--tipo telefone
INSERT INTO  tipo_telefone(id_tipo_telefone,descricao) VALUES (nextval('tipotelefone_sequence'),'RESIDENCIAL');
INSERT INTO  tipo_telefone(id_tipo_telefone,descricao) VALUES (nextval('tipotelefone_sequence'),'COMERCIAL');
INSERT INTO  tipo_telefone(id_tipo_telefone,descricao) VALUES (nextval('tipotelefone_sequence'),'CELULAR');
INSERT INTO  tipo_telefone(id_tipo_telefone,descricao) VALUES (nextval('tipotelefone_sequence'),'FAX');

--UF
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'AC', 'Acre', 'Rio Branco');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'AL', 'Alagoas', 'Maceió');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'AM', 'Amazonas', 'Manaus');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'AP', 'Amapá', 'Macapá');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'BA', 'Bahia', 'Salvador');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'CE', 'Ceará', 'Fortaleza');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'DF', 'Distrito Federal', 'Brasília');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'ES', 'Espírito Santo', 'Vitória');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'GO', 'Goiás', 'Goiânia');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'MA', 'Maranhão', 'São Luís');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'MG', 'Minas Gerais', 'Belo Horizonte');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'MS', 'Mato Grosso do Sul', 'Campo Grande');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'MT', 'Mato Grosso', 'Cuiabá');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'PA', 'Pará', 'Belém');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'PB', 'Paraíba', 'João Pessoa');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'PE', 'Pernambuco', 'Recife');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'PI', 'Piauí', 'Teresina');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'PR', 'Paraná', 'Curitiba');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'RJ', 'Rio de Janeiro', 'Rio de Janeiro');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'RN', 'Rio Grande do Norte', 'Natal');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'RO', 'Rondônia', 'Porto Velho');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'RS', 'Rio Grande do Sul', 'Porto Alegre');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'RR', 'Roraima', 'Boa Vista');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'SC', 'Santa Catarina', 'Florianópolis');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'SE', 'Sergipe', 'Aracaju');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'SP', 'São Paulo', 'São Paulo');
insert into uf (id_uf, sigla, nome, capital) values(nextval('uf_sequence'), 'TO', 'Tocantins', 'Palmas');

--Especialidades
insert into especialidade values (nextval('especialidade_sequence'), 'Manicure', '01:00');
insert into especialidade values (nextval('especialidade_sequence'), 'Cabelereiro', '01:00');
insert into especialidade values (nextval('especialidade_sequence'), 'Pedicure', '01:00');

--Usuario ADMIN
INSERT INTO usuario(id, data_cadastro, login_email, senha, id_tipo_usuario)
    VALUES (nextval('usuario_sequence'),now(), 'admin@tratamentovip.com.br', 'root', 1); 
    
-- endereco 
insert into endereco ( 
  id_endereco, 
  bairro, 
  cep, 
  cidade, 
  complemento, 
  logradouro, 
  latitude, 
  longitude, 
  numero, 
  regiao, 
  id_tipo_endereco, 
  id_uf )
values (nextval('endereco_sequence'),'bairro','cep','cidade','complemento','logradouro',111,111,222,'regiao',1,1)

insert into telefone(id_telefone,ddd,numero,id_tipo_telefone)
values (nextval('telefone_sequence'),11,99999999,1) 
--salao
-- primeiro add um usuario para ser o salao e acertar o id de acordo com o inserido
insert into salao_beleza ( 
  cpf_cnpj, 
  facebook, 
  horario_abertura, 
  horario_fechamento, 
  nome_fantasia, 
  razao_social, 
  id, 
  id_endereco,
  web_site)
values ('123456','face',now(),now(),'teste','teste',1,1 ,'www.tratamentovip.com.br'  )

--especialidade salao
-- id do salao x id da especialidade
insert into especialidade_salao
  ( id, 
    id_especialidade )
values (1,1)

INSERT INTO salao_beleza_telefone(
            id, id_telefone)
    VALUES (1, 1);
