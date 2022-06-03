/*
Añadir a la tabla STOCK
    Una columna de tipo fecha llamada FechaUltimaEntrada que por defecto tome el valor de la fecha actual.
    Una columna llamada Beneficio que contendrá el tipo de porcentaje de beneficio 
    que esa tienda aplica en ese producto. Se debe controlar que el valor que almacene sea 1,2, 3, 4 o 5
    
*/
ALTER TABLE STOCK ADD 
(
    fechaUltimaEntrada DATE DEFAULT SYSDATE,
    beneficio NUMBER(1) CHECK (beneficio BETWEEN 1 AND 5)
);
COMMENT ON COLUMN STOCK.fechaUltimaEntrada IS 'Fecha de entrada del stock';
COMMENT ON COLUMN STOCK.beneficio IS 'Introduce un numero entre 1 y 5';

/*
    En la tabla PRODUCTO
    Eliminar de la tabla producto la columna Descripción.
    Añadir una columna llamada perecedero que únicamente acepte los valores: S o N.
    Modificar el tamaño de la columna Denoproducto a 50.
*/

ALTER TABLE PRODUCTO DROP COLUMN descripcion;

ALTER TABLE PRODUCTO ADD 
(
    perecedero VARCHAR(1) CHECK (perecedero = 'S' or perecedero = 'N')    
);
COMMENT ON COLUMN PRODUCTO.perecedero IS 'Indica si el producto es perecedero o no';

ALTER TABLE PRODUCTO MODIFY
(
    denoProducto VARCHAR(50)
);

/*
    En la tabla FAMILIA
        Añadir una columna llamada IVA, que represente el 
        porcentaje de IVA y únicamente pueda contener los valores 21,10,ó 4.
*/

ALTER TABLE FAMILIA ADD
(
    IVA VARCHAR(2) CHECK (IVA IN ('21', '10', '4'))
);
COMMENT ON COLUMN FAMILIA.IVA IS 'Iva de la familia del producto';

/*
    En la tabla tienda
        La empresa desea restringir el número de tiendas con las que trabaja,
        de forma que no pueda haber más de una tienda en una misma zona 
        (la zona se identifica por el código postal). 
        Definir mediante DDL las restricciones necesarias
        para que se cumpla en el campo correspondiente..
*/

ALTER TABLE TIENDA ADD CONSTRAINT TIE_CODP_UK UNIQUE (codigoPostal);

--B) Renombra la tabla STOCK por PRODXTIENDAS.
RENAME STOCK TO PRODXTIENDAS;

--C)Elimina la tabla FAMILIA y su contenido si lo tuviera.
DROP TABLE FAMILIA CASCADE CONSTRAINTS;

--D) Crea un usuario llamado C##INVITADO siguiendo los pasos de la unidad 1 
--y dale todos los privilegios sobre la tabla PRODUCTO.
CREATE USER C##INVITADO identified by INVITADO default tablespace users;
GRANT ALL ON PRODUCTO TO C##INVITADO;

--E) Retira los permisos de modificar la estructura de la tabla y 
--borrar contenido de la tabla PRODUCTO al usuario anterior.
REVOKE ALTER ON PRODUCTO FROM C##INVITADO;
REVOKE DELETE ON PRODUCTO FROM C##INVITADO;





