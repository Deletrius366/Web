<#-- @ftlvariable name="articles" type="ru.itmo.wp.model.domain.Article[]" -->
<#-- @ftlvariable name="user" type="ru.itmo.wp.model.domain.User" -->
<#import "commons.ftlh" as c>

<@c.page>
    <#if user??>
        <div class="articles datatable">
            <div class="caption">Articles</div>
            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Hide/Show</th>
                </tr>
                </thead>
                <tbody>
                <#list articles as article>
                    <#if user.id == article.userId>
                        <tr>
                            <td>${article.id}</td>
                            <td>${article.title}</td>
                            <td>
                                <form method="post" action="">
                                    <input type="submit"
                                            <#if article.hidden>
                                                value="Show"
                                            <#else>
                                                value="Hide"
                                            </#if>
                                    >
                                    <#--<input type="submit" value class="value">-->
                                </form>
                            </td>
                        </tr>
                    </#if>
                </#list>
                </tbody>
            </table>
        </div>
    <#else>
        <div>You are not logged in!</div>
    </#if>

    <script>
        $(function () {
            $(".articles form").submit(function () {
                var articleId = $(this).find("input[type='submit']").closest("tr").find("td")[0].innerHTML;
                myAjax({
                    data: {
                        action: "changeHidden",
                        articleId: articleId
                    },
                    success: function () {
                    }
                });
                $(this).find("input[type='submit']").val($(this).find("input[type='submit']").val() === "Hide" ? "Show" : "Hide");
                return false;
            });
        })
    </script>
</@c.page>