(:Nombre y país de todos los artistas.:)

for $s in doc("artistas.xml")/artistas/artista
return ($s/nombreCompleto, $s/pais)


(:Para cada artista devolvemos, con etiquetas, 
el nombre y el pais con una variable que hemos llamado s:)

(:En caso de hacerlo sin etiquetas utilizariamos la siguiente expresion

return ($s/nombreCompleto, $s/pais)

:)