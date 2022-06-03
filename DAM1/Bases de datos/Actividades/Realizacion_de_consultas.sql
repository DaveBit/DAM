/*1 Obtener los nombres y salarios de los empleados con más de 1000 euros
de salario por orden alfabético.*/
SELECT NOMBRE, SALARIO FROM EMPLEADO
WHERE SALARIO>1000
ORDER BY NOMBRE;

/*2 Obtener el nombre de los empleados cuya comisión es superior al 20% de su salario.*/
SELECT NOMBRE FROM EMPLEADO
WHERE COMISION > (SALARIO*0.20);

/*3 Obtener el código de empleado, código de departamento, nombre y sueldo total en pesetas de aquellos empleados cuyo sueldo total (salario más comisión) supera los 1800 euros. Presentarlos ordenados 
por código de departamento y dentro de éstos por orden alfabético.*/
SELECT CODEMPLE, CODDPTO, NOMBRE, (SALARIO+NVL(COMISION,0)) as Salariototal FROM empleado
WHERE (SALARIO+NVL(COMISION,0)) > 1800
ORDER BY CODDPTO, NOMBRE;

/*4 Obtener por orden alfabético los nombres de empleados cuyo salario igualen
o superen en más de un 5% al salario de la empleada ‘MARIA JAZMIN’.*/

SELECT NOMBRE, SALARIO, (1000*1.05) AS Igualosuperior FROM EMPLEADO
WHERE SALARIO >= (SELECT (SALARIO*1.05) FROM EMPLEADO WHERE NOMBRE = 'MARIA' AND APE1 = 'JAZMIN')
ORDER BY NOMBRE;

/*5 Obtener una listado ordenado por años en la empresa con los nombres,
y apellidos de los empleados y los años de antigüedad en la empresa*/

SELECT NOMBRE, APE1, APE2, ROUND(((months_between(SYSDATE,FECHAINGRESO))/12),0) AS Antiguedad from empleado
ORDER BY Antiguedad;

/*6 Obtener el nombre de los empleados que trabajan en un departamento con presupuesto superior a 50.000 euros.
Hay que usar predicado cuantificado*/

SELECT NOMBRE, APE1, APE2, CODDPTO FROM EMPLEADO
WHERE CODDPTO IN (SELECT CODDPTO FROM DPTO WHERE PRESUPUESTO > 50000);

/*7 Obtener los nombres y apellidos de empleados que más cobran en la empresa.
Considerar el salario más la comisión,*/

SELECT NOMBRE, APE1, APE2, SALARIO FROM EMPLEADO
WHERE SALARIO > (SELECT AVG(SALARIO) FROM EMPLEADO);

/*8 Obtener en orden alfabético los nombres de empleado 
cuyo salario es inferior al mínimo de los empleados del departamento 1.*/

SELECT NOMBRE, APE1, APE2 FROM EMPLEADO
WHERE SALARIO < (SELECT MIN(SALARIO) FROM EMPLEADO WHERE CODDPTO = 1)
ORDER BY NOMBRE;

/*9 Obtener los nombre de empleados que 
trabajan en el departamento del cuál es jefe el empleado con código 1.*/

SELECT NOMBRE, APE1, APE2 FROM EMPLEADO
WHERE CODDPTO = (SELECT CODDPTO FROM DPTO WHERE CODEMPLEJEFE = 1); 

/*10 Obtener los nombres de los empleados cuyo primer
apellido empiece por las letras p, q, r, s.*/

SELECT NOMBRE, APE1, APE2 FROM EMPLEADO
WHERE APE1 LIKE 'P%' 
OR  APE1  LIKE 'Q%' 
OR APE1 LIKE 'R%' 
OR APE1 LIKE 'S%';

/* 11 Obtener los empleados cuyo nombre de pila contenga el nombre JUAN.*/
SELECT NOMBRE FROM EMPLEADO
WHERE NOMBRE LIKE '%JUAN%';

