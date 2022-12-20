<html>
<head>
    <title>Books</title>
</head>
<body>
<#-- во View users мы ищем аттрибут usersAttr и подставляем вместо аттрибута его значение список пользователей-->
<#if booksAttr?has_content>
    <ul>
        <#list booksAttr as book>
            <li> ${book.name} ${book.author} ${book.iban} ${book.owner}</li>
        </#list>
    </ul>
<#-- если нет пользователей в списоке -->
<#else >
    <p>No books</p>
</#if>
</body>
</html>
