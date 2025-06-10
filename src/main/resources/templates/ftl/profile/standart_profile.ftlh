<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<#include "../PARTS/menu.ftl">
<@c.common page="Профиль" css="/css/ProfilePageStyle.css">
    <div class="wrapper">
            <div class="title">Это вы! И это прекрасно)</div>
            <div class="info">
                <p><strong>Имя </strong>${user.firstName}</p>
                <p><strong>Фамилия </strong>${user.lastName}</p>
                <p><strong>Пол </strong>${user.gender}</p>
                <p><strong>Дата рождения </strong>${user.birthday?string("dd.MM.yyyy")}</p>
                <p><strong>Телефон </strong>${user.phone}</p>
                <p><strong>Почта </strong>${user.email}</p>
                <a href="profile/editProfile" class="button-link">Редактировать профиль</a>
            </div>

            <form method="get" action="/profile/addDog">
                <div class="title">Тут вы можете добавить вашу собаку</div>
                <#list dogs! as dog>
                    <div class="dog-info">
                        <p><strong>Кличка </strong>${dog.name}</p>
                        <p><strong>Месяц рождения </strong>${dog.birthMonth}</p>
                        <p><strong>Год рождения </strong>${dog.birthYear}</p>
                        <p><strong>Порода </strong>${dog.breed}</p>
                        <a href="./profile/editDog/${dog.id}" class="button-link">Редактировать</a>
                    </div>
                </#list>
                <button type="submit" class="plus-button">Добавить собаку</button>
            </form>
        </div>
</@c.common>