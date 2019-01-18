<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="!isAuthenticated()">
    Hello anonymous.
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    Hello logged-in user. Guess your name is <sec:authentication property="name"/>.
</sec:authorize>