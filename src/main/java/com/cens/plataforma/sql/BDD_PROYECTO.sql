/*Crear la base de datos*/
CREATE database if NOT EXISTS BDD_PROYECTO;
/*Usar la base de datos*/
USE BDD_PROYECTO;

/*Creación de tablas*/

CREATE TABLE ROL (
	id_rol bigint NOT NULL, 
	tipo_rol VARCHAR(20) NOT NULL,
	PRIMARY KEY (id_rol)
);

CREATE TABLE USUARIO (
	id_user bigint NOT NULL auto_increment,
    id_rol bigint NOT NULL,
    nom_user VARCHAR(20) NOT NULL,
    apell_p VARCHAR(20) NOT NULL, 
    apell_m VARCHAR(20) NOT NULL, 
    pass_user VARCHAR(15) NOT NULL,
    email_user VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_user),
    FOREIGN KEY (id_rol) REFERENCES ROL(id_rol)
); 

CREATE TABLE EMPRESA (
	id_empresa bigint not null auto_increment,
    rut_empresa VARCHAR(20) NOT NULL,
    nom_emp VARCHAR(30) NOT NULL,
	email_emp VARCHAR(100) NOT NULL,
    encargado_emp VARCHAR(35) NOT NULL,
	encargado_run_emp VARCHAR(20) NOT NULL,
    razon_social VARCHAR(80) NOT NULL,
    contacto_emp VARCHAR(15) NOT NULL,
    PRIMARY KEY(id_empresa)
); 

/*Rellenar tablas*/

/*Tabla roles*/
INSERT INTO ROL (id_rol, tipo_rol)
VALUES 
    ('1', 'Administrador'),
    ('2', 'Visador'),
    ('3', 'Evaluador'),
    ('4', 'Visualizador');

/*Tabla Usuarios*/    
INSERT INTO USUARIO (id_user, id_rol, nom_user, apell_p, apell_m, pass_user, email_user)
VALUES 
    ('1', '1', 'Priscila', 'ApellidoP', 'ApellidoM', 'admin123', 'admin@example.com'),
    ('2', '2', 'Gastón', 'Marquez', 'Ortega', 'user123', 'gmarquez@ubiobio.cl'),
    ('3', '3', 'random1', 'ApellidoP', 'ApellidoM', 'emp123', 'emp1@example.com'), 
	('4', '4', 'Erick', 'The Big', 'Boss', 'visu123', 'visu1@example.com'),
    ('5', '3', 'Evaluador2', 'Apellido1', 'Apellido2', 'evual123', 'eval2@example.com');

/*Tabla Empresas*/
INSERT INTO EMPRESA (id_empresa, rut_empresa, nom_emp, email_emp, encargado_emp, encargado_run_emp, razon_social, contacto_emp)
VALUES 
    (1, '123456789', 'Empresa1', 'empresa1@example.com', 'Encargado1', '123ABC', 'Razón Social 1', '123456789'),
    (2, '987654321', 'Empresa2', 'empresa2@example.com', 'Encargado2', '456DEF', 'Razón Social 2', '987654321'),
    (3, '555555555', 'Empresa3', 'empresa3@example.com', 'Encargado3', '789GHI', 'Razón Social 3', '555555555');

/*Tabla Etapa*/
INSERT INTO etapa (id_etapa, nom_etapa) VALUES
(1, 'Completando formulario'),
(2, 'Informe Entregado'),
(3, 'SELLO Entregado'),
(4, 'NDA');

/*Tabla Proceso Tipo*/
INSERT INTO tipo_proceso (id_tipo_proceso, nom_tipo_proceso)
VALUES
	(1, 'PROCESO CLÍNICO'),
	(2, 'PROCESO TÉCNICO: Compatibilidad'),
	(3, 'PROCESO TÉCNICO: Usabilidad'),
	(4, 'PROCESO TÉCNICO: Fiabilidad'),
	(5, 'PROCESO TÉCNICO: Seguridad');
    
/*Tabla Proceso*/
INSERT INTO proceso (id_proceso, id_tipo_proceso, nom_proceso)
VALUES
	(1, 1, 'Eficiencia y eficacia'),
	(2, 1, 'Seguridad Asistencial'),
	(3, 1, 'Centro en el paciente'),
	(4, 1, 'Registro Clínico'),
	(5, 2, 'Interoperabilidad'),
	(6, 3, 'Pruebas de usuario'),
	(7, 3, 'Errores de usuario'),
	(8, 3, 'Capacidad de aprendizaje'),
	(9, 3, 'Accesibilidad'),
	(10, 4, 'Eficiencia de desempeño'),
	(11, 4, 'Tolerancia a fallos'),
	(12, 4, 'Capacidad de recuperación'),
	(13, 4, 'Arquitectura'),
	(14, 4, 'Otros aspectos'),
	(15, 5, 'Autenticación'),
	(16, 5, 'Autorización'),
	(17, 5, 'Criptografía'),
	(18, 5, 'Gestión contraseñas'),
	(19, 5, 'Integridad'),
	(20, 5, 'Autenticidad'),
	(21, 5, 'Gestión de riesgo'),
	(22, 5, 'Documentación');