<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<@c.common page="main">
    <div class="wrapper">
            <div class="info">
                <p><strong>Имя: </strong>${user.firstName}</p>
                <p><strong>Фамилия: </strong>${user.lastName}</p>
                <p><strong>Пол: </strong>${user.gender}</p>
                <p><strong>Дата рождения: </strong>${user.birthday?string("dd.MM.yyyy")}</p>
                <p><strong>Телефон: </strong>${user.phone}</p>
                <p><strong>Почта: </strong>${user.email}</p>
            </div>
            <a href="profile/editPerson" class="button-link">редактировать</a>
    </div>
</@c.common>