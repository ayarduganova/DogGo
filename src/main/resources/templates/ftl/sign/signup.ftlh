<#import "/spring.ftl" as spring />
<#import "../PARTS/common.ftlh" as c>

<@c.common page="Sign up" css= "">

    <form method="post" >
        <div>Login: <input type="text" name="username"></div>
        <div>Password: <input type="text" name="password"></div>

        <div class="wrapper-1">
            <h1>Заполните информацию о себе</h1>
                <div class="input-container">
                    <div class="input-box"><input type="text" name="firstName" placeholder="Имя" required></div>
                    <div class="input-box"><input type="text" name="lastName" placeholder="Фамилия" required></div>
                    <div class="input-box"><input type="text" name="gender" placeholder="Пол" required></div>
                    <div class="input-box"><input type="date" name="birthday" placeholder="Дата рождения" required></div>
                    <div class="input-box"><input type="email" name="email" placeholder="Почта" required></div>
                    <div class="input-box"><input type="tel" name="phone" placeholder="Номер телефона" required></div>
                </div>
        </div>

        <p>${message!}</p>
        <input type="submit" value="Sign up">

    </form>

    <a href="./login">Войти</a>

</@c.common>
