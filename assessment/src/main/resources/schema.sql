/* 
 * Nexos Software
 */
/**
 * Author:  Napoleon Avila Ochoa
 * Created: 14/05/2021
 */
/*--Borrar tabla
Drop Table LIB_EDITORIAL_TB;
Drop sequence LIB_EDITORIAL_SQ;
*/
--Crear tabla registro de editoriales en una librería
CREATE TABLE LIB_EDITORIAL_TB (	
    "EDITORIAL_ID" NUMBER(15,0) NOT NULL ENABLE,   
    "EDITORIAL_NAME" VARCHAR2(150 BYTE) DEFAULT ' ' NOT NULL ENABLE,
	"CORRESPONDENCE_ADDRESS" VARCHAR2(120 BYTE) DEFAULT ' ' NOT NULL ENABLE,
	"PHONE_NUMBER" VARCHAR(20 BYTE)  DEFAULT ' ' NOT NULL ENABLE,
	"MAXIMUN_BOOKS_REGISTERED" NUMBER(15,0) DEFAULT -1 NOT NULL ENABLE,
	"CREATED_AT" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP NOT NULL ENABLE,
	"UPDATED_AT" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP NOT NULL ENABLE,
	"EMAIL" VARCHAR(50 BYTE) DEFAULT NULL,
    CONSTRAINT "LIB_EDITORIAL_PK" PRIMARY KEY ("EDITORIAL_ID")
    USING INDEX (CREATE UNIQUE INDEX LIB_EDITORIAL_IND_PK ON LIB_EDITORIAL_TB ("EDITORIAL_ID")
    PCTFREE 10 INITRANS 2 MAXTRANS 255)  ENABLE
) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255;
/
CREATE SEQUENCE LIB_EDITORIAL_SQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER;
/
CREATE OR REPLACE EDITIONABLE TRIGGER LIB_EDITORIAL_TR
    BEFORE INSERT ON LIB_EDITORIAL_TB FOR EACH ROW 
BEGIN  
    IF INSERTING THEN 
        IF :NEW.EDITORIAL_ID IS NULL THEN 
            SELECT LIB_EDITORIAL_SQ.NEXTVAL INTO :NEW.EDITORIAL_ID FROM DUAL;
        END IF; 
    END IF; 
END;
/
ALTER TRIGGER LIB_EDITORIAL_TR ENABLE;
/
CREATE INDEX LIB_EDITORIAL_IND_NAME ON LIB_EDITORIAL_TB ("EDITORIAL_NAME")
PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS;
/
COMMENT ON COLUMN "LIB_EDITORIAL_TB"."EDITORIAL_ID" IS 'Identificador Autoincremental Unico PK';
COMMENT ON COLUMN "LIB_EDITORIAL_TB"."EDITORIAL_NAME" IS 'Nombre de la editorial';
COMMENT ON COLUMN "LIB_EDITORIAL_TB"."CORRESPONDENCE_ADDRESS" IS 'Direccion de correspondecia de la editorial';
COMMENT ON COLUMN "LIB_EDITORIAL_TB"."PHONE_NUMBER" IS 'Numero de telefono de la editorial';
COMMENT ON COLUMN "LIB_EDITORIAL_TB"."MAXIMUN_BOOKS_REGISTERED" IS 'Numero maximo de libros que se pueden registrar -1 indica sin limite';
COMMENT ON COLUMN "LIB_EDITORIAL_TB"."CREATED_AT" IS 'Fecha en que se realizo el registro';
COMMENT ON COLUMN "LIB_EDITORIAL_TB"."UPDATED_AT" IS 'Fecha en que se realizo modificacion del registro';
COMMENT ON COLUMN "LIB_EDITORIAL_TB"."EMAIL" IS 'Correo electronico de la editorial';
COMMENT ON TABLE "LIB_EDITORIAL_TB"  IS 'Tabla contiene registro de las editoriales';
/
/*--Borrar tabla
Drop Table LIB_AUTHOR_TB;
Drop sequence LIB_AUTHOR_SQ;
*/
--Crear tabla registro de autores de libros
CREATE TABLE LIB_AUTHOR_TB (	
	"AUTHOR_ID" NUMBER(15,0) NOT NULL ENABLE,
	"AUTHOR_NAME" VARCHAR(100 BYTE) DEFAULT ' ' NOT NULL ENABLE,
	"DATE_OF_BIRTH" DATE DEFAULT NULL,
	"CITY_OF_ORIGIN" VARCHAR(50 BYTE) DEFAULT NULL,
	"EMAIL" VARCHAR(50 BYTE) DEFAULT NULL,
	"CREATED_AT" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP NOT NULL ENABLE,
	"UPDATED_AT" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP NOT NULL ENABLE,
    CONSTRAINT "LIB_AUTHOR_PK" PRIMARY KEY ("AUTHOR_ID")
    USING INDEX (CREATE UNIQUE INDEX LIB_AUTHOR_IND_PK ON LIB_AUTHOR_TB ("AUTHOR_ID")
    PCTFREE 10 INITRANS 2 MAXTRANS 255) ENABLE
) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255;
/
CREATE SEQUENCE LIB_AUTHOR_SQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER;
/
CREATE OR REPLACE EDITIONABLE TRIGGER LIB_AUTHOR_TR
    BEFORE INSERT ON LIB_AUTHOR_TB FOR EACH ROW 
