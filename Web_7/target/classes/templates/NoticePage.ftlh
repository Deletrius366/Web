<#-- @ftlvariable name="noticeForm" type="ru.itmo.wp.form.NoticeCredentials" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<#--<#macro error field>-->
    <#--<@spring.bind field/>-->
    <#--<#list spring.status.errorMessages as error>-->
        <#--<div class="error">${error}</div>-->
        <#--<#break/>-->
    <#--</#list>-->
<#--</#macro>-->

<@c.page>
    <div class="article form-box">
        <div class="header">Add notice</div>
        <div class="body">
            <form method="post" action="">
                <div class="field">
                    <div class="name">
                        <label for="content">Text</label>
                    </div>
                    <div class="value">
                        <textarea rows="5" cols="24" maxlength="65535" id="content" name="content"></textarea>
                    </div>
                </div>
                <#--<@c.error "noticeForm.content"/>-->
                <#--<#if error??>-->
                    <#--<div class="error">-->
                        <#--${error!}-->
                    <#--</div>-->
                <#--</#if>-->

                <div class="button-field">
                    <input type="submit" value="Add">
                </div>
                <div class="error"></div>
            </form>
        </div>
    </div>
</@c.page>