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
  mor_perfil VARCHAR(45) NULL,
  mor_senha VARCHAR(100) NOT NULL,
  PRIMARY KEY (mor_id),
  UNIQUE KEY uni_morador_cpf (mor_cpf)
);

CREATE TABLE IF NOT EXISTS moradores_in_apartamentos (
  ap_id BIGINT NOT NULL,
  mor_id BIGINT NOT NULL,
  PRIMARY KEY (ap_id, mor_id),
  FOREIGN KEY apartamento_fk (ap_id) REFERENCES apartamentos (ap_id) ON DELETE restrict ON UPDATE cascade,
  FOREIGN KEY morador_fk (mor_id) REFERENCES moradores (mor_id) ON DELETE restrict ON UPDATE cascade
);


insert into moradores(mor_cpf, mor_nome, mor_telefone, mor_email, mor_perfil, mor_senha) value ('12345678900', 'ADMIN Teste', '(12)91234-5678', 'user@admin.com', 'ROLE_ADMIN', 'pass123');
insert into apartamentos(ap_unidade, ap_garagem) value ('A00', 0);
insert into moradores_in_apartamentos values (1, 1);

insert into moradores(mor_cpf, mor_nome, mor_telefone, mor_email, mor_perfil, mor_senha) value ('98765432100', 'USER Teste', '(13)99876-5432', 'user@user.com', 'USUARIO', 'pass123');
insert into apartamentos(ap_unidade, ap_garagem) value ('A01', 1);
insert into moradores_in_apartamentos values (1, 2);
