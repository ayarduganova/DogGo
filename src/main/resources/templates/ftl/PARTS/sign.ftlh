<#macro signin message button href textForHref >
    <form method="post" >
        <div>Login: <input type="text" name="username"></div>
        <div>Password: <input type="text" name="password"></div>
        <input type="submit" value="${button}">
        <p>${message}</p>
        <a href=${href}>${textForHref}</a>
    </form>
</#macro>