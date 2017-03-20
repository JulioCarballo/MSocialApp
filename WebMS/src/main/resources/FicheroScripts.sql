CREATE TABLE login (
  usuario varchar2(200) NOT NULL,
  password varchar2(200) DEFAULT NULL,
  nombre varchar2(200) DEFAULT NULL,
  roluser varchar2(10) DEFAULT NULL,
  fechaalta date DEFAULT (sysdate),
  swactivo varchar2(1) DEFAULT 'S',
  swmodpass varchar2(1) DEFAULT 'S',
  swmodificar varchar2(1) DEFAULT 'S',
  url varchar(100) DEFAULT NULL,
  PRIMARY KEY (usuario)
);

CREATE TABLE delegacion (
  del_codigo varchar2(3) NOT NULL,
  del_nombre varchar2(60) DEFAULT NULL,
  PRIMARY KEY (del_codigo)
);

CREATE TABLE terminales (
  tpv_nroserie varchar2(20) NOT NULL,
  tpv_nroimei varchar2(40) DEFAULT NULL,
  tpv_operador varchar2(30) DEFAULT NULL,
  tpv_swactivo varchar2(1) DEFAULT 'S',
  tpv_comentario varchar2(200) DEFAULT NULL,
  tpv_delcodigo varchar2(3) NOT NULL,
  PRIMARY KEY (tpv_nroserie),
  FOREIGN KEY(tpv_delcodigo)
  REFERENCES delegacion(del_codigo)
);