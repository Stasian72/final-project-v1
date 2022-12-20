<html>
<head>
    <title>Home Page</title>
</head>
<body>

<form action="/api/v2/books" method="get">
    <p>Получить все книги:</p>
    <input type="submit", placeholder="Получить все книги">
    <p>-----------------</p>

    <p>Получить Книгу по Автору:</p>

    <input name="author" type="text" placeholder="enter author">
    <input type="submit">
    <p>-----------------</p>
</form>


</form>




<form action="/api/v2/books/new" method="pu">
    <p> Создать новую книгу</p>
    <input name="name" type="text" placeholder="enter name">
    <input name="author" type="text" placeholder="enter author">
    <input name="iban" type="number" placeholder="enter iban">
    <input type="submit">
    <p>-----------------</p>


</form>

<form action="/api/v2/books/put" method="post">
    <p> Изменить существующую книгу</p>
    <input name="id" type="number" placeholder="enter id">
    <input name="name" type="text" placeholder="enter name">
    <input name="author" type="text" placeholder="enter author">
    <input name="iban" type="number" placeholder="enter iban">
    <input type="submit">
    <p>-----------------</p>


</form>





</body>
</html>