(:
Una lista HTML con el nombre de los artistas nacidos en España.
:)

<ul>
{
for $s in doc("artistas.xml")/artistas/artista
where $s/pais = "España"
return <li>{data($s/nombreCompleto)}</li>
}
</ul>

(:
1. Hemos usado las etiquetas <ul></ul> para crear la lista html. 
2. Hemos iterado por los artistas con la condicion de que el pais se Espania. 
3. Hemos devuelto mediante las etiques <li></li> la informacion "data" contenida en nombreCompleto.
:)