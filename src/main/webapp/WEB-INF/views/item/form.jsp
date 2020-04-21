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
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">Dis-abled</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Add Stuff</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="/item/form">Add Item</a>
                    <a class="dropdown-item" href="#">Add Category</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<main role="main" class="container">
    <div class="jumbotron">

        <form:form modelAttribute="item" method="post">
            <form:hidden path="id"/>
            <form:hidden path="user.id"/>
        <div class="form-group rowColor">
            <label for="name" class="col-sm-2 col-form-label">name</label>
            <div class="col-sm-10">
                <form:input path="name" cssClass="form-control" id="name" placeholder="Enter name"/>
                <form:errors path="name"/><br>
            </div>
        </div>
        <div class="form-group rowColor">
            <label for="importance" class="col-sm-2 col-form-label">Importance</label>
            <div class="col-sm-10">
                <form:select path="importance" cssClass="form-control" id="importance" placeholder="Enter importance">
                    <form:option value="1"> 1 </form:option>
                    <form:option value="2"> 2 </form:option>
                    <form:option value="3"> 3 </form:option>
                    <form:option value="4"> 4 </form:option>
                    <form:option value="5"> 5 </form:option>
                    <form:option value="6"> 6 </form:option>
                    <form:option value="7"> 7 </form:option>
                    <form:option value="8"> 8 </form:option>
                    <form:option value="9"> 9 </form:option>
                    <form:option value="10"> 10 </form:option>
                    <form:errors path="importance"/><br>
                </form:select>
            </div>
        </div>
        <div class="form-group rowColor">
            <label for="category.id" class="col-sm-2 col-form-label">category</label>
            <div class="col-sm-10">
                <form:select items="${categories}" path="category.id" itemValue="id" itemLabel="name"/>
                <form:errors path="category" cssClass="error"/><br>
            </div>
        </div>
        <div class="form-group rowColor">
            <label for="description" class="col-sm-2 col-form-label">description</label>
            <div class="col-sm-10">
                <form:textarea path="description" cssClass="form-control" id="description" placeholder="describe your item"/>
                <form:errors path="description"/><br>
            </div>
        </div>
                <button type="submit" class="btn btn-primary">Add item</button>
                </form:form>

            </div>

</main>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="/docs/4.4/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>
