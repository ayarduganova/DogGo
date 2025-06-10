<#import "../PARTS/common.ftlh" as m>
<@m.common page="main" css=" ">
    <div class="wrapper">
        <div class="modal" id="modal">
            <form method="post">
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

    </div>

</@m.common>
