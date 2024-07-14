CREATE TABLE topicos(
    id bigint NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(75) NOT NULL,
    mensagem VARCHAR(200) NOT NULL,
    data_criacao DATE NOT NULL,
    estado_topico VARCHAR(100) NOT NULL,
    autor VARCHAR(100),
    curso VARCHAR(100) NOT NULL,

    PRIMARY KEY(id)

);