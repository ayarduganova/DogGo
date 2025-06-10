<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<#include "../PARTS/menu.ftl">
<@c.common page="main" css="/css/ProfilePageStyle.css">
    <div class="wrapper">
        <div class="title">Это вы! И это прекрасно)</div>
        <div class="info">
            <p><strong>Имя </strong>${user.firstName}</p>
            <p><strong>Фамилия </strong>${user.lastName}</p>
            <p><strong>Пол </strong>${user.gender}</p>
            <p><strong>Дата рождения </strong>${user.birthday?string("dd.MM.yyyy")}</p>
            <p><strong>Телефон </strong>${user.phone}</p>
            <p><strong>Почта </strong>${user.email}</p>
        </div>

        <div>
            <div class="title">Данные вашего питомца</div>
            <#if dog??>
                <form action="/profile/editDog" method="post">
                    <p><strong>Кличка </strong><input type="text" name="name" value="${dog.name}" required></p>
                    <p><strong>Месяц рождения </strong><input type="number" name="birthMonth" value="${dog.birthMonth}" required></p>
                    <p><strong>Год рождения </strong><input type="number" name="birthYear" value="${dog.birthYear}" required></p>
                    <p><strong>Порода </strong><input type="text" name="breed" value="${dog.breed}" required></p>

                    <p>${message!}</p>

                    <button type="submit" class="button-link">Сохранить</button>
                    <button onclick="history.back()" class="button-link">Назад</button>
                    <input type="hidden" value="${dog.id}" name="dogId">
                </form>
            <#else>
                <form method="post">
                    <p><strong>Кличка </strong><input type="text" name="name" placeholder="кличка" required></p>
                    <p><strong>Месяц рождения </strong><input type="number" name="birthMonth" required></p>
                    <p><strong>Год рождения </strong><input type="number" name="birthYear" required></p>
                    <p><strong>Порода </strong><input type="text" name="breed" placeholder="порода" required></p>

                    <p>${message!}</p>

                    <button type="submit" class="button-link">Сохранить</button>
                    <button onclick="history.back()" class="button-link">Назад</button>
                </form>
            </#if>

        </div>
    </div>

</@c.common>