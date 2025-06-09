<#import "/spring.ftl" as spring />
<#import "../PARTS/common.ftlh" as c>
<#import "../PARTS/sign.ftlh" as s>
<@c.common page="Sign up">
    <@s.signin message="${message!}" button="Sign up" href="./login" textForHref="Войти" />
</@c.common>
