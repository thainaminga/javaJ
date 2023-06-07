/**
* Agenda de contatos
* @autor Thaina Jamile Minga Santos
*/

-- comentários em linha
-- exibir os bancos
show databases;

-- apagar um banco de dados
drop database dbagenda;

-- criar banco de dados
create database dbagenda;

-- selecionar o banco de dados a ser trabalhado
use dbagenda;

-- exibir tabelas do banco de dados
show tables;

-- criando uma tabela no banco de dados
-- int (tipos de dados: número inteiro)
-- primary key (chave primária)
-- auto_increment (numeração automática)
-- varchar (tipos de dados string)
-- not null (campo obrigatório)

create table contatos(
id int primary key auto_increment,
nome varchar(50) not null,
fone varchar(15)not null,
email varchar(50)

);

-- descrever a tabelas 
describe contatos;

-- selecionar todo da tabela
select * from contatos;
-- CRUD CREATE--------------------------------------------------------------------------------------------------------------------------------------------

insert into contatos (nome,fone,email)
values ('Thaina','99999-9999','thaina@email.com');

insert into contatos (nome,fone)
values ('Bill Gates','99999-1111');

insert into contatos (nome,fone)
values ('Thainara','99999-1234');

insert into contatos (nome,fone,email)
values ('Poliana','99999-2222','poli@email.com');

insert into contatos (nome,fone,email)
values ('Maisa','99999-3333','maisa@email.com');

insert into contatos (nome,fone)
values ('Maria','99999-4444');

insert into contatos (nome,fone)
values ('Luana','99999-1234');

insert into contatos (nome,fone,email)
values ('Luara','99999-1234','lulu@email.com');

-- simulando um erro 

insert into contatos (nome,email)
values ('Bill Gates','123@email.com');

-- CRUD Read------------------------------------------------------------------------------------------------------------------------------------------
-- selecionar tudo da tabela
select * from contatos;

-- selecionar tudo da tabela
select * from contatos order by nome;
select * from contatos order by nome desc;

-- Pesquisas avançadas
select nome from contatos;
select nome,email from contatos;
select * from contatos where nome like 'th%';
select * from contatos where nome = 'Thainara';
select * from contatos where id = 1;

-- relatorios personalizados com apelidos para os campos 
select nome as Contato, fone as Telefone, email as Email from contatos order by nome;
 

-- CRUD Update--------------------------------------------------------------------------------------------------------------------------------------
-- CUIDADO !!! (Sempre usar a claúsula where junto a chave primária)
-- funciona no CMD
-- colocar sempre o número do user
update contatos set fone = '99999-1234' where id =1;
update contatos set fone = '9999-1234' where nome = 'Thaina';
update contatos set fone = '99999-1234' ,email ='bill@email.com'where id =2;
update contatos set nome = 'Willian Gates',fone = '50 909001234',email = 'gates@email.com' where id =2;
update contatos set nome = 'Lara Croft',fone = '99999-1234' where id =12;
update contatos set nome = 'Lara Croft',email = 'croft@email.com' where id =12;
update contatos set nome = 'On',fone = '90 1011110',email = '11@email.com' where id =8;
update contatos set nome ='Lodovico' where id =14;

-- CRUD Delete ----------------------------------------------------------------------------------------------------------------------------------------------
-- CUIDADO !!! (Sempre usar a claúsula where junto a chave primária)
delete from contatos where id =3;

insert into contatos (nome, fone, email)
values ('lodovoco','11 11111-111','lodo@email.com');

-- Alterações na estrutura da tabela
 
-- adicionar uma coluna a tabela
alter table contatos add column obs varchar(100);

-- adicionar uma coluna apos um local especifico
alter table contatos add column fone2 varchar(15)not null after fone ;

-- alterando tipo de dados uo validações
-- ATENÇÃO aos dados já cadastrados!
alter table contatos modify fone2 varchar(20);

-- Exclir uma coluna
alter table contatos drop column obs;

-- Exclir uma tabela
drop table contatos;

describe contatos;
select * from contatos; 
