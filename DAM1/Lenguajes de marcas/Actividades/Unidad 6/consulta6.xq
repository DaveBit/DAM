(:
Modelo de las impresoras de tipo “láser”.
:)

for $s in doc("impresoras.xml")/impresoras/impresora
where $s[@tipo="láser"]
return $s/modelo

(:
1.Iteramos sobre los elementos impresora. 
2.Donde el atributo @tipo es igual a laser. 
3.Si esto se cumple, entonces devolvemos el modelo. 
:)