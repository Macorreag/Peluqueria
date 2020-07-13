DROP DATABASE IF EXISTS business;
CREATE DATABASE  business;
USE business;


SET GLOBAL event_scheduler = ON; 							-- permitira la actualizacion periodica en la base de datos

CREATE TABLE company (

    com_id 				INT PRIMARY KEY AUTO_INCREMENT,				
    com_name		 	VARCHAR(30) NOT NULL,				-- Nombre de la empresa para poner en la portada y las facturas
    com_businessName 	VARCHAR(20) NULL, 					-- Razón Social 	
    com_phone 			INT(20) NULL,						-- Para mostrar en la interfaz y las facturas	
    com_adress			VARCHAR(30)  NULL					-- Para mostrar en la interfaz y las facturas	
);
CREATE TABLE education  (

    edu_id 				INT PRIMARY KEY AUTO_INCREMENT,				
    edu_type		 	VARCHAR(30) NOT NULL				-- tipo de educacion (BACHILLER,MASTER..)
    
);

CREATE TABLE employee (

	emp_id 					BIGINT PRIMARY KEY ,			-- Cedula del empleado
    emp_firstName 			VARCHAR(20) NOT NULL,			-- Primer Nombre empleado 		
    emp_secondName  		VARCHAR(20)     NULL,			-- Segundo Nombre empleado (Opcional)
    emp_firstSurame 		VARCHAR(20) NOT NULL, 			-- Primer Apellido empleado 	
    emp_secondSurname 		VARCHAR(20)     NULL,			-- Segundo Apellido empleado (Opcional)	
    emp_eps 				INT 		NOT NULL,			-- empresa de salud a la que esta afiliado	
    emp_dateIncome 			DATETIME 	NOT NULL, 			-- Fecha ingreso A la empresa
    emp_educationalLevel 	INT		 NULL, 					-- Nivel educativo Bachiller,Pregrado,Master
    emp_sex					VARCHAR(1) 	NULL,				-- Sexo del empledo
    
    
    FOREIGN KEY (emp_educationalLevel)
        REFERENCES education (edu_id)     
);
                    
CREATE TABLE administrator (
	adm_id		BIGINT PRIMARY KEY ,	
	adm_charge	VARCHAR(20) NOT NULL,						-- Cargo que desempeña este administrador 
    
    FOREIGN KEY (adm_id)
        REFERENCES employee (emp_id)
);

CREATE TABLE customer (
    cus_id BIGINT NOT NULL PRIMARY KEY,						-- Cedula del cliente 
    cus_firstName 	VARCHAR(20) NULL,						-- primer nombre cliente 
    cus_surname 	VARCHAR(20) NULL,						-- primerapellido cliente
    cus_phone  		VARCHAR(15)  NULL,						-- telefono cliente
    -- cus_reservationsLost	INT default 0,					-- Reservaciones a las que no llego podremos bloquearlo por un tiempo con estas
    -- cus_state 		BOOLEAN NULL default 0  				-- tiene reservas activas en el sistema CON_RESERVAS(1) SIN_RESERVAS(0) 
);


CREATE TABLE section  (										-- inserta el administrador
	sec_id 	INT NOT NULL PRIMARY KEY,						-- secciones o grupos de productos(shampoos,geles,etc)
    sec_name VARCHAR(20) NOT NULL							-- nombre  de la seccion 
    
);

CREATE TABLE lab (

	lab_id 				INT NOT NULL PRIMARY KEY,
    lab_Name			VARCHAR(50) NOT NULL,
    Lab_Country			VARCHAR(50) NULL,
    lab_Address			VARCHAR(100) NULL

);



CREATE TABLE product  (
    pro_id 		BIGINT NOT NULL PRIMARY KEY,						-- codigo de  barras producto 
    pro_Name  				VARCHAR(200) NULL,							-- Nombre del producto 
    pro_description		 	VARCHAR(200) NULL,						-- Descripcion producto
    pro_lab_id					INT NOT NULL,						-- Nombre Laboratorio
    pro_price INT NOT NULL,									-- precio unidad del producto	
    pro_amount INT DEFAULT 0,								-- cantidad de productos en existencia
    pro_sec_id INT NOT NULL,								-- Seccion a la que pertenece el producto
    pro_rotationMonth INT NOT NULL default 0 ,				-- Ventas en el mes
    pro_initialAmount INT NOT NULL default 0,				-- Cantidad en cualquier instante 
    
    CHECK(pro_amount>0),									--  no permite que pro_amount sea inferior a 0 
    FOREIGN KEY (pro_lab_id)
        REFERENCES lab (lab_id)
    
    FOREIGN KEY (pro_sec_id)
        REFERENCES section (sec_id)
);

CREATE TABLE dye (
	dye_id 					BIGINT NOT NULL PRIMARY KEY,						-- codigo de  barras producto 
	dye_colorNumber			INT NOT NULL,										-- Identificador del tipo de color
	dye_colorReflection		INT  NULL,											-- Tipo de reflejo en el tinte			
    dye_descriptionBenefit 	CHAR(40) NULL										-- Beneficios que incluyen algunos productos
	
);

CREATE TABLE colorNumber(

);

CREATE TABLE colorReflection(

);
/*
CREATE TABLE treatment (
	tre_id				INT  PRIMARY KEY AUTO_INCREMENT,	-- tratamiento que se va a realizar
    tre_description 	VARCHAR(20) NOT NULL,				-- descripcion del tratamiento 
    tre_duration 		TIME NOT NULL						-- tiempo minimo de duracion del tratamiento
);

CREATE TABLE aggravating  (									-- agravante insertados por administrador
	agg_id				 INT  PRIMARY KEY AUTO_INCREMENT,	-- agravante (aumenta tiempo)
    agg_description 	 VARCHAR(20) NOT NULL,				-- descripcion (pelo muy largo,dedos muy maltratados,pelo enredado)
    agg_tre_id			 INT NOT NULL,						-- a que tratamiento se le aplica el agravante 
    agg_duration		 TIME NOT NULL,						-- tiempo que demora por ese agravante 
    FOREIGN KEY (agg_tre_id)
        REFERENCES treatment (tre_id)         
);

CREATE TABLE reservation (
    res_id 			INT NOT NULL PRIMARY KEY,				-- Numero de la reserva en el dia se reiniciara diariamente
    res_cus_id 		BIGINT	NOT  NULL,						-- Cedula cliente que reserva
    res_emp_id 		BIGINT 	NOT  NULL,						-- A que empleado se le realiza la reserva 
    res_startTime 	TIME NOT NULL, 							-- Hora de inicio del trabajo 
    res_timeTo 		TIME NOT NULL,							-- Hora final del trabajo  (SERA DEFINIDO SEGUN EL TRATAMIENTO A REALIZAR+ el agravante)	
    res_tre_id		INT NOT NULL,							-- tipo de tratamiento colocara un determinado tiempo segun sea 
    res_agg_id 		INT NULL,								-- se podra sumar tiempo segun se coloque un agravante por cada tratamiento a realizar 
    res_fulilled 	BOOLEAN NULL default 0,  				-- si pasados 10 minutos no se a  cambiado a (1) al usuario se le sumara como cita a la que no asistio 

	FOREIGN KEY (res_cus_id)
        REFERENCES customer (cus_id),     
    FOREIGN KEY (res_emp_id)
        REFERENCES employee (emp_id),     
    FOREIGN KEY (res_tre_id)
        REFERENCES treatment (tre_id),     
    FOREIGN KEY (res_agg_id)
        REFERENCES aggravating (agg_id)         
);



