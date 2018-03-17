-- CREATE EXTENSION postgis;
-- CREATE EXTENSION postgis_topology;

-- CREATE TABLE localidade(
--        id SERIAL,
--        nome  VARCHAR(62) NOT NULL,
--        local GEOMETRY(Point, 26910) NOT NULL,
--        endereco VARCHAR(25) NOT NULL,
--        telefone VARCHAR(25) NOT NULL UNIQUE,
--        mediaNotas NUMERIC(8,1) NOT NULL DEFAULT 0,
--        PRIMARY KEY(id)
-- );

CREATE TABLE usuario(
        id SERIAL,
        nome VARCHAR(60) NOT NULL,
        email VARCHAR(60) NOT NULL UNIQUE,
        senha VARCHAR(16) NOT NULL UNIQUE,
        PRIMARY KEY(id)
);

-- CREATE TABLE avaliacao(
--         id_usuario INT,
--         id_localidade INT,
--         comentario VARCHAR(120) NOT NULL,
--         nota INT NOT NULL,
-- 
--         FOREIGN KEY (id_usuario) REFERENCES Usuario(id) ON DELETE SET NULL,
--         FOREIGN KEY (id_localidade) REFERENCES  localidade(id) ON DELETE  CASCADE,
-- 
--         PRIMARY KEY(id_usuario,id_localidade)
-- );
-- 
-- --DROP TRIGGER cal_media ON avaliacao;
-- 
-- CREATE OR REPLACE FUNCTION mediaAvaliacao()
--   RETURNS trigger AS $teste_trigger$
--   BEGIN
--  UPDATE localidade SET medianotas= (SELECT AVG(nota) FROM Avaliacao WHERE ID_LOCALIDADE = NEW.ID_LOCALIDADE) WHERE ID =NEW.ID_LOCALIDADE;
--   RETURN NEW;
--   END;
--   
--   $teste_trigger$ LANGUAGE plpgsql; 
--    CREATE TRIGGER cal_media
--   AFTER INSERT OR UPDATE  ON avaliacao
--   FOR EACH ROW
--   EXECUTE PROCEDURE mediaAvaliacao();
-- 
--   CREATE OR REPLACE FUNCTION mediaAvaliacaoDel()
--   RETURNS trigger AS $teste_trigger$
--   BEGIN
--  UPDATE localidade SET medianotas= (SELECT AVG(nota) FROM Avaliacao WHERE ID_LOCALIDADE = OLD.ID_LOCALIDADE) WHERE ID =OLD.ID_LOCALIDADE;
--   RETURN NEW;
--   END;
--   
--   $teste_trigger$ LANGUAGE plpgsql; 
--    CREATE TRIGGER cal_mediaDel
--   AFTER  DELETE ON avaliacao
--   FOR EACH ROW
--   EXECUTE PROCEDURE mediaAvaliacaoDel();

INSERT INTO usuario (nome,email,senha)
             VALUES ('José Ferreira','jose@gmail.com','jf1234');
INSERT INTO usuario (nome,email,senha)
             VALUES ('Jussara Araujo','sara@gmail.com','ja1234');




