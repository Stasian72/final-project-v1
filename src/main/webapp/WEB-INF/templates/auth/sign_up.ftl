<html>
<head>
    <title>Home Page</title>
</head>
<body>
<#-- вызываем метод POST адресу /users/new -->
<form action="/api/v3/sign_up" method="post">
    <p> Зарегистрировать нового владельца:</p>
    <input name="ownerName" type="text" placeholder="enter name">
    <input name="email" type="email" placeholder="enter email">
    <input name="password" type="password" placeholder="enter password">
    <input type="submit">
</form>
</body>
</html>