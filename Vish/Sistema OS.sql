/**
* Sistema para gestão de OS 
* @autor Thaina Minga
*/
show databases;
create database dbsistema;
use dbsistema;
show tables;

-- unique (não permite valores iguais no campo)
create table usuarios(
id int primary key auto_increment,
nome varchar(50) not null,
login varchar(15)not null unique,
senha varchar(250)not null

);
describe usuarios;
drop table usuarios;

-- busca avancada (estilo google)
select * from usuarios where nome like 't%' order by nome;

-- uso do md5() para criptografar uma senha
insert into usuarios (nome,login,senha)
values ('ludo','lud',('123'));

delete from usuarios where id =1;

select* from usuarios where login ="thaithai";
select * from usuarios;
describe usuarios;

insert into usuarios (nome,login,senha)
values ('Administrador','Admon',md5('admin'));

-- login(autenticacao)
select * from usuarios;
select * from usuarios where nome ="Administrador";
select * from usuarios where login ="Admon";

select * from usuarios where login ='Admon' and senha = md5('admin');

create table clientes(
idcli int primary key auto_increment,
nome varchar(50) not null,
rg varchar(9)not null unique,
cpf varchar(11)not null unique,
fone varchar(15)not null,
cidade varchar(30)not null,
endereco varchar(150)not null,
bairro varchar(30)not null,
cep varchar(10),
numero varchar(10)not null,
complemento varchar(20),
uf char(2),
email varchar(100)
);

insert into clientes (nome,rg,cpf,fone,cidade,endereco,bairro,cep,numero,complemento,uf,email)
values ('thaina','111','111','111','sao paulo','endereco','bairro','111','111','complemento','sp','email');

drop table clientes;
select * from clientes;

/* Relacionsmento de tabelas 1 - N */
-- timestamp default 
--
--
--
create table servicos(
os int primary key auto_increment,
dataOS timestamp default current_timestamp,
equipamento varchar(200) not null,
defeito varchar(200) not null,
valor decimal(10,2),
idcli int not null,
foreign key (idcli) references clientes(idcli)
);

insert into servicos (equipamento, defeito, valor,idcli)
values ('Notebook LeNovo G90','Troca de fone',250,1);

select * from servicos
inner join clientes
on servicos.idcli= clientes.idcli;

 -- (nome,rg,cpf,fone,cidade,endereco,bairro,numero) (os,dataOS,equipamento,defeito,valor,idcli)
 
