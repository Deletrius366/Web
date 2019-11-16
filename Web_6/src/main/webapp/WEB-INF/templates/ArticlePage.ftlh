<#-- @ftlvariable name="message" type="java.lang.String" -->
<#-- @ftlvariable name="users" type="ru.itmo.wp.model.domain.User[]" -->
<#-- @ftlvariable name="error" type="java.lang.String" -->
<#-- @ftlvariable name="title" type="java.lang.String" -->

<#import "commons.ftlh" as c>

<@c.page>
<#--<link rel="stylesheet" type="text/css" href="css/talk-form.css">-->
    <div class="article form-box">
        <div class="header">Post article</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="create"/>
                <div class="field">
                    <div class="name">
                        <label for="title">Title</label>
                    </div>
                    <div class="value">
                        <input id="title" name="title" value="${title!}"/>
                    </div>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="text">Text</label>
                    </div>
                    <div class="value">
                        <textarea rows="5" cols="24" maxlength="65535" required name="text"></textarea>
                    </div>
                </div>

                <#if error??>
                    <div class="error">
                        ${error!}
                    </div>
                </#if>

                <div class="button-field">
                    <input type="submit" value="Create">
                </div>
            </form>
        </div>
    </div>

    <script>
        $(function () {
            $(".article form").submit(function () {
                var title = $(this).find("input[name='title']").val();
                var text = $(this).find("input[name='text']").val();

                myAjax({
                    data: {
                        action: "create",
                        title: title,
                        text: text
                    }
                    success: function (response) {
                        notify(response["user"].creationTime);
                    }

                });

                return false;
            });
        })
    </script>
</@c.page>

