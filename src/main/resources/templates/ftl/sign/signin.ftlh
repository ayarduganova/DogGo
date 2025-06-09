<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<@c.common page="Sign in">
    <form method="post" >
        <div>Login: <input type="text" name="username"></div>
        <div>Password: <input type="text" name="password"></div>
        <input type="submit" value="Sign in">
        <p>${message!}</p>
        <a href="./signUp">Зарегистрироваться</a>
    </form>
</@c.common>
