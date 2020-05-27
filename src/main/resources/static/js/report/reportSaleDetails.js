$(function () {

    createSelect($("#userSelect"), "/manager/pc/user/select");

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

    function createSelect(elSelect, url, id) {
        elSelect.empty();
        $.ajax({
            url: url,
            type: 'get',
            dataType: "json",
            cache: "false",
            success: function (data) {
                if (data.code == 1 && data.data) {
                elSelect.append("<option style='display: none'></option>");
                    for (i = 0; i < data.data.length; i++) {
                        if (id) {
                            elSelect.append("<option value='"+data.data[i].value+"' "+ (data.data[i].value==id ? "selected" : "") + ">"+data.data[i].text+"</option>");
                        } else {
                            elSelect.append("<option value='"+data.data[i].value+"'>"+data.data[i].text+"</option>");
                        }
                    }
                } else {
                    alert(data.msg);
                }
            },
            error: function (err) {
                alert("Server Connection Error.");
            }
        });
    }
});