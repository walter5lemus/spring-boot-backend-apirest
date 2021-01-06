/* Populate tabla regiones */
INSERT INTO regiones (nombre) VALUES ('Centro America');
INSERT INTO regiones ( nombre) VALUES ( 'Norte America');
INSERT INTO regiones ( nombre) VALUES ('Europa');

/* Populate tabla clientes */
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Andres', 'Guzman', 'profesor@bolsadeideas.com', TO_DATE('2018-01-01','yyyy-MM-dd'),1);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Mr. John', 'Doe', 'john.doe@gmail.com', TO_DATE('2018-01-02','yyyy-MM-dd'),1);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', TO_DATE('2018-01-03','yyyy-MM-dd'),1);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', TO_DATE('2018-01-04','yyyy-MM-dd'),2);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', TO_DATE('2018-02-01','yyyy-MM-dd'),2);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', TO_DATE('2018-02-10','yyyy-MM-dd'),2);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', TO_DATE('2018-02-18','yyyy-MM-dd'),3);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', TO_DATE('2018-02-28','yyyy-MM-dd'),3);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Dr. James', 'Gosling', 'james.gosling@gmail.com', TO_DATE('2018-03-03','yyyy-MM-dd'),3);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Magma', 'Lee', 'magma.lee@gmail.com', TO_DATE('2018-03-04','yyyy-MM-dd'),3);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Tornado', 'Roe', 'tornado.roe@gmail.com', TO_DATE('2018-03-05','yyyy-MM-dd'),2);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Jade', 'Doe', 'jane.doe@gmail.com', TO_DATE('2018-03-06','yyyy-MM-dd'),1);

/* Creamos algunos usuarios con sus roles */
INSERT INTO usuarios (username, password, enabled, nombres, apellidos, email) VALUES('andres','$2a$10$PzcLk21IT2OKWpII3iXNXOIRwaIISECpe/sKvdRE/OwK1w43o3Jom',1, 'Andres', 'Guzman', 'profesor@bolsadeideas.com' );
INSERT INTO usuarios (username, password, enabled, nombres, apellidos, email) VALUES('walter','$2a$10$/BXNcYLb8O9MmTo88rxqoeS0D6x1.bOZD6JJ9dkbnEwMhzkDQU7E6',1,'Walter','Lemus','walterlemus@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombres, apellidos, email) VALUES('admin','$2a$10$gLDoCGnSr8HT4dsmBgNzaeyRkK58fP2VKGWgQSaA/vKMhO/m.2v2S',1,'ADMIN','ADMIN','ADMIN@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (3,2);