<#-- @ftlvariable name="user" type="ru.itmo.wp.domain.User" -->
<#import "commons.ftlh" as c>

<@c.page>
    <#if user??>
        <div>${user.id}</div>
        <div>${user.login}</div>
        <div>${user.creationTime}</div>
    <#else>
        <div>No such user</div>
    </#if>
</@c.page>
