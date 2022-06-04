<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8"/>
  <xsl:template match="/">
    <html>
      <head>
        <title>Ejercicio XSLT - Artistas</title>
        <h1 align="Center">Ejercicio XSLT - Artistas</h1>
      </head>
      <body>
        <table border="1" align="Center">
          <tr style="text-align:center">
            <th>Código</th>
            <th>Nombre</th>
            <th>Año de nacimiento</th>
            <th>Año de fallecimiento</th>
            <th>Pais</th>
            <th>Pagina web</th>
          </tr>
          <xsl:for-each select="artistas/artista[nacimiento&gt;1500]">
            <xsl:sort select="nacimiento" order="ascending"/>
            <tr>
              <td>
                <xsl:value-of select="@cod"/>
              </td>
              <td>
                <xsl:value-of select="nombreCompleto"/>
              </td>
              <td>
                <xsl:value-of select="nacimiento"/>
              </td>
              <xsl:choose>
                <xsl:when test="fallecimiento !=' '">
                  <td>
                    <xsl:value-of select="fallecimiento"/>
                  </td>
                </xsl:when>
                <xsl:otherwise>
                  <td>"Desconocido"</td>
                </xsl:otherwise>
              </xsl:choose>
              <td>
                <xsl:value-of select="pais"/>
              </td>
              <td>
                <a href="{fichaCompleta}">Saber más</a>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
