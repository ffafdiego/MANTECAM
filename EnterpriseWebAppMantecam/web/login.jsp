<%-- 
    Document   : login
    Created on : 16-08-2013, 01:31:43 PM
    Author     : Pablitolog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <p>Ingresar nombre de usuario y contraseña</p>
        <form method="POST" action="j_security_check">
            <table cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td aling="right">Nombre de Usuario:&nbsp;</td>
                    <td>
                        <input type="text" name="j_username">
                    </td>
                </tr>   
                <tr>
                    <td aling="right">Contraseña:&nbsp;</td>
                    <td>
                        <input type="password" name="j_password">
                    </td>                 
                </tr>    
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>   
            </table>     
        </form>
    </body>
</html>
