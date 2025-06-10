<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as m>
<@m.common page="admin" css="/css/admin.css" >
    <a class="req" href="../admin/requests">Запросы</a>

    <div class="table-wrap">
        <table class="table">
            <thead>
            <tr>
                <th>Имя пользователя</th>
                <th>Роли</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <#list users! as user>
                <tr class="${user.active?string('', 'inactive')}">
                    <td>${user.username}</td>
                    <td>
                        <#if user.active>
                            <#list user.roles as role>${role}<#sep>, </#list>
                        <#else>
                            пользователь заблокирован
                        </#if>
                    </td>
                    <td><a href="./user/${user.id}">изменить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

</@m.common>