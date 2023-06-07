/**
* Sistema para gestão de OS 
* @autor Thaina Minga
*/
show databases;
create database dbrelojoaria;
use dbrelojoaria;

show tables;
create table clientes(

id int primary key auto_increment,
nome varchar(50) not null,
senha varchar(250) not null,
email varchar(50),
cpf varchar(11) not null,
bijuteria varchar(100) not null,
marca varchar(50)

);
describe clientes;
drop table clientes;

insert into clientes (nome,cpf,email,bijuteria,marca,senha)
values ('thaina','thaithai','vish123@senac.com', 'vish123@senac.com','Relogio','Queen',md5('123@senac'));

select * from clientes;
describe clientes;