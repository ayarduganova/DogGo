<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<@c.common page="main" css=" ">
    <div class="wrapper">
            <div class="info">
                <p><strong>Имя: </strong>${user.firstName}</p>
                <p><strong>Фамилия: </strong>${user.lastName}</p>
                <p><strong>Пол: </strong>${user.gender}</p>
                <p><strong>Дата рождения: </strong>${user.birthday?string("dd.MM.yyyy")}</p>
                <p><strong>Телефон: </strong>${user.phone}</p>
                <p><strong>Почта: </strong>${user.email}</p>
            </div>
            <a href="profile/editProfile" class="button-link">редактировать</a>
    </div>

    <div>
        <form method="get" action="/profile/addDog">
        <div>
            <button type="submit" class="plus-button">+</button>
        </div>
        <#list dogs! as dog>
            <div class="dog-info">
                <p><strong>Имя: </strong>${dog.name}</p>
                <p><strong>Месяц рождения: </strong>${dog.birthMonth}</p>
                <p><strong>Год рождения: </strong>${dog.birthYear}</p>
                <p><strong>Порода: </strong>${dog.breed}</p>
                <a href="./profile/editDog/${dog.id}" class="button-link">редактировать</a>
            </div>
        </#list>
        </form>
    </div>

</@c.common>