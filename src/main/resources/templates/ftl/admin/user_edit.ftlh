<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<@c.common page="User edit">
    <form action="/admin/user/${user.id}" method="post">
        <input type="text" name="username" value="${user.username}">
        <#if user.active>
            <p>Пользователь активен.</p>
            <p>Заблокировать ?</p>
            <input type="radio" name="action" value="yes" id="yes">
            <label for="yes">да</label>
            <input type="radio" name="action" value="no" id="no" checked>
            <label for="no">нет</label>
        <#else>
            <p>Пользователь неактивен.</p>
            <p>Разблокировать ?</p>
            <input type="radio" name="action" value="yes" id="yes">
            <label for="yes">да</label>
            <input type="radio" name="action" value="no" id="no" checked>
            <label for="no">нет</label>
        </#if>

        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>

        <button type="submit">Save</button>
        <input type="hidden" value="${user.id}" name="userId">
    </form>
</@c.common>