<html>
    <title>Add new student</title>
    <body>
        <h1>Add new student</h1>
    <form action="add-servlet" method="post">
        <div class="fields">
            <label for="name">Name</label>
            <input id="name" type="text" name="name"/>
        </div>
        <br>
        <div class="fields">
            <label for="averageMark">Average mark</label>
            <input id="averageMark" type="text" name="averageMark"/>
        </div>
        <br>
        <div class="fields">
            <label for="blockchain">Knows Blockchain</label>
            <input id="blockchain" type="checkbox" name="blockchain"/>
        </div>
        <br>
        <input type="submit" value="Submit" />
    </form>
    <a href="main-servlet">Come back</a>
    </body>
</html>