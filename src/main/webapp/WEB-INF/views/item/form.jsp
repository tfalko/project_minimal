<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Falko
  Date: 19/04/2020
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="item" method="post">
    <form:hidden path="id" />
    <div class="form-group">
    <label for="name">name</label>
    <form:input path="name" cssClass="form-control" id="name" placeholder="Enter name" />
    <form:errors path="name" /><br>
    </div>
    <div class="form-group">
    <label for="importance">Importance</label>
    <form:select path="importance" cssClass="form-control" id="importance" placeholder="Enter importance" >

        <form:option value="1"> 1 </form:option>
        <form:option value="2" > 2 </form:option>
        <form:option value="3" > 3 </form:option>
    <form:errors path="importance" /><br>
        </form:select>
    </div>
    <div class="form-group">
    <label for="category.id">category</label>
    Category: <form:select items="${categories}" path="category.id" itemValue="id" itemLabel="name" />
    <form:errors path="category" cssClass="error" /><br>
    </div>

    <button type="submit" class="btn btn-primary">Send</button>
</form:form>
</body>
</html>
