--Vamos a crear las tablas para una tienda virtual que distribuye productos agrupados en familias en varias tiendas.
CREATE TABLE FAMILIA 
(
  codFamilia NUMBER(3) 
  CONSTRAINT FAM_CODFA_PK PRIMARY KEY,
  denoFamilia VARCHAR2(50) NOT NULL
  UNIQUE
  );

CREATE TABLE PRODUCTO
(
    codProducto NUMBER(5)
    CONSTRAINT PRO_CODPRO_PK PRIMARY KEY,
    denoProducto VARCHAR2(20) NOT NULL,
    descripcion VARCHAR2(100),
    precioBase NUMBER(8,2) NOT NULL
    CHECK (precioBase > 0),
    porcReposicion NUMBER(3)
    CHECK (porcReposicion > 0),
    unidadesMinimas NUMBER(4) NOT NULL
    CHECK (unidadesMinimas > 0),
    codFamilia NUMBER(3) NOT NULL
    CONSTRAINT PRO_Codf_FK
    REFERENCES FAMILIA
);

CREATE TABLE TIENDA
(
    codTienda NUMBER(3)
    CONSTRAINT TIE_CODT_PK PRIMARY KEY,
    denoTienda VARCHAR2(20) NOT NULL,
    telefono VARCHAR2(11),
    codigoPostal VARCHAR2(5) NOT NULL,
    provincia VARCHAR2(5) NOT NULL 
);

CREATE TABLE STOCK
(
    
    codTienda NUMBER(3)
    NOT NULL
    CONSTRAINT STO_CODT_FK
    REFERENCES TIENDA,
    codProducto NUMBER(5) NOT NULL
    CONSTRAINT STO_CODP_FK
    REFERENCES PRODUCTO,
    CONSTRAINT STO_PK PRIMARY KEY (codTienda, codProducto),
    unidades NUMBER(6) NOT NULL,
    CHECK(unidades >= 0)
);


COMMENT ON COLUMN FAMILIA.codfamilia IS 'Codigo que distingue una familia de otra';
COMMENT ON COLUMN FAMILIA.denoFamilia IS 'Denominacion de la familia';
COMMENT ON COLUMN PRODUCTO.codProducto IS 'Codigo que distingue un producto de otro';
COMMENT ON COLUMN PRODUCTO.denoProducto IS 'Denominacion del producto';
COMMENT ON COLUMN PRODUCTO.descripcion IS 'Descripcion del producto';
COMMENT ON COLUMN PRODUCTO.precioBase IS 'Precio base del producto';
COMMENT ON COLUMN PRODUCTO.porcReposicion IS 'Porcentaje de reposicion aplicado a este producto. Se tuilizara para aplicar a las unidades minimas y obtener el numero total de unidades a reponer cuando el stock este bajo minimo';
COMMENT ON COLUMN PRODUCTO.unidadesMinimas IS 'Unidades minimas recomendables en almacen';
COMMENT ON COLUMN PRODUCTO.codFamilia IS 'Codigo de la familia a la que pertenece el producto';
COMMENT ON COLUMN TIENDA.codTienda IS 'Codigo que distingue una tienda de otra';
COMMENT ON COLUMN TIENDA.denoTienda IS 'Denominacion o nombre de la tienda';
COMMENT ON COLUMN TIENDA.telefono IS 'Telefono de la tienda';
COMMENT ON COLUMN TIENDA.codigoPostal IS 'Codigo postal donde se ubica la tienda';
COMMENT ON COLUMN TIENDA.provincia IS 'Provincia donde se ubica la tienda';
COMMENT ON COLUMN STOCK.codTienda IS 'Codigo de la tienda';
COMMENT ON COLUMN STOCK.codProducto IS 'codigo del producto';
COMMENT ON COLUMN STOCK.unidades IS 'Unidades de ese producto en esa tienda';

