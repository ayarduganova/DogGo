<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<@c.common page="Авторизация" css="../css/SignInStyle.css">
    <div class="app_title">DogGo</div>
    <form method="post">
        <div>Логин <input type="text" name="username"></div>
        <div>Пароль <input type="text" name="password"></div>
        <input type="submit" value="Войти">
        <p>${message!}</p>
        <a href="./signUp">Зарегистрироваться</a>
    </form>
</@c.common>
