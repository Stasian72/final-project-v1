<html>
<#-- страница для логина -->
<head>
    <title>Login</title>
</head>
<body>
<#-- вызываем метод POST по адресу /login/process -->
<form action="/api/v3/login/process" method="post">

    <p> Введите данные для аутентификации</p>
    <div>
        Email: <input name="email" type="email">
    </div>
    <div>
        Password: <input name="password" type="password">
    </div>
    <input type="submit">
</form>
</body>
</html>