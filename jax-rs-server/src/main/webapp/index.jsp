<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>JAX-RS</title>
  </head>
  <body>
    <h1>Startseite von JAX-RS</h1>
    <ul>
        <li><a href="api/basic/ping;info=test?s=kleiner Test">Ping-Test</a></li>
         
        <li><a href="api/context/uri-info?auswahl=eins&test=nein&auswahl=sieben">UrlInfo</a></li> 
        <li><a href="api/context/http-headers">HttpHeaders</a></li> 
        <li><a href="api/context/request">Request</a></li> 
        <li><a href="api/context/security-context">SecurityContext (Ben, g@nzGeheim1)</a></li>
        <li><a href="api/context/providers">Providers</a></li>
        <li><a href="api/basic/images/wtf-code.jpg">Bilder</a></li>
        <li><a href="api/basic/daten">Daten-Objekt</a></li>
        <li>Datei-Download: <a href="api/datei?laenge=500&typ=txt">Text</a> und <a href="api/datei?laenge=500&typ=zip">Gezippt</a></li>

        
    </ul>
    <form action="api/basic/x-plus-y" method="POST">
    X: <input type="text" name="x" size="5"/> Y: <input type="text" name="y" size="5"/>
    <input type="submit" value=" = "/> 
    </form>

    <a href="api/application.wadl">Übersicht der Services</a>
  </body>
</html> 
