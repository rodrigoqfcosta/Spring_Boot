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
  mor_senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (mor_id),
  UNIQUE KEY uni_morador_cpf (mor_cpf)
);

CREATE TABLE IF NOT EXISTS moradores_in_apartamentos (
  ap_id BIGINT NOT NULL,
  mor_id BIGINT NOT NULL,
  PRIMARY KEY (ap_id, mor_id),
  INDEX fk_apartamentos_in_moradores_mor_id (mor_id) VISIBLE,
  INDEX fk_apartamentos_in_moradores_ap_id (ap_id) VISIBLE,
  CONSTRAINT fk_apartamentos_in_moradores_ap
    FOREIGN KEY (ap_id)
    REFERENCES apartamentos (ap_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_apartamentos_in_moradores_mor
    FOREIGN KEY (mor_id)
    REFERENCES moradores (mor_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

insert into moradores(mor_cpf, mor_nome, mor_telefone, mor_email, mor_senha)
value ('12345678900', 'Usuario Teste', '(12)91234-5678', 'user@test.com', 'pass123');
insert into apartamentos(ap_unidade, ap_garagem) value ('A00', 0);
insert into moradores_in_apartamentos values (1, 1);
