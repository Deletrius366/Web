    <#-- @ftlvariable name="handle" type="java.lang.String" -->
    <#-- @ftlvariable name="id" type="Long" -->
<#import "common.ftl" as c/>

<@c.page>
    <link rel="stylesheet" type="text/css" href="/css/user.css">
    <#if handle??>
        <#assign viewedUser=c.findBy(users, "handle", handle)!/>
    <#elseif id??>
        <#assign viewedUser=c.findBy(users, "id", id)!/>
    </#if>

    <#if viewedUser.id??>
        <div class="user-info">
            <div class="user-body">
                <div class="user-name">
                    <@c.userlink user=viewedUser/>
                </div>
                <img src="img/user.jpg" class="userjpg"/>
                <ul>
                    <li>id: ${viewedUser.id}</li>
                    <li>handle: ${viewedUser.handle}</li>
                    <li>name: ${viewedUser.name}</li>
                </ul>
            </div>
            <div class="user-footer">
                <#assign index=c.findIndex(users, "handle", handle)/>
                <#if viewedUser != users?first>
                    <a href="/user?handle=${users[index-1].handle}">&lAarr;</a>
                <#else>
                    &lAarr;
                </#if>
                <#if viewedUser != users?last>
                    <a href="/user?handle=${users[index+1].handle}">&rAarr;</a>
                <#else>
                    &rAarr;
                </#if>
            </div>
        </div>
    <#else>
        <h1>No such user</h1>
    </#if>
</@c.page>
