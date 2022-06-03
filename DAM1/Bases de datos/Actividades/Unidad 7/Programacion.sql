DROP TABLE TablaResponsables;
DROP TABLE TablaComerciales; 
DROP TYPE VarrayZonas;
DROP TYPE listazonas;
DROP TYPE Comercial;
DROP TYPE Zonas;
DROP TYPE Responsable;
DROP TYPE Personal;

--1. Crea el tipo de objetos "Personal" con los siguientes atributos:

CREATE OR REPLACE TYPE Personal AS OBJECT (
codigo INTEGER, 
dni VARCHAR2(10),
nombre VARCHAR2(30),
apellidos VARCHAR2(30),
sexo VARCHAR2(1),
fecha_nac DATE) NOT FINAL;

--Crea, como tipo heredado de "Personal", el tipo de objeto "Responsable" con los siguientes atributos:

 --hemos aniadido en el apartado anterior NOT FINAL para que pueda haber herencia.
 
 CREATE OR REPLACE TYPE Responsable UNDER Personal  (
 tipo CHAR, 
 antiguedad INTEGER);
 
 --Crea el tipo de objeto "Zonas" con los siguientes atributos:
 
 CREATE OR REPLACE TYPE Zonas AS OBJECT (
 codigo INTEGER,
 nombre VARCHAR2(20),
 refRespon REF Responsable,
 codigoPostal CHAR(5));
 
 --Crea, como tipo heredado de "Personal", el tipo de objeto "Comercial" con los siguientes atributos:
 
 CREATE OR REPLACE TYPE Comercial UNDER Personal (
 zonaComercial Zonas);
 
--2. Crea un método constructor para el tipo de objetos "Responsable", en el que se indiquen como parámetros
--el código, nombre, primer apellido, segundo apellido y tipo. Este método debe asignar al atributo apellidos los datos de primer apellido y segundo apellido 
--que se han pasado como parámetros, uniéndolos con un espacio entre ellos.
ALTER TYPE Responsable ADD CONSTRUCTOR FUNCTION Responsable(
        codigo INTEGER, 
        nombre VARCHAR2,
        primerApellido VARCHAR2, 
        segundoApellido VARCHAR2,
        tipo CHAR)
        RETURN SELF AS RESULT CASCADE;

CREATE OR REPLACE TYPE BODY Responsable AS
    CONSTRUCTOR FUNCTION Responsable(
        codigo INTEGER, 
        nombre VARCHAR2,
        primerApellido VARCHAR2, 
        segundoApellido VARCHAR2,
        tipo CHAR)
        RETURN SELF AS RESULT
    IS
        BEGIN
            SELF.codigo := codigo;
            SELF.nombre := nombre;
            SELF.apellidos := primerApellido||' '||segundoApellido;
            SELF.tipo := tipo;
            RETURN;
        END;
END;

--3.Crea un método getNombreCompleto para el tipo de objetos Responsable
--que permita obtener su nombre completo con el formato apellidos nombre


ALTER TYPE Responsable ADD MEMBER FUNCTION getNombreCompleto
RETURN VARCHAR2 CASCADE;

CREATE OR REPLACE TYPE BODY Responsable AS
    CONSTRUCTOR FUNCTION Responsable(
        codigo INTEGER, 
        nombre VARCHAR2,
        primerApellido VARCHAR2, 
        segundoApellido VARCHAR2,
        tipo CHAR)
        RETURN SELF AS RESULT
    IS
        BEGIN
            SELF.codigo := codigo;
            SELF.nombre := nombre;
            SELF.apellidos := primerApellido||' '||segundoApellido;
            SELF.tipo := tipo;
            RETURN;
        END;
        

MEMBER FUNCTION getNombreCompleto RETURN 
    VARCHAR2 
    IS
        BEGIN
            RETURN self.apellidos ||' '||self.nombre;
        END getNombreCompleto;
    END;

--4.Crea un tabla TablaResponsables de objetos  Responsable.
--Inserta en dicha tabla dos objetos  Responsable. 
 
 CREATE TABLE TablaResponsables OF Responsable;
 DECLARE
    r1 Responsable;
    r2 Responsable;
 BEGIN
    r1 := NEW Responsable(5,'51083099F','ELENA','POSTA LLANOS','F','31/03/1975','N',4);
    r2 := NEW Responsable(6,'JAVIER','JARAMILLO','HERNANDEZ','C');
    INSERT INTO TablaResponsables VALUES (r1);
    INSERT INTO TablaResponsables VALUES (r2);
END;
--Tambien se podria hacer directamente con INSERT INTO ProfesoradoVALUES (Profesorado(xxxx,xxx))
 
--5. Crea una colección VARRAY llamada ListaZonas en la que se puedan almacenar hasta 10 objetos Zonas. .
-- Guarda en una instancia listaZonas1 de dicha lista, dos Zonas
 
