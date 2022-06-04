(:
Modelo de las impresoras en red.
:)

for $s in doc("impresoras.xml")/impresoras/impresora
where $s/enred
return $s/modelo

(:
1. iteramos por los objetos impresoras
2. queremos que estos elementos tengan el elemento enred, si no lo tienen, no seran filtrados.
3. Imprimimos el modelo. 
:)