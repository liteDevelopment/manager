$(function () {

    $._createSelect($("#userSelect"), "/manager/pc/user/select");

    $("#btn-query").on("click", function () {
        $.ajax({
            cache: false,
            type: "POST",
            url: "/manager/pc/report/saleDetails?userId=" + $("#userSelect").val() + "&beginDate=" + $("#beginDate").val() + "&endDate=" + $("#endDate").val(),
            //data: $("#editForm").serialize(),
            async: false,
            error: function (request) {
                alert("Server Connection Error.");
            },
            success: function (data) {
                $("#reportTable").html(data);
            }
        });
    });

});