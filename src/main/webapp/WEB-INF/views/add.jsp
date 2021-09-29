<html>
    <title>Add new student</title>
    <body>
    <br>
    <br>
        <h1 align="center">Add new student</h1>
    <br>
    <div align="center">
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
        <br>
        <br>
        <a href="main-servlet">Come back</a>
    </div>
    </body>
</html>