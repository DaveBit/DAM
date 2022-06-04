(:El nombre (sin etiquetas) de los artistas que nacieron antes de 1500.:)

for $s in doc("artistas.xml")/artistas/artista
where number($s/nacimiento)<1500
return data($s/nombreCompleto)

(:
En este caso hemos hecho un loop por artista, 
comprobado que el nacimiento era menor a 1500
he impreso el nombre completo
Tambien hemos usado la funcion number para evitar errores en los tipos de datos
:)