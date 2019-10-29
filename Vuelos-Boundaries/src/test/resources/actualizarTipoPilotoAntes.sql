Delete from tipos_piloto;
alter SEQUENCE seq_tipo_piloto restart with 1;
INSERT INTO tipos_piloto (id_tipo_piloto,denominacion) VALUES(nextval('seq_tipo_piloto'),'Comandante');