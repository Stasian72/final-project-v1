<html>
<head>
    <title>Home Page</title>
</head>
<body>
<#-- вызываем метод POST адресу /users/new -->
<form action="/api/v3/books" method="get">
    <p>Получить все СВОИ книги:</p>
    <input type="submit", placeholder="Получить все книги">
    <p>-----------------</p>

    <p>Получить Книгу по Автору:</p>

    <input name="author" type="text" placeholder="enter author">
    <input type="submit">
    <p>-----------------</p>
</form>


<form action="/api/v3/books/new" method="post">
    <p> Создать новую книгу</p>
    <input name="name" type="text" placeholder="enter name">
    <input name="author" type="text" placeholder="enter author">
    <input name="iban" type="number" placeholder="enter iban">
    <input type="submit">
    <p>-----------------</p>


</form>


</body>
</html>