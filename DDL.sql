create database condominio;
use condominio;

create user 'adm'@'localhost' identified by 'pass123';
grant select, insert, delete, update on condominio.* to adm@localhost;


CREATE TABLE IF NOT EXISTS apartamentos (
  ap_id BIGINT NOT NULL AUTO_INCREMENT,
  ap_unidade VARCHAR(10) NOT NULL,
  ap_garagem INT NULL,
  PRIMARY KEY (ap_id),
  UNIQUE KEY uni_apartamento_unidade (ap_unidade)
);

CREATE TABLE IF NOT EXISTS moradores (
  mor_id BIGINT NOT NULL AUTO_INCREMENT,
  mor_cpf VARCHAR(11) NOT NULL,
  mor_nome VARCHAR(45) NOT NULL,
  mor_telefone VARCHAR(15) NULL,
  mor_email VARCHAR(45) NULL,
  mor_senha VARCHAR(100) NOT NULL,
  PRIMARY KEY (mor_id),
  UNIQUE KEY uni_morador_cpf (mor_cpf)
);

CREATE TABLE IF NOT EXISTS perfis (
  per_id BIGINT NOT NULL AUTO_INCREMENT,
  per_nome VARCHAR(30) NOT NULL,
  PRIMARY KEY (per_id),
  UNIQUE KEY uni_perfil_nome (per_nome)
);

CREATE TABLE IF NOT EXISTS moradores_in_apartamentos (
  ap_id BIGINT NOT NULL,
  mor_id BIGINT NOT NULL,
  PRIMARY KEY (ap_id, mor_id),
  FOREIGN KEY apartamento_fk (ap_id) REFERENCES apartamentos (ap_id) ON DELETE restrict ON UPDATE cascade,
  FOREIGN KEY morador_fk (mor_id) REFERENCES moradores (mor_id) ON DELETE restrict ON UPDATE cascade
);

CREATE TABLE IF NOT EXISTS perfil_in_moradores (
  per_id BIGINT NOT NULL, 
  mor_id BIGINT NOT NULL,
  PRIMARY KEY (per_id, mor_id),
  FOREIGN KEY perfil_fk (per_id) REFERENCES perfis (per_id) ON DELETE restrict ON UPDATE cascade,
  FOREIGN KEY morador_fk (mor_id) REFERENCES moradores (mor_id) ON DELETE restrict ON UPDATE cascade
);



insert into perfis(per_nome) value ('ROLE_ADMIN');
insert into perfis(per_nome) value ('ROLE_USUARIO');


insert into moradores(mor_cpf, mor_nome, mor_telefone, mor_email, mor_senha) value ('12345678900', 'ADMIN Teste', '(12)91234-5678', 'user@admin.com', 'pass123');
insert into apartamentos(ap_unidade, ap_garagem) value ('A00', 0);
insert into moradores_in_apartamentos values (1, 1);
insert into perfil_in_moradores values (1, 1);

insert into moradores(mor_cpf, mor_nome, mor_telefone, mor_email, mor_senha) value ('98765432100', 'USER Teste', '(13)99876-5432', 'user@user.com', 'pass123');
insert into apartamentos(ap_unidade, ap_garagem) value ('A01', 1);
insert into moradores_in_apartamentos values (1, 2);
insert into perfil_in_moradores values (2, 2);
