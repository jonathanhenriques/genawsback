CREATE TABLE GENAWS_TB_PROFESSOR (
    ID BIGSERIAL PRIMARY KEY,
 --   CODIGO UUID NOT NULL,
    NOME_PROFESSOR VARCHAR(100) NOT NULL,
    IS_ATIVO BOOLEAN NOT NULL DEFAULT TRUE
);




--CREATE INDEX IDX_NOME_PROFESSOR ON GENAWS_TB_PROFESSOR(NOME_PROFESSOR);



--CREATE SEQUENCE GENAWS_TB_PROFESSOR_ID_SEQ;








CREATE TABLE GENAWS_TB_ALUNO (
    ID BIGSERIAL PRIMARY KEY,
    NOME VARCHAR(100) NOT NULL,
 --   CODIGO VARCHAR(36) NOT NULL,
    IDADE BIGINT NOT NULL,
    NOTA_PRIMEIRO_SEMESTRE BIGINT,
    NOTA_SEGUNDO_SEMESTRE BIGINT,
    NOME_PROFESSOR VARCHAR(100),
    NUMERO_SALA VARCHAR(100),
    IS_ATIVO BOOLEAN NOT NULL DEFAULT TRUE
);


--CREATE INDEX IDX_NOME ON GENAWS_TB_ALUNO(NOME);


--ALTER TABLE GENAWS_TB_ALUNO
--ADD FOREIGN KEY (ID_PROFESSOR) REFERENCES GENAWS_TB_PROFESSOR(ID);


--ALTER TABLE GENAWS_TB_ALUNO
--ADD FOREIGN KEY (ID_SALA) REFERENCES GENAWS_TB_SALA(ID);


--CREATE SEQUENCE GENAWS_TB_ALUNO_ID_SEQ;










CREATE TABLE GENAWS_TB_SALA (
    ID BIGSERIAL PRIMARY KEY,
 --   CODIGO VARCHAR(36) NOT NULL,
    NUMERO_SALA BIGINT,
    IS_ATIVO BOOLEAN NOT NULL DEFAULT TRUE
 --   ALUNO_ID BIGSERIAL,
 --   PROFESSOR_ID BIGSERIAL
);


--CREATE INDEX IDX_ALUNO_ID ON GENAWS_TB_SALA(ALUNO_ID);
--CREATE INDEX IDX_PROFESSOR_ID ON GENAWS_TB_SALA(PROFESSOR_ID);


--ALTER TABLE GENAWS_TB_SALA ADD CONSTRAINT FK_ALUNO
--FOREIGN KEY (ALUNO_ID) REFERENCES GENAWS_TB_ALUNO(ID);

--ALTER TABLE GENAWS_TB_SALA ADD CONSTRAINT FK_PROFESSOR
--FOREIGN KEY (PROFESSOR_ID) REFERENCES GENAWS_TB_PROFESSOR(ID);






