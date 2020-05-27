$(function () {

    $._createSelect($("#userSelect"), "/manager/pc/user/select");

    $("#btn-query").on("click", function () {
        var userId = $("#userSelect").val() ? $("#userSelect").val() : null;
        var beginDate = $("#beginDate").val();
        var endDate = $("#endDate").val();

        if (!beginDate) { alert("请选择起始时间"); return; }
        if (!endDate) { alert("请选截止时间"); return; }

        var param = {};
        param.beginDate = beginDate;
        param.endDate = endDate;
        userId && (param.userId = userId);
        $.ajax({
            cache: false,
            type: "POST",
            url: "/manager/pc/report/saleDetails",
            data: param,
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