--CREATE OR REPLACE TYPE ListaZonas IS VARRAY(10) OF Zonas;
CREATE OR REPLACE TYPE VarrayZonas AS VARRAY(10) OF Zonas;
DECLARE
   
    ListaZonas VarrayZonas := VarrayZonas();
    r_refcod5 REF Responsable;
    z1 Zonas;
    r_refDNI REF Responsable;
    z2 Zonas;
BEGIN
    SElECT REF(r) INTO r_refcod5 FROM TablaResponsables r WHERE r.codigo = 5;
    SELECT REF(r) INTO r_refDNI FROM TablaResponsables r WHERE r.DNI = '51083099F';
    z1 := new Zonas(1, 'zona 1', r_refcod5, '06834');
    z2 := new Zonas(2, 'zona 2', r_refDNI,'28003');
    ListaZonas := VarrayZonas (z1, z2);
END;

--6.Crea una tabla TablaComerciales de objetos Comercial.
--Inserta en dicha tabla las siguientes filas:

 CREATE TABLE TablaComerciales OF Comercial;
 CREATE OR REPLACE TYPE VarrayZonas IS VARRAY(10) OF Zonas;
 
 DECLARE
    
    ListaZonas VarrayZonas := VarrayZonas();
    r_refcod5 REF Responsable;
    z1 Zonas;
    r_refDNI REF Responsable;
    z2 Zonas;
 BEGIN
    SElECT REF(r) INTO r_refcod5 FROM TablaResponsables r WHERE r.codigo = 5;
    SELECT REF(r) INTO r_refDNI FROM TablaResponsables r WHERE r.DNI = '51083099F';
    z1 := Zonas(1, 'zona 1', r_refcod5, '06834');
    z2 := Zonas(2, 'zona 2', r_refDNI,'28003');
    ListaZonas := VarrayZonas (z1, z2);
    INSERT INTO TablaComerciales VALUES (100,'23401092Z','MARCOS', 'SUAREZ LOPEZ', 'M','30/3/1990',z1);
    INSERT INTO TablaComerciales VALUES (102,'6932288V', 'ANASTASIA', 'GOMES PEREZ', 'F','28/11/1984',ListaZonas(2));
    
END;

--7.Obtener, de la tabla TablaComerciales, el Comercial que tiene el código 100, 
--asignándoselo a una variable unComercial 

DECLARE
unComercial Comercial;
BEGIN
    SELECT VALUE(t) INTO unComercial FROM TablaComerciales t WHERE t.codigo = 100; 
    DBMS_OUTPUT.PUT_LINE(unComercial.nombre);
 END;
 
 --8.Modifica el código del Comercial guardado en esa variable 
 --unComercial asignando el valor 101, y su zona debe ser la segunda 
 --que se había creado anteriormente. 
 --Inserta ese Comercial en la tabla TablaComerciales  
 
 DECLARE
unComercial Comercial;
r_refDNI REF Responsable;
z2 Zonas;
BEGIN
    SELECT VALUE(t) INTO unComercial FROM TablaComerciales t WHERE t.codigo = 100; 
    --DBMS_OUTPUT.PUT_LINE(unComercial.codigo);
    unComercial.codigo := 101;
    --DBMS_OUTPUT.PUT_LINE(unComercial.codigo);
    SELECT REF(r) INTO r_refDNI FROM TablaResponsables r WHERE r.DNI = '51083099F';
    z2 := Zonas(2, 'zona 2', r_refDNI,'28003');
    --DBMS_OUTPUT.PUT_LINE(unComercial.zonacomercial.codigo);
    unComercial.zonacomercial := z2;
    --DBMS_OUTPUT.PUT_LINE(unComercial.zonacomercial.codigo);
    INSERT INTO TablaComerciales VALUES unComercial;
 END;
 
 --9.Crea un método MAP ordenarZonas para el tipo Zonas. 
 --Este método debe retornar el nombre completo del Responsable al que hace referencia cada zona. 
 --Para obtener el nombre debes utilizar el método getNombreCompleto
 --que se ha creado anteriormente
 
 ALTER TYPE Zonas ADD 
 MAP MEMBER FUNCTION orderZonas RETURN VARCHAR2 CASCADE;
 
 CREATE OR REPLACE TYPE BODY Zonas AS
  MAP MEMBER FUNCTION orderZonas RETURN VARCHAR2
     IS 
      responsableConsulta Responsable;
        BEGIN
           SELECT DEREF(refRespon) INTO responsableConsulta FROM DUAL;
            RETURN responsableConsulta.getNombreCompleto();
        END;
    END;
       
 
 --10.Realiza una consulta de la tabla TablaComerciales 
 --ordenada por zonaComercial para comprobar el funcionamiento del método MAP.  
 SELECT * FROM TABLACOMERCIALES
 ORDER BY zonaComercial;
 
