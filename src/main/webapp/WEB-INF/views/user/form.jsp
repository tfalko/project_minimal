<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Falko
  Date: 19/04/2020
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="user" method="post">
    <form:hidden path="id" />
    <div class="form-group">
        <label for="firstName">First name</label>
        <form:input path="firstName" cssClass="form-control" id="firstName" placeholder="Enter first name" />
        <form:errors path="firstName" /><br>
    </div>
    <div class="form-group">
        <label for="lastName">Last name</label>
        <form:input path="lastName" cssClass="form-control" id="lastName" placeholder="Enter last name" />
        <form:errors path="lastName" /><br>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input path="email" cssClass="form-control" id="email" placeholder="Enter email" />
        <form:errors path="email" /><br>
    </div>
    <button type="submit" class="btn btn-primary">Send</button>
</form:form>
</body>
</html>
