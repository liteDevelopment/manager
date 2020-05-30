$(function () {

    var oldName, oldAccount, oldPhone;

    $("#change-passwd").on("click", function () {
        $("#changePasswdModal").modal("show");
    });

    $("#passwd-btn-submit").on("click", function () {
        //校验
         if (!$("#oldPass").val()) { alert("请填原密码"); return; }
         if (!$("#newPass").val()) { alert("请填新密码"); return; }

        $.ajax({
            cache: false,
            type: "POST",
            url: "/manager/pc/user/changePasswd",
            data: $("#passwdEditForm").serialize(),
            async: false,
            error: function (request) {
                alert("Server Connection Error.");
            },
            success: function (data) {
                if (data.code == 1) {
                    $("#changePasswdModal").modal("hide");
                } else {
                    alert(data.msg);
                }
            }
        });
    });

    $("#modify").on("click", function () {
        $("#modify").attr("style","display:none;");
        $("#change-passwd").attr("style","display:none;");
        $("#modify-submit").attr("style","display:block;");
        $("#cancel").attr("style","display:block;");
        $("#name").attr("readOnly", false);
        $("#account").attr("readOnly", false);
        $("#phone").attr("readOnly", false);

        oldName = $("#name").val();
        oldAccount = $("#account").val();
        oldPhone = $("#phone").val();
    });

     $("#cancel").on("click", function () {
        $("#modify-submit").attr("style","display:none;");
        $("#cancel").attr("style","display:none;");
        $("#modify").attr("style","display:block;");
        $("#change-passwd").attr("style","display:block;");

         $("#name").val(oldName);
         $("#account").val(oldAccount);
         $("#phone").val(oldPhone);
         $("#name").attr("readOnly", true);
         $("#account").attr("readOnly", true);
         $("#phone").attr("readOnly", true);

    });


    $("#modify-submit").on("click", function () {
        if (!$("#name").val()) { alert("请填写姓名"); return; }
        if (!$("#account").val()) { alert("请填写登录账号"); return; }
        $.ajax({
            cache: false,
            type: "POST",
            url: "/manager/pc/user/updateUserInfo",
            data: {
                id: $("#id").val(),
                name: $("#name").val(),
                account: $("#account").val(),
                phone: $("#phone").val()
            },
            async: false,
            error: function (request) {
                alert("Server Connection Error.");
            },
            success: function (data) {
                if (data.code == 1) {
                    $("#name").val(data.data.name);
                    $("#phone").val(data.data.phone);
                    $("#account").val(data.data.account);
                    $("#name").attr("readOnly", true);
                    $("#account").attr("readOnly", true);
                    $("#phone").attr("readOnly", true);
                    $("#modify-submit").attr("style","display:none;");
                    $("#cancel").attr("style","display:none;");
                    $("#modify").attr("style","display:block;");
                    $("#change-passwd").attr("style","display:block;");
                } else {
                    alert(data.msg);
                }
            }
        });
    });
});