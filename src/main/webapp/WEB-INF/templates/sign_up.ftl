<html>
<head>
    <title>Home Page</title>
</head>
<body>
<#-- вызываем метод POST адресу /users/new -->
<form action="/api/v2/books/new" method="post">
    <input name="name" type="text" placeholder="enter name">
    <input name="author" type="text" placeholder="enter author">
    <input name="iban" type="number" placeholder="enter iban">
    <input type="submit">
</form>
</body>
</html>
