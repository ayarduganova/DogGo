<#import "../PARTS/common.ftlh" as m>
<#include "../PARTS/menu.ftl">
<@m.common page="main" css=" ">
    <div class="wrapper">

        <#if requests?size != 0>
            <#list requests as req>
                <div class="request">
                    <p>Выгульщик: ${req.walker.user.firstName} ${req.walker.user.lastName}</p>
                    <p>Дата и время: ${req.walkDateTime}</p>
                    <p>Длительность: ${req.duration}</p>
                </div>
            </#list>
        <#else>
            <p>Вы ещё ничего не бронировали </p>
        </#if>

    </div>
</@m.common>