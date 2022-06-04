(:
Marca y modelo de las impresoras con tamaño A3 como único tamaño .
:)

for $s in doc("impresoras.xml")/impresoras/impresora
where $s/tamaño ="A3" and count($s/tamaño)=1
return ($s/marca,$s/modelo)

(:
1. Iteremos por los elementos impresora. 
2. A diferencia de la consulta anterior, esta vez ponemos una segunda condicion. Que solo haya un elemento tamanio ademas del previamente establecido, que indica que tamanio debe contener A3.
3. Despues, imprimimos marca y modelo. 
:)
