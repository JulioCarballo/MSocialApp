--------------------------------------------------------
-- Archivo creado  - jueves-agosto-24-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TERMINALES
--------------------------------------------------------

  CREATE TABLE "SISTEMASDB"."TERMINALES" 
   (	"TPV_NROSERIE" VARCHAR2(20 BYTE), 
	"TPV_NROIMEI" VARCHAR2(40 BYTE) DEFAULT NULL, 
	"TPV_OPERADOR" VARCHAR2(30 BYTE) DEFAULT NULL, 
	"TPV_SWACTIVO" VARCHAR2(1 BYTE) DEFAULT 'S', 
	"TPV_COMENTARIO" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"TPV_DELCODIGO" VARCHAR2(3 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into SISTEMASDB.TERMINALES
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C007063
--------------------------------------------------------

  CREATE UNIQUE INDEX "SISTEMASDB"."SYS_C007063" ON "SISTEMASDB"."TERMINALES" ("TPV_NROSERIE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table TERMINALES
--------------------------------------------------------

  ALTER TABLE "SISTEMASDB"."TERMINALES" ADD PRIMARY KEY ("TPV_NROSERIE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "SISTEMASDB"."TERMINALES" MODIFY ("TPV_DELCODIGO" NOT NULL ENABLE);
  ALTER TABLE "SISTEMASDB"."TERMINALES" MODIFY ("TPV_NROSERIE" NOT NULL ENABLE);
