$(function () {
    var str =  "<div class='btn-group'>" +
         "<button id='editRow' class='btn btn-primary btn-sm' type='button'><i class='fa'></i>编辑</button>" +
         "<button id='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa'></i>删除</button>" +
         "</div>"
    var url = "";
    var tables = $("#dataTable").dataTable({
            serverSide: true,//分页，取数据等等的都放到服务端去
            //processing: true,//载入数据的时候是否显示“载入中”
            pageLength: 10,  //首次加载的数据条数
            ordering: false, //排序操作在服务端进行，所以可以关了。
            pagingType: "full_numbers",
            autoWidth: false,
            stateSave: true,//保持翻页状态，和comTable.fnDraw(false);结合使用
            searching: false,//禁用datatables搜索
            ajax: {
                 type: "GET",
                 url: "/manager/pc/user/dataGrid",
                 dataSrc: "data",
                 dataType:'json',
                 data: {
                    "id": 1,
                     "name": "name",
                     "code": "code"
                 },
                 beforeSend: function () {
                         // 禁用按钮防止重复提交，发送前响应
                         //$("#submit").attr({ disabled: "disabled" });
                    $("#submsg").html("请稍后...");
                 }
            },
            columns: [//对应上面thead里面的序列
                {"data": "null"},
                {"data": "id"},
                {"data": "name"},
                {"data": "account"},
                {"data": "phone"},
                {"data": "columnDefs"}
            ],
            //操作按钮
            columnDefs: [
                {
                    targets: 0,
                    defaultContent: "<input type='checkbox' name='checkList'>"
                },
                {
                    targets: -1,
                    defaultContent: str
                }
            ],
            language: {
                lengthMenu: "",
                processing: "",
                paginate: {
                    first: "首页 ",
                    previous: " 前一页 ",
                    next: " 下一页 ",
                    last: " 末页"
                },
                zeroRecords: "未找到相关数据",
                info: "第_PAGE_页,共_PAGES_页",
                infoEmpty: "",
                infoFiltered: "",
                sSearch: "搜索:",
            },
            //在每次table被draw完后回调函数
            fnDrawCallback: function () {
                var api = this.api();
                //获取到本页开始的条数
                var startIndex = api.context[0]._iDisplayStart;
                api.column(1).nodes().each(function (cell, i) {
                    cell.innerHTML = startIndex + i + 1;
                });
            }
        });

    /*//查询按钮
    $("#btn-query").on("click", function () {
        tables.fnDraw();//查询后不需要保持分页状态，回首页
    });*/

    //添加
    $("#btn-add").on("click", function () {
            $("input[name=id]").val(null);
            $("input[name=name]").val(null);
            $("input[name=account]").val(null);
            $("input[name=phone]").val(null);
            $("#editModal").modal("show");
        });

/*    //批量删除
    $("#btn-delAll").on("click", function () {

    });

    //导出
    $("#btn-export").on("click", function () {
    });*/

    //刷新
    $("#btn-re").on("click", function () {
        tables.fnDraw(false);//刷新保持分页状态
    });

    //checkbox全选
    $("#checkAll").on("click", function () {
            if ($(this).prop("checked") === true) {
                $("input[name='checkList']").prop("checked", $(this).prop("checked"));
                $("#dataTable tbody tr").addClass('selected');
                $(this).hasClass('selected')
            } else {
                $("input[name='checkList']").prop("checked", false);
                $("#dataTable tbody tr").removeClass('selected');
            }
        });

    //修改
    $("#dataTable tbody").on("click", "#editRow", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            $("input[name=id]").val(data.id);
            $("input[name=name]").val(data.name);
            $("input[name=account]").val(data.account);
            $("input[name=phone]").val(data.phone);
            $("#editModal").modal("show");
        });

    $("#btn-submit").on("click", function () {
        if (!$("#name").val()) { alert("请填写姓名"); return; }
        if (!$("#account").val()) { alert("请填写登录账号"); return; }
            $.ajax({
                cache: false,
                type: "POST",
                url: "/manager/pc/user/save",
                data: $("#editForm").serialize(),
                async: false,
                error: function (request) {
                    alert("Server Connection Error.");
                },
                success: function (data) {
                    if (data.code == 1) {
                        $("#editModal").modal("hide");
                        tables.fnDraw();
                    } else {
                        alert(data.msg);
                    }
                }
            });
        });

    //删除
    $("#dataTable tbody").on("click", "#delRow", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            if (confirm("是否确认删除这条信息?")) {
                $.ajax({
                    url: '/manager/pc/user/delete?id=' + data.id,
                    type: 'delete',
                    dataType: "json",
                    cache: "false",
                    success: function (data) {
                        if (data.code == 1) {
                            tables.api().row().remove().draw(false);
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
});