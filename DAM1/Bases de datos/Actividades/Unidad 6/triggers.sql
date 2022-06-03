CREATE OR REPLACE TRIGGER RESTRICCIONES_AGENTES
BEFORE INSERT OR UPDATE ON AGENTES
FOR EACH ROW
DECLARE
   mensaje_error VARCHAR2(1000);
   fallo_encontrado BOOLEAN;
BEGIN
mensaje_error :='';
fallo_encontrado := false;
--La longitud de la clave de un agente no puede ser inferior a 6.
IF (:new.clave < 6) THEN
    mensaje_error := mensaje_error || '{La clave no puede ser menor que 6}';
    fallo_encontrado := true;
END IF;
--  La habilidad de un agente debe estar comprendida entre 0 y 9 (ambos inclusive).
IF (:new.habilidad >9 or :new.habilidad <0) THEN
   mensaje_error := mensaje_error || 'El nivel de habilidad deber ser entre 0 y 9';
   fallo_encontrado := true;
END IF;
--La categoría de un agente sólo puede ser igual a 0, 1 o 2.
IF (:new.categoria < 0 or :new.categoria>2) THEN
    mensaje_error := mensaje_error ||'La categoria debe ser, 0, 1 o 2';
    fallo_encontrado := true;
END IF;
-- Si un agente tiene categoría 2 no puede pertenecer a ninguna familia y debe pertenecer a una oficina.  
IF (:new.categoria = 2 and (:new.familia IS NOT NULL or :new.oficina IS NULL)) THEN
    mensaje_error := mensaje_error ||'Un agente nivel 2, no puede pertenecer a ninguna familia y debe ademas, pertenecer a una oficina';
    fallo_encontrado := true;
END IF;
  --Si un agente tiene categoría 1 no puede pertenecer a ninguna oficina y debe pertenecer  a una familia. 
IF (:new.categoria = 1 and (:new.familia IS NULL or :new.oficina IS NOT NULL)) THEN
    mensaje_error := mensaje_error ||'Un agente categoria 1, debe pertener a una familia y no pertenecer a ninguna oficina';
    fallo_encontrado := true;
END IF;
   -- Todos los agentes deben pertenecer  a una oficina o a una familia pero nunca a ambas a la vez.
IF (:new.familia IS NOT NULL and :new.oficina IS NOT NULL) THEN
    mensaje_error := mensaje_error || 'Un agente no puede pertenecer a una familia y una oficina a la vez';
    fallo_encontrado := true;
END IF;
IF (fallo_encontrado = true) THEN
    RAISE_APPLICATION_ERROR(-20000, mensaje_error);
END IF;
END;


