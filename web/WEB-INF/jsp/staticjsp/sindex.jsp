<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Spring Landing Page</title>
</head>
<body>

<h2>Spring Landing Page</h2>
<p>click below button to get a simple html page</p>
<form:form method="GET" action="/staticPage">
    <table>
        <tr>
            <input type="submit" value="GET HTML"/>
        </tr>
    </table>
</form:form>
</body>
</html>