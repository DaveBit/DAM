(:
El número de artistas nacidos antes de 1600.
:)

for $s in doc("artistas.xml")/artistas
let $x := $s/artista[number(nacimiento)<1600]
return count($x)

(:
1. Hemos iterado por los artistas. 
2. hemos usado la clausula let de modo que el resultado de la expresion se vincula con la variable x. 
Al estar en un for, se anade a las tuplas(lineas) generadas por el loop.En este caso, 3 artistas se juntan en la variable x. 
4. Como solo queremos la cuenta, utilizamos la funcion count sobre la variable X, la cual determina el numero de items en una collecion. 
:)