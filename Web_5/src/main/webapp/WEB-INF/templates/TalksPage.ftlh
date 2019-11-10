<#-- @ftlvariable name="message" type="java.lang.String" -->
<#-- @ftlvariable name="users" type="ru.itmo.wp.model.domain.User[]" -->
<#-- @ftlvariable name="talks" type="ru.itmo.wp.model.domain.Talk[]" -->
<#-- @ftlvariable name="error" type="java.lang.String" -->

<#import "commons.ftlh" as c>

<@c.page>
    <link rel="stylesheet" type="text/css" href="css/talk-form.css">
    <div class="form-box">
        <div class="header">Send message</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="send"/>
                <select name="targetUserId">
                    <#list users as u>
                        <option value="${u.id}">${u.login}</option>
                    </#list>
                </select>

                <#if error??>
                    <div class="error">
                        ${error!}
                    </div>
                </#if>

                <p><textarea rows="5" cols="45" maxlength="65535" required name="text"></textarea></p>

                <div class="button-field">
                    <input type="submit" value="Send">
                </div>
            </form>
        </div>
    </div>
    <div class="datatable">
        <div class="caption">Messages</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>From</th>
                <th>To</th>
                <th>Text</th>
                <th>Creation time</th>
            </tr>
            </thead>
            <tbody>
            <#list talks as talk>
                <tr>
                    <td>${talk.id}</td>
                    <#list users as sourceUser>
                        <#if sourceUser.id == talk.sourceUserId>
                            <td>${sourceUser.login}</td>
                        </#if>
                    </#list>
                    <#list users as targetUser>
                        <#if targetUser.id == talk.targetUserId>
                            <td>${targetUser.login}</td>
                        </#if>
                    </#list>
                    <td>${talk.text}</td>
                    <td>${talk.creationTime}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>