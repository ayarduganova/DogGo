<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as m>
<@m.common page="admin" css="/css/admin.css">
    <div class="wrapper">
        <h1>Запросы</h1>
        <#if requests?size != 0>
            <#list requests as walker, user>
                <form method="post">
                    <div class="request">
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

                        <button type="submit" class="btn" name="action" value="approve">Одобрить</button>
                        <button type="submit" class="btn" name="action" value="reject">Отклонить</button>
                    </div>
                </form>
            </#list>
        <#else>
            <p>Список запросов пуст</p>
        </#if>
    </div>

</@m.common>