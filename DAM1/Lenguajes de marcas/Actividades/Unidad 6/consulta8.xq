(:
Marca y modelo de las impresoras con tamaño A3 (pueden tener otros).
:)
for $s in doc("impresoras.xml")/impresoras/impresora
where $s/tamaño ="A3"
return ($s/marca,$s/modelo)

(:
1. Iteramos por los elementos impresora. 
2. La clausura where nos ayuda a identificar si hay un elemento tamanio que contiene A3. Hace de filtro. 
3. Si lo hay, se devuelve la marca y el modelo de esa impresora. 
:)