/*12 Obtener los nombres de los empleados que 
viven en ciudades en las que hay algún centro de trabajo*/

SELECT NOMBRE, APE1, APE2, LOCALIDAD FROM EMPLEADO
WHERE LOCALIDAD IN (SELECT UPPER(LOCALIDAD) FROM CENTRO);

/*13 Obtener el nombre del jefe de departamento que tiene
mayor salario de entre los jefes de departamento. */

SELECT nombre FROM empleado, dpto
WHERE empleado.codemple = dpto.codemplejefe 
AND salario = (SELECT MAX(salario) FROM empleado);

/*14 Obtener en orden alfabético los salarios y nombres de los
empleados cuyo salario sea superior al 60% del máximo salario de la empresa.*/

SELECT NOMBRE, APE1, APE2, SALARIO FROM EMPLEADO
WHERE SALARIO > 0.6*(SELECT MAX(SALARIO) FROM EMPLEADO);

/*15 Obtener en cuántas ciudades distintas viven los empleados*/
SELECT COUNT(DISTINCT LOCALIDAD) FROM EMPLEADO;

/*16 El nombre y apellidos del empleado que más salario cobra*/
SELECT NOMBRE, APE1, APE2, SALARIO FROM EMPLEADO
WHERE SALARIO = (SELECT MAX(SALARIO) FROM EMPLEADO);

/*17 Obtener las localidades y número de 
empleados de aquellas en las que viven más de 3 empleados*/

SELECT LOCALIDAD, COUNT(CODEMPLE) AS NumeroDeEmpleados FROM EMPLEADO
GROUP BY LOCALIDAD;

/* 18 Obtener para cada departamento cuántos empleados trabajan,
la suma de sus salarios y la suma de sus comisiones para aquellos 
departamentos en los que hay algún empleado cuyo salario es superior a 1700 euros.*/

SELECT DENOMINACION, COUNT(CODEMPLE) AS NumerodeEmpleados, SUM(SALARIO+NVL(empleado.comision,0)) AS salario FROM empleado, dpto
WHERE EMPLEADO.CODDPTO = dpto.coddpto AND SALARIO>1700
GROUP BY DENOMINACION;

/*19 Obtener el departamento que más empleados tiene*/

SELECT COUNT(CODEMPLE) AS numerototalpordepart, empleado.coddpto FROM EMPLEADO
GROUP BY empleado.CODDPTO
ORDER BY numerototalpordepart desc;

/*20 Obtener la direccion de todos los centros y los departamentos que se 
ubican en cada uno,así como aquellos centros que no tienen departamentos.*/

SELECT CENTRO.DIRECCION, DPTO.DENOMINACION FROM CENTRO
LEFT JOIN DPTO ON 
CENTRO.CODCENTRO = dpto.codcentro;

/*21 Obtener el nombre del departamento de más alto nivel, es decir, aquel que no depende de ningún otro. */
SELECT DENOMINACION, CODDPTODEPENDE FROM DPTO
WHERE CODDPTODEPENDE IS NULL;

/*22 Obtener todos los departamentos existentes en la empresa y los empleados (si los tiene) que pertenecen a él. */
SELECT DENOMINACION, NOMBRE, APE1, APE2 FROM DPTO
LEFT JOIN EMPLEADO ON
EMPLEADO.CODDPTO = DPTO.CODDPTO;

/*23  Obtener un listado en el que aparezcan todos los departamentos 
existentes y el departamento del cual depende,si depende de alguno.*/

SELECT a.DENOMINACION, a.coddptodepende, b.coddpto, b.denominacion FROM DPTO a, DPTO b
where a.coddptodepende = b.coddpto;

/*24 Obtener un listado ordenado alfabéticamente donde aparezcan los nombres
de los empleados y a continuación el literal "tiene comisión" si la tiene,y "no tiene comisión" si no la tiene.*/
SELECT APE1,NOMBRE, APE2, 
CASE 
    WHEN COMISION IS NULL THEN 'NO TIENE COMISION'
    ELSE 'TIENE COMISION'
