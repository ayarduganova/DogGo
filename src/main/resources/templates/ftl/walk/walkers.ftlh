<#import "../PARTS/common.ftlh" as m>
<#include "../PARTS/menu.ftl">
<@m.common page="main" css="/css/Walker.css">
    <div class="wrapper">
        <div class="modal" id="modal">
            <form method="post" action="/walkers">
                <div class="modal_box">
                    <div class="modal_title">Отправьте заявку, чтобы стать выгульщиком</div>
                    <div class="modal_info">
                        <p><strong>Имя: </strong>${user.firstName}</p>
                        <p><strong>Фамилия: </strong>${user.lastName}</p>
                        <p><strong>Телефон: </strong>${user.phone}</p>
                        <p><strong>Почта: </strong>${user.email}</p>
                        <p><strong>Опыт работы: </strong><label>
                                <input type="text" name="workExperience" required/>
                            </label></p>
                        <p><strong>Район работы: </strong><label>
                                <input type="text" name="workArea" required/>
                            </label></p>
                        <p><strong>Цена: </strong><label>
                                <input type="number" name="price" required/>
                            </label></p>

                        <p><strong>Пн: </strong>
                            <label><input type="time" name="mondayFrom" required/></label>-
                            <label><input type="time" name="mondayTo" required/></label>
                        </p>
                        <p><strong>Вт: </strong>
                            <label><input type="time" name="tuesdayFrom" required/></label>-
                            <label><input type="time" name="tuesdayTo" required/></label>
                        </p>
                        <p><strong>Ср: </strong>
                            <label><input type="time" name="wednesdayFrom" required/></label>-
                            <label><input type="time" name="wednesdayTo" required/></label>
                        </p>
                        <p><strong>Чт: </strong>
                            <label><input type="time" name="thursdayFrom" required/></label>-
                            <label><input type="time" name="thursdayTo" required/></label>
                        </p>
                        <p><strong>Пт: </strong>
                            <label><input type="time" name="fridayFrom" required/></label>-
                            <label><input type="time" name="fridayTo" required/></label>
                        </p>
                        <p><strong>Сб: </strong>
                            <label><input type="time" name="saturdayFrom" required/></label>-
                            <label><input type="time" name="saturdayTo" required/></label>
                        </p>
                        <p><strong>Вс: </strong>
                            <label><input type="time" name="sundayFrom" required/></label>-
                            <label><input type="time" name="sundayTo" required/></label>
                        </p>
                    </div>

                    <div class="modal_bottom">
                        <button type="submit" class="btn-send">Отправить</button>
                        <a href="#" class="btn btn--close" id="btn_close">Закрыть</a>
                    </div>

                </div>
            </form>
        </div>

        <a href="#" class="btn" id="btn">Cтать выгульщиком</a>

        <#if walkers?size != 0>
            <#list walkers as walker>
                    <div class="walker">
                        <p>Имя: ${walker.user.firstName}</p>
                        <p>Фамилия: ${walker.user.lastName}</p>
                        <p>Телефон: ${walker.user.phone}</p>
                        <p>Почта: ${walker.user.email}</p>
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

                        <button class="btn-book-walk" data-walker-id="${walker.id}">Забронировать прогулку</button>

                                    <!-- Форма бронирования (изначально скрыта) -->
                        <div class="booking-form" id="booking-form-${walker.id}">
                             <form method="post" action="/walkers/book">
                                    <h3>Забронировать прогулку с ${walker.user.firstName}</h3>
                                            <#if user.dogs?has_content>
                                                <label>Выберите собаку:</label>
                                                <select name="dogId" required>
                                                    <#list user.dogs as dog>
                                                        <option value="${dog.id}">${dog.name}</option>
                                                    </#list>
                                                </select>
                                            <#else>
                                                <div class="alert alert-warning">
                                                    У вас нет ни одной собаки. <a href="/profile">Добавьте собаку в профиле</a>.
                                                </div>
                                            </#if>

                                            <div><label>Дата и время:</label>
                                            <input type="datetime-local" name="walkDateTime" required>
                                            </div>

                                            <div>
                                            <label>Длительность (час):</label>
                                            <input type="number" name="duration" required>
                                            </div>

                                            <input type="hidden" name="walkerId" value="${walker.id}">

                                            <div class="form-actions">
                                                <button type="submit" class="btn-submit">Подтвердить</button>
                                                <button type="button" class="btn-cancel" data-walker-id="${walker.id}">Отмена</button>
                                            </div>
                             </form>
                        </div>
                    </div>
            </#list>
        <#else>
            <p>Список выгульщиков пуст</p>
        </#if>

    </div>
    <script src="/js/walkers.js" type="text/javascript"></script>
    <script type="application/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<#--    <script>-->
<#--        document.addEventListener('DOMContentLoaded', function() {-->
<#--            // Обработчики для кнопок "Забронировать прогулку"-->
<#--            document.querySelectorAll('.btn-book-walk').forEach(button => {-->
<#--                button.addEventListener('click', function() {-->
<#--                    const walkerId = this.getAttribute('data-walker-id');-->
<#--                    document.getElementById(`booking-form-` + walkerId).style.display = 'block';-->
<#--                    this.style.display = 'none';-->
<#--                });-->
<#--            });-->

<#--            // Обработчики для кнопок "Отмена"-->
<#--            document.querySelectorAll('.btn-cancel').forEach(button => {-->
<#--                button.addEventListener('click', function() {-->
<#--                    const walkerId = this.getAttribute('data-walker-id');-->
<#--                    document.getElementById(`booking-form-` + walkerId).style.display = 'none';-->
<#--                    document.querySelector(`.btn-book-walk[data-walker-id=${walkerId}]`).style.display = 'block';-->
<#--                });-->
<#--            });-->
<#--        });-->
<#--    </script>-->
</@m.common>