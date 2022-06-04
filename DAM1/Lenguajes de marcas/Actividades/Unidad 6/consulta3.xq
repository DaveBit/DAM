(:Nombre de los artistas para los que no hay año de fallecimiento.:)

for $s in doc("artistas.xml")/artistas/artista
where empty($s/fallecimiento)
return $s/nombreCompleto

(:
Aqui hemos evaluado a cada artista y si la secuencia dada no contenia ningun elemento entonces hemos devuelto el nombre del artista
:)