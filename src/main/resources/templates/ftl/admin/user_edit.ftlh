<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as m>
<@m.common page="admin" css="/css/admin.css">
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
            <#list users! as userOrd>
                <#if user.username == userOrd.username>
                    <tr class="edit_tr">
                        <td>${userOrd.username}</td>
                        <td><form action="/admin/user" method="post">
                                <#if user.active>
                                    <div class="edit"><p>Пользователь активен.</p></div>
                                    <div class="edit"><p>Заблокировать ?</p></div>
                                    <div class="edit">
                                        <input type="radio" name="block_action" value="yes" id="yes_block" onchange="handleRoleVisibility(this)">
                                        <label for="yes">да</label>
                                        <input type="radio" name="block_action" value="no" id="no" onchange="handleRoleVisibility(this)" checked>
                                        <label for="no">нет</label>
                                    </div>
                                <#else>
                                    <div class="edit"><p>Пользователь неактивен.</p> </div>
                                    <div class="edit"><p>Разблокировать ?</p> </div>
                                    <div class="edit">
                                        <input type="radio" name="block_action" value="yes" id="yes" onchange="handleRoleVisibility(this)">
                                        <label for="yes">да</label>
                                        <input type="radio" name="block_action" value="no" id="no_block" onchange="handleRoleVisibility(this)" checked>
                                        <label for="no">нет</label>
                                    </div>
                                </#if>

                                <div class="edit" id="roleList">
                                    <#list roles as role>
                                        <div>
                                            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                                        </div>
                                    </#list>
                                </div>
                                <div class="edit">
                                    <button type="submit" value="save" name="btn_action">Сохранить изменения</button>
                                    <button type="submit" value="delete" name="btn_action">Удалить аккаунт</button>
                                </div>
                                <input type="hidden" value="${user.id}" name="userId">

                            </form>
                        </td>
                        <td></td>
                    </tr>
                <#else>
                    <tr class="${userOrd.active?string('', 'inactive')}">
                        <td>${userOrd.username}</td>
                        <td>
                            <#if userOrd.active>
                                <#list userOrd.roles as role>${role}<#sep>, </#list>
                            <#else>
                                пользователь заблокирован
                            </#if>
                        </td>
                        <td><a href="./${userOrd.id}">изменить</a></td>
                    </tr>
                </#if>
            </#list>
            </tbody>
        </table>
    </div>
    <script src="/js/edit_info.js" type="text/javascript"></script>
</@m.common>