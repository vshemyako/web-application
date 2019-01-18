<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Greeting Application</title>
</head>
<body>
<p>Say <a href="greet">Hello</a></p>

<form method="post" action="greet">
    <sec:csrfInput/>
    <h3>Type in your name:</h3>
    <input type="text" id="greet-text-input" name="name"/>
    <input type="submit" id="greet-button" value="Greet Me!"/>
</form>
</body>
</html>