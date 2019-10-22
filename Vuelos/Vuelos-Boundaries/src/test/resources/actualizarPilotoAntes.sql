Delete from pilotos;
Delete from tipos_piloto;
alter SEQUENCE seq_tipo_piloto restart with 1;
INSERT INTO tipos_piloto (id_tipo_piloto,denominacion) VALUES(nextval('seq_tipo_piloto'),'Comandante');

INSERT INTO pilotos(id_piloto, apellido, dni, nombre, tipo_piloto_id) VALUES (nextval('seq_piloto'), 'Perez', '001', 'Juan',1);
INSERT INTO pilotos(id_piloto, apellido, dni, nombre, tipo_piloto_id) VALUES (nextval('seq_piloto'), 'Lopez', '001', 'JuanFer',1);
