<#import "common.ftl" as c/>

<@c.page>
    <link rel="stylesheet" type="text/css" href="/css/datatable.css">
    <div class="datatable">
        <div class="caption">Users</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Handle</th>
            </tr>
            </thead>
            <tbody>
            <#list users as u>
            <tr>
                <td><a href="/user?id=${u.id}" > ${u.id}</td>
                <td>${u.name}</td>
                <td><a class="${u.color}" href="/user?handle=${u.handle}">${u.handle}</a></td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>
