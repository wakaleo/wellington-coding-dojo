<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ page import="co.nz.codingdojo.tweeter.domain.TweeterUser"  %>

<%
    TweeterUser tweeter = (TweeterUser) session.getAttribute("tweeterUser");
%>

<html>
<head>
<title><f:message key="app.title" /></title>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header" />
<h2><f:message key="app.caption" /></h2>
<p><em>Version <f:message key="app.version" /></em></p>
</div>
<div class="content">

<h3><f:message key="app.signup" /></h3>
<form name="signup" method="post" action="signup">
<table border="0">
	<tr><td>Username</td></tr>
	<tr><td><input name="username" type="text"></td></tr>
	<tr><td>Password</td></tr>
	<tr><td><input name="password" type="text"></td></tr>
	<tr><td>${errorMessage}</td></tr>
	<tr><td><input name="action" value="Sign up" type="submit"/></td></tr>
</table>
</form>
</div>
</body>
</html>