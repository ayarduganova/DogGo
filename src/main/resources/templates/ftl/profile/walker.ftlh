<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<@c.common page="main" css=" ">
    <div class="wrapper">
        <p>Имя: ${user.firstName}</p>
        <p>Фамилия: ${user.lastName}</p>
        <p>Телефон: ${user.phone}</p>
        <p>Почта: ${user.email}</p>
        <p>Опыт работы: ${walker.workExperience}</p>
        <p>Район работы: ${walker.workArea}</p>
        <p>Цена: ${walker.price}</p>

        <h3>Расписание:</h3>
        <div class="schedule">
            <p><strong>Понедельник:</strong>
                <#if walker.schedule.mondayFrom?? && walker.schedule.mondayTo??>
                    ${walker.schedule.mondayFrom} - ${walker.schedule.mondayTo}
                <#else>
                    Выходной
                </#if>
            </p>

            <p><strong>Вторник:</strong>
                <#if walker.schedule.tuesdayFrom?? && walker.schedule.tuesdayTo??>
                    ${walker.schedule.tuesdayFrom} - ${walker.schedule.tuesdayTo}
                <#else>
                    Выходной
                </#if>
            </p>

            <p><strong>Среда:</strong>
                <#if walker.schedule.wednesdayFrom?? && walker.schedule.wednesdayTo??>
                    ${walker.schedule.wednesdayFrom} - ${walker.schedule.wednesdayTo}
                <#else>
                    Выходной
                </#if>
            </p>

            <p><strong>Четверг:</strong>
                <#if walker.schedule.thursdayFrom?? && walker.schedule.thursdayTo??>
                    ${walker.schedule.thursdayFrom} - ${walker.schedule.thursdayTo}
                <#else>
                    Выходной
                </#if>
            </p>

            <p><strong>Пятница:</strong>
                <#if walker.schedule.fridayFrom?? && walker.schedule.fridayTo??>
                    ${walker.schedule.fridayFrom} - ${walker.schedule.fridayTo}
                <#else>
                    Выходной
                </#if>
            </p>

            <p><strong>Суббота:</strong>
                <#if walker.schedule.saturdayFrom?? && walker.schedule.saturdayTo??>
                    ${walker.schedule.saturdayFrom} - ${walker.schedule.saturdayTo}
                <#else>
                    Выходной
                </#if>
            </p>

            <p><strong>Воскресенье:</strong>
                <#if walker.schedule.sundayFrom?? && walker.schedule.sundayTo??>
                    ${walker.schedule.sundayFrom} - ${walker.schedule.sundayTo}
                <#else>
                    Выходной
                </#if>
            </p>
        </div>
        <input type="hidden" value="${walker.id}" name="requestId">

    </div>

</@c.common>