END AS ESTADOdeComision
FROM EMPLEADO
ORDER BY APE1, NOMBRE;



/*25  Obtener un listado de las localidades en las que hay centros y no vive ningún empleado ordenado alfabéticamente.*/
SELECT LOCALIDAD FROM CENTRO
WHERE UPPER(LOCALIDAD) NOT IN (SELECT UPPER(LOCALIDAD) FROM EMPLEADO);


/*26 Obtener un listado de las localidades en las que hay centros y 
además vive al menos un empleado ordenado alfabéticamente.*/
/*Dos maneras de hacer el ejercicio*/
SELECT LOCALIDAD FROM CENTRO
WHERE UPPER(LOCALIDAD) IN (SELECT UPPER(LOCALIDAD) FROM EMPLEADO WHERE CODEMPLE >1)
ORDER BY LOCALIDAD;

SELECT DISTINCT(UPPER(LOCALIDAD)) FROM EMPLEADO 
WHERE CODEMPLE >=1 AND LOCALIDAD IN (SELECT UPPER(LOCALIDAD) FROM CENTRO)
GROUP BY LOCALIDAD;
/*El ejercicio 27 y 28 se han realizado conjuntamente*/

/*27 Esta cuestión puntúa por 2. 
Se desea dar una gratificación por navidades en función de la antigüedad en la empresa 
siguiendo estas pautas:

    Si lleva entre 1 y 5 años, se le dará 100 euros
    Si lleva entre 6 y 10 años, se le dará 50 euros por año
    Si lleva entre 11 y 20 años, se le dará 70 euros por año
    Si lleva más de 21 años, se le dará 100 euros por año*/

SELECT APE1, NOMBRE, APE2, ROUND(((months_between(SYSDATE,FECHAINGRESO))/12),0) AS Antiguedad,
CASE 
    WHEN ROUND(((months_between(SYSDATE,FECHAINGRESO))/12),0) BETWEEN 1 AND 5 THEN '100 euros'
    WHEN ROUND(((months_between(SYSDATE, FECHAINGRESO))/12),0) BETWEEN 6 AND 10 THEN '50 euros por anio'
    WHEN ROUND(((months_between(SYSDATE, FECHAINGRESO))/12),0) BETWEEN 11 AND 20 THEN '70 euros por anio'
    ELSE '100 euros por anio' 
END as Gratificacion 
FROM empleado
Order by APE1, NOMBRE;    


 /*28 Obtener un listado de los empleados,ordenado alfabéticamente,
indicando cuánto le corresponde de gratificación.*/

    
SELECT APE1, NOMBRE, APE2, ROUND(((months_between(SYSDATE,FECHAINGRESO))/12),0) AS Antiguedad,
CASE 
    WHEN ROUND(((months_between(SYSDATE,FECHAINGRESO))/12),0) BETWEEN 1 AND 5 THEN (100)
    WHEN ROUND(((months_between(SYSDATE, FECHAINGRESO))/12),0) BETWEEN 6 AND 10 THEN (50*ROUND(((months_between(SYSDATE, FECHAINGRESO))/12),0))
    WHEN ROUND(((months_between(SYSDATE, FECHAINGRESO))/12),0) BETWEEN 11 AND 20 THEN (70*ROUND(((months_between(SYSDATE, FECHAINGRESO))/12),0))
    ELSE (100*ROUND(((months_between(SYSDATE, FECHAINGRESO))/12),0)) 
END as Gratificacion 
FROM empleado
Order by APE1, NOMBRE;

/*29 Obtener a los nombres, apellidos de los empleados que no son jefes de departamento.*/
SELECT NOMBRE, APE1, APE2, CODEMPLE, CODEMPLEJEFE FROM EMPLEADO
LEFT JOIN DPTO ON
EMPLEADO.CODEMPLE = dpto.codemplejefe
WHERE CODEMPLE NOT IN (SELECT dpto.codemplejefe FROM DPTO);
