<#import "/spring.ftl" as spring />
<#import "../PARTS/common.ftlh" as c>

<@c.common page="Регистрация" css="../css/SignUpStyle.css">
    <form method="post" >
        <div class="wrapper-1">
            <h1>Заполните информацию о себе</h1>
                <div class="input-container">
                    <div class="input-box"><input type="text" name="firstName" placeholder="Имя" required></div>
                    <div class="input-box"><input type="text" name="lastName" placeholder="Фамилия" required></div>
                    <div class="input-box"><input type="text" name="gender" placeholder="Пол" required></div>
                    <div class="input-box"><input type="date" name="birthday" placeholder="Дата рождения" required></div>
                    <div class="input-box"><input type="email" name="email" placeholder="Почта" required></div>
                    <div class="input-box"><input type="tel" name="phone" placeholder="Номер телефона" required></div>
                    <div class="input-box"><input type="text" name="text" placeholder="Логин" required></div>
                    <div class="input-box"><input type="password" name="password" placeholder="Пароль" required></div>
                </div>
        </div>

        <p>${message!}</p>
        <input type="submit" value="Зарегистрироваться">
        <a href="./login">Войти</a>
    </form>

</@c.common>
