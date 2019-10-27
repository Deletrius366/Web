<#macro header>
    <header>
        <a href="/"><img src="/img/logo.png" alt="Codeforces" title="Codeforces"/></a>
        <div class="languages">
            <a href="#"><img src="/img/gb.png" alt="In English" title="In English"/></a>
            <a href="#"><img src="/img/ru.png" alt="In Russian" title="In Russian"/></a>
        </div>
        <div class="enter-or-register-box">
            <#if user??>
                <@userlink user=user/>
                |
                <a href="#">Logout</a>
            <#else>
                <a href="#">Enter</a>
                |
                <a href="#">Register</a>
            </#if>
        </div>
        <nav>
            <ul>
                <#if pointIndex??>
                    <li class="underlined"><a href="/index">Index</a></li>
                <#else>
                    <li><a href="/index">Index</a></li>
                </#if>
                <#if pointHelp??>
                    <li class="underlined"><a href="/misc/help">Help</a></li>
                <#else>
                    <li><a href="/misc/help">Help</a></li>
                </#if>
                <#if pointUsers??>
                    <li class="underlined"><a href="/users">Users</a></li>
                <#else>
                    <li><a href="/users">Users</a></li>
                </#if>
            </ul>
        </nav>
    </header>
</#macro>

<#macro sidebar>
    <ul class="sidebar">
    <#list posts as p>
        <aside>
            <section>
                <div class="header">
                    Post ${p.id}
                </div>
                <@makepost p 1/>
                <#--<div class="body">-->
                    <#--Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate ducimus enim facere impedit nobis,-->
                    <#--nulla placeat quam suscipit unde voluptatibus.-->
                <#--</div>-->
                <div class="footer">
                    <a href="/post?post_id=${p.id}">View all</a>
                </div>
            </section>
        </aside>
    </#list>
    </ul>
</#macro>

<#macro footer>
    <footer>
        <a href="#">Codeforces</a> &copy; 2010-2019 by Mike Mirzayanov
    </footer>
</#macro>

<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Codeforces</title>
        <link rel="stylesheet" type="text/css" href="/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" type="text/css" href="/css/blog.css">
        <link rel="icon" href="/favicon.ico" type="image/x-icon"/>
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    </head>
    <body>
    <@header/>
    <div class="middle">
        <@sidebar/>
        <main>
            <#nested/>
        </main>
    </div>
    <@footer/>
    </body>
    </html>
</#macro>

<#macro userlink user>
    <a class="${user.color}" href="/user?handle=${user.handle}">${user.handle}</a>
</#macro>

<#macro makepost post trunk>
    <article>
        <div class="title">${post.title}</div>
        <div class="body">
            <#if trunk == 0>
                ${post.text}
            <#else>
                ${post.text?truncate(250)}
            </#if>
        </div>
        <#nested/>
    </article>
</#macro>

<#function findBy items key id>
    <#list items as item>
        <#if item[key]==id>
            <#return item/>
        </#if>
    </#list>
</#function>

<#function findIndex items key id>
    <#list items as item>
        <#if item[key]==id>
            <#return item?index/>
        </#if>
    </#list>
</#function>
