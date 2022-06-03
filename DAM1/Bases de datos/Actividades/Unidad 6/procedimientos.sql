create or replace PROCEDURE cambiarAgentesFamilia(id_familiaOrigen agentes.familia%TYPE, id_familiaDestino agentes.familia%TYPE)
IS
TYPE CURSOR_VARIABLE_AGENTES IS REF CURSOR RETURN AGENTES%ROWTYPE;
CAGENTES CURSOR_VARIABLE_AGENTES;
VAGENTES CAGENTES%ROWTYPE;
AGENTES_CAMBIADOS NUMBER(2) :=0;
MISMO_VALOR EXCEPTION;
ORIGEN_NOTFOUND EXCEPTION;
DESTINO_NOTFOUND EXCEPTION;

BEGIN
--Comprobamos que el id origen y destino no es el mismo. 
IF id_familiaOrigen = id_familiaDestino THEN
    RAISE MISMO_VALOR;
END IF;
--Ahora comprobamos que el id de Origen esta presente. 
OPEN CAGENTES FOR SELECT * FROM AGENTES WHERE FAMILIA = id_familiaOrigen;
FETCH CAGENTES INTO VAGENTES;
IF CAGENTES%NOTFOUND THEN
 RAISE ORIGEN_NOTFOUND;
END IF;

--comprobacion de que el id de destino existen
FETCH CAGENTES INTO VAGENTES;
IF CAGENTES%NOTFOUND THEN
    RAISE DESTINO_NOTFOUND;
END IF;

CLOSE CAGENTES;

OPEN CAGENTES FOR SELECT * FROM AGENTES WHERE FAMILIA = id_familiaOrigen;
FETCH CAGENTES INTO VAGENTES;
WHILE CAGENTES%FOUND LOOP
AGENTES_CAMBIADOS := AGENTES_CAMBIADOS +1;
FETCH CAGENTES INTO VAGENTES;
END LOOP;
CLOSE CAGENTES;

UPDATE AGENTES SET FAMILIA = id_familiadestino WHERE FAMILIA = id_familiaOrigen;
COMMIT;
dbms_output.put_line('Se han trasladado ' || AGENTES_CAMBIADOS || 'agentes de la familia ' || id_familiaOrigen || ' a la familia ' || id_familiaDestino);

EXCEPTION
WHEN MISMO_VALOR THEN
    RAISE_APPLICATION_ERROR (-7777, 'Se ha introducido un id de origen y un id de destino igual');
WHEN ORIGEN_NOTFOUND THEN
    RAISE_APPLICATION_ERROR (-7778,'No se ha encontrado el id de origen');
WHEN DESTINO_NOTFOUND THEN
    RAISE_APPLICATION_ERROR (-7779, 'No se ha encontrado el id de destino');
WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE ('Alguna otra cosa fue mal');

END;
