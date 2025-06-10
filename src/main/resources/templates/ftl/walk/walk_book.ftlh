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
                    <#if req.status == "PENDING">
                        <p class="status status-pending">
                            ⏳ Статус: Ожидает подтверждения выгульщиком
                        </p>
                        <a href="walker-books/confirm/${req.id}" class="button-link">Подтвердить</a>
                        <a href="walker-books/reject/${req.id}" class="button-link">Отклонить</a>
                    <#elseif req.status == "APPROVED">
                        <p class="status status-approved">
                            ✅ Статус: Подтверждено (выгул запланирован)
                            <#if req.walkDateTime??>
                                <span class="walk-date">На ${req.walkDateTime}</span>
                            </#if>
                        </p>
                    <#elseif req.status == "REJECTED">
                        <p class="status status-rejected">
                            ❌ Статус: Отклонено
                            <#if req.rejectionReason??>
                                <span class="rejection-reason">Причина: ${req.rejectionReason}</span>
                            </#if>
                        </p>
                    <#elseif req.status == "COMPLETED">
                        <p class="status status-completed">
                            ✔️ Статус: Успешно завершено
                            <#if req.completionDate??>
                                <span class="completion-date">${req.completionDate?date?string("dd.MM.yyyy")}</span>
                            </#if>
                        </p>
                    <#else>
                        <p class="status status-unknown">
                            Статус: Неизвестен (${req.status!})
                        </p>
                    </#if>
                </div>
            </#list>
        <#else>
            <p>Пока заявок нет(</p>
        </#if>

    </div>
</@m.common>