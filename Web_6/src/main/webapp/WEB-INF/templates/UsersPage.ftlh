<#-- @ftlvariable name="users" type="ru.itmo.wp.model.domain.User[]" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="users datatable">
        <div class="caption">User</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Admin</th>
            </tr>
            </thead>
            <tbody>
            <template>
                <tr>
                    <td class="user_id"></td>
                    <td class="user_login"></td>
                    <td>
                        <form method="post" action="">
                            <div class="user_admin"></div>
                            <input type="submit">
                            <#--<input type="submit" value class="value">-->
                        </form>
                    </td>
                </tr>
            </template>
            <tr class="noData">
                <td colspan="3">
                    No data
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <script>
        $(function () {
            var $noData = $(".users .noData");
            $noData.find("td").text("Loading...");

            myAjax({
                data: {
                    action: "findAll"
                },
                success: function (response) {
                    response["users"].forEach(function (user) {
                        $noData.hide();
                        var $tr = $($(".users template").prop("content")).clone();
                        $tr.find("tr").attr("data-userId", user["id"]);
                        $tr.find(".user_id").text(user["id"]);
                        $tr.find(".user_id").attr("data-userId", user["id"]);
                        $tr.find(".user_login").text(user["login"]);
                        $tr.find(".user_login").attr("data-userId", user["id"]);
                        $tr.find(".user_admin").text(user["admin"]);
                        $tr.find(".user_admin").attr("data-userId", user["id"]);
                        $tr.find("input[type='submit']").val(user["admin"] ? "Disable" : "Enable");
                        $(".users tbody").append($tr);
                        if (!response["admin"]) {
                            $('td:nth-child(3),th:nth-child(3)').hide();
                        }
                    });
                    $(".users form").submit(function () {
                        var userId = $(this).find("input[type='submit']").closest("tr").find("td")[0].innerHTML;
                        var curNode = this;
                        myAjax({
                            data: {
                                action: "changeAdmin",
                                id: userId
                            },
                            success: function (response) {
                                // alert(response["error"]);
                                if (!response["error"]) {
                                    $(curNode).find("input[type='submit']").val($(curNode).find("input[type='submit']").val() === "Disable" ? "Enable" : "Disable");
                                    $(curNode).find(".user_admin").text($(curNode).find("input[type='submit']").val() === "Disable" ? "true" : "false");
                                } else {
                                    notify(response["message"]);
                                }
                            }
                        });
                        // $(this).find("input[type='submit']").val($(this).find("input[type='submit']").val() === "Disable" ? "Enable" : "Disable");
                        // $(this).find(".user_admin").text($(this).find("input[type='submit']").val() === "Disable" ? "true" : "false");
                        return false;
                    });
                    $(".users tr").click(function () {
                        //alert("tr");
                        myAjax({
                            data: {
                                action: "findUser",
                                userId: $(this).attr("data-userId")
                            },
                            success: function (response) {
                                notify(response["user"].creationTime);
                            }
                        })
                    });
                }
            });
        })
    </script>
</@c.page>
