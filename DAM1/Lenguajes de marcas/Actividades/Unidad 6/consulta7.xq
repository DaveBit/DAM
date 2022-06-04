(:
Marca y modelo de las impresoras con más de un tamaño .
:)
for $s in doc("impresoras.xml")/impresoras/impresora
where count($s/tamaño)>1
return ($s/marca,$s/modelo)

(:
1. Iteramos por los elementos impresora. 
2. La clausura where nos ayuda a filtrar modelos con mas de un elemento tamanio. 
3. Si lo hay, se devuelve la marca y el modelo de esa impresora. 
:)