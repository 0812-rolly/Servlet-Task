<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filtering the list</title>
</head>
<body>
<div align="center">
<form action="list-servlet" method="get">
    <br>
    <br>
    <div>
        <label for="blockchain">Filter by blockchain value</label>
        <input type="checkbox" id="blockchain" name="blockchainFilter" value="blockchainFilter">
    </div>
    <br>
    <div>
        <label for="averageMark">Filter by average mark value</label>
        <input type="checkbox" id="averageMark" name="averageMarkFilter" value="averageMarkFilter">
    </div>
<br>
    <input type="submit" value="View student list" />
</form>
</div>
</body>
</html>
