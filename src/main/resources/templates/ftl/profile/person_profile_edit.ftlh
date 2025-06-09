<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<@c.common page="main">
    <div class="wrapper">
        <form method="post">
                <div class="info">
                    <p><strong>Имя: </strong><input type="text" name="firstName" value="${user.firstName}" required></p>
                    <p><strong>Фамилия: </strong><input type="text" name="lastName" value="${user.lastName}" required></p>
                    <p><strong>Пол: </strong><input type="text" name="gender" value="${user.gender}" required></p>
                    <p><strong>Дата рождения: </strong><input type="date" name="birthday" value="${user.birthday}" required></p>
                    <p><strong>Почта: </strong><input type="email" name="email" value="${user.email}" required></p>
                    <p><strong>Телефон: </strong><input type="tel" name="phone" value="${user.phone}" required></p>
                </div>

                <p>${message!}</p>
                <button type="submit" class="button-link">cохранить</button>
                <button onclick="history.back()" class="button-link">Назад</button>
        </form>
    </div>
</@c.common>