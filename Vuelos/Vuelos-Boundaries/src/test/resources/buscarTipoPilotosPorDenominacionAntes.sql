Delete from tipos_piloto;
alter SEQUENCE seq_tipo_piloto restart with 1;
Insert into tipos_piloto (id_tipo_piloto,denominacion) values(nextval('seq_tipo_piloto'),'Comandante');
Insert into tipos_piloto (id_tipo_piloto,denominacion) values(nextval('seq_tipo_piloto'),'Capitan');