<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<#import "../PARTS/sign.ftlh" as s>
<@c.common page="Sign in">
    <@s.signin message="${message!}" button="Sign in" href="./signUp" textForHref="Зарегистрироваться" />
</@c.common>