BEGIN  
    IF INSERTING THEN 
        IF :NEW.AUTHOR_ID IS NULL THEN 
            SELECT LIB_AUTHOR_SQ.NEXTVAL INTO :NEW.AUTHOR_ID FROM DUAL;
        END IF; 
    END IF; 
END;
/
ALTER TRIGGER LIB_AUTHOR_TR ENABLE;
/
CREATE INDEX LIB_AUTHOR_IND_NAME ON LIB_AUTHOR_TB ("AUTHOR_NAME")
PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS;
/
COMMENT ON COLUMN "LIB_AUTHOR_TB"."AUTHOR_ID" IS 'Identificador Autoincremental Unico PK';
COMMENT ON COLUMN "LIB_AUTHOR_TB"."AUTHOR_NAME" IS 'Nombre completo del autor';
COMMENT ON COLUMN "LIB_AUTHOR_TB"."DATE_OF_BIRTH" IS 'Fecha de nacimiento del autor';
COMMENT ON COLUMN "LIB_AUTHOR_TB"."CITY_OF_ORIGIN" IS 'Ciudad de origen del autor';
COMMENT ON COLUMN "LIB_AUTHOR_TB"."EMAIL" IS 'Email del autor';
COMMENT ON COLUMN "LIB_AUTHOR_TB"."CREATED_AT" IS 'Fecha en que se realizo el registro';
COMMENT ON COLUMN "LIB_AUTHOR_TB"."UPDATED_AT" IS 'Fecha en que se realizo modificacion del registro';
COMMENT ON TABLE "LIB_AUTHOR_TB"  IS 'Tabla contiene registro de autores';
/
/*--Borrar tabla
Drop Table LIB_BOOK_TB;
Drop sequence LIB_BOOK_SQ;
*/
--Crear tabla registro de libros en una librería
CREATE TABLE LIB_BOOK_TB (
	"BOOK_ID" NUMBER(15,0) NOT NULL ENABLE,
	"EDITORIAL_ID" NUMBER(15,0) NOT NULL ENABLE,
	"AUTHOR_ID" NUMBER(15,0) NOT NULL ENABLE,
	"TITLE" VARCHAR(200 BYTE)  DEFAULT ' ' NOT NULL ENABLE,
	"GENDER" VARCHAR(50 BYTE)  DEFAULT ' ' NOT NULL ENABLE,
	"PAGE_NUMBER" NUMBER(5,0)  DEFAULT 1 NOT NULL ENABLE,
	"YEAR" NUMBER(4,0) DEFAULT NULL,
	"CREATED_AT" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP NOT NULL ENABLE,
	"UPDATED_AT" TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP NOT NULL ENABLE,
    CONSTRAINT "LIB_BOOK_PK" PRIMARY KEY ("BOOK_ID")
    USING INDEX (CREATE UNIQUE INDEX LIB_BOOK_IND_PK ON LIB_BOOK_TB ("BOOK_ID")
    PCTFREE 10 INITRANS 2 MAXTRANS 255)  ENABLE
) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255;
/
CREATE SEQUENCE LIB_BOOK_SQ MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER;
/
CREATE OR REPLACE EDITIONABLE TRIGGER LIB_BOOK_TR
    BEFORE INSERT ON LIB_BOOK_TB FOR EACH ROW 
BEGIN  
    IF INSERTING THEN 
        IF :NEW.BOOK_ID IS NULL THEN 
            SELECT LIB_BOOK_SQ.NEXTVAL INTO :NEW.BOOK_ID FROM DUAL;
        END IF; 
    END IF; 
END;
/
ALTER TRIGGER LIB_BOOK_TR ENABLE;
/
CREATE INDEX LIB_BOOK_IND_TITLE ON LIB_BOOK_TB ("TITLE")
PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS;
/
ALTER TABLE LIB_BOOK_TB ADD CONSTRAINT FK_EDITORIAL_ID FOREIGN KEY (EDITORIAL_ID) REFERENCES LIB_EDITORIAL_TB (EDITORIAL_ID);
/
ALTER TABLE LIB_BOOK_TB ADD CONSTRAINT FK_AUTHOR_ID FOREIGN KEY (AUTHOR_ID) REFERENCES LIB_AUTHOR_TB (AUTHOR_ID);
/
COMMENT ON COLUMN "LIB_BOOK_TB"."BOOK_ID" IS 'Identificador Autoincremental Unico PK';
COMMENT ON COLUMN "LIB_BOOK_TB"."EDITORIAL_ID" IS 'Llave forenea de la entidad asociada a tabla editorial';
COMMENT ON COLUMN "LIB_BOOK_TB"."AUTHOR_ID" IS 'Llave forenea de la entidad asociada a tabla autor';
COMMENT ON COLUMN "LIB_BOOK_TB"."TITLE" IS 'Titulo del libro';
COMMENT ON COLUMN "LIB_BOOK_TB"."GENDER" IS 'Genero del libro';
COMMENT ON COLUMN "LIB_BOOK_TB"."PAGE_NUMBER" IS 'Numero de paginas del libro';
COMMENT ON COLUMN "LIB_BOOK_TB"."YEAR" IS 'Año de publicacion del libro';
COMMENT ON COLUMN "LIB_BOOK_TB"."CREATED_AT" IS 'Fecha en que se realizo el registro';
COMMENT ON COLUMN "LIB_BOOK_TB"."UPDATED_AT" IS 'Fecha en que se realizo modificacion del regsitro';
COMMENT ON TABLE "LIB_BOOK_TB"  IS 'Tabla contiene registro de los libros en una libreria';
/