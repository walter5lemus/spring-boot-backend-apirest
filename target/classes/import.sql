/* Populate tabla regiones */
INSERT INTO regiones (nombre) VALUES ('Centro America');
INSERT INTO regiones ( nombre) VALUES ( 'Norte America');
INSERT INTO regiones ( nombre) VALUES ('Europa');

/* Populate tabla clientes */
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01',1);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02',1);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03',1);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04',2);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01',2);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10',2);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18',3);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28',3);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03',3);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04',3);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05',2);
INSERT INTO clientes (nombres, apellidos, email, create_at, region_id) VALUES('Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06',1);