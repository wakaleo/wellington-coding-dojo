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
<% 
if (tweeter == null) {
%>
<h3><f:message key="app.login" /></h3>
<form name="login" method="post" action="login">
<table border="0">
	<tr><td>Username</td></tr>
	<tr><td><input name="username" type="text"></td></tr>
	<tr><td>Password</td></tr>
	<tr><td><input name="password" type="text"></td></tr>
	<tr><td>${errorMessage}</td></tr>
	<tr><td><input name="action" value="Sign in" type="submit"/></td></tr>
</table>
</form>
<%
} else {
%>

<h3>Hi <%=tweeter.getUsername()%>! <f:message key="app.utter.babble" /></h3>

<a href="/tweeter-web/logout">Logout</a>
<%
}
%>
</div>
</body>
</html>