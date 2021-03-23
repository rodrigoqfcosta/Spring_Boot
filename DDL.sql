create database condominio;

use condominio;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on condominio.* to 'user'@'localhost';

CREATE TABLE IF NOT EXISTS apartamentos (
  ap_id BIGINT NOT NULL AUTO_INCREMENT,
  ap_unidade VARCHAR(10) NOT NULL,
  ap_garagem INT NOT NULL,
  PRIMARY KEY (ap_id),
  UNIQUE KEY uni_apartamento_unidade (ap_unidade)
);

CREATE TABLE IF NOT EXISTS moradores (
  mor_id BIGINT NOT NULL AUTO_INCREMENT,
  mor_nome VARCHAR(45) NULL,
  mor_telefone VARCHAR(15) NULL,
  mor_senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (mor_id),
  UNIQUE KEY uni_morador_nome (mor_nome)
);

CREATE TABLE IF NOT EXISTS condominio.moradores_in_apartamentos (
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