<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Spring Page Redirection</title>
</head>
<body>

<h2>Spring Page Redirection</h2>
<p>click below button to redirect the result to new page</p>
<form:form method="GET" action="/redirect">
    <table>
        <tr>
            <input type="submit" value="Redirect Page"/>
        </tr>
    </table>
</form:form>
</body>
</html>