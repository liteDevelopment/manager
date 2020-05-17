$(function () {

////////////////////////////////////////////////////销售单方法/////////////////////////////////////////////////////

    var str =  "<div class='btn-group'>" +
         "<button id='editRow' class='btn btn-primary btn-sm' type='button'><i class='fa'></i>编辑</button>" +
         "<button id='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa'></i>删除</button>" +
         "<button id='salesSlipSetailEdit' class='btn btn-primary btn-sm' type='button'><i class='fa'></i>明细</button>" +
         "</div>"
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
                 url: "/manager/pc/salesSlip/dataGrid",
                 dataSrc: "data",
                 dataType:'json',
                 data: {
                     "id": null,
                     "code": null,
                     "createTime": null
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
                {"data": "code"},
                {"data": "userName"},
                {"data": "customerName"},
                {"data": "createTime"},
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
                },
                {
                    render: function (data, type, row) {
                        return data;
                    },
                    targets: 3
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

    //查询按钮
    $("#btn-query").on("click", function () {
        tables.fnDraw();//查询后不需要保持分页状态，回首页
    });

    //添加
    $("#btn-add").on("click", function () {
            $("input[name=id]").val(null);
            $("input[name=code]").val(null);
            $("input[name=createTime]").val(null);
            createSelect($("#userSelect"), "/manager/pc/user/select");
            createSelect($("#customerSelect"), "/manager/pc/customer/select");
            $("#editModal").modal("show");
        });

    //批量删除
    $("#btn-delAll").on("click", function () {

    });

    //导出
    $("#btn-export").on("click", function () {
    });

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
            $("input[name=code]").val(data.code);
            $("input[name=createTime]").val(data.createTime);

            $.ajax({
                cache: false,
                type: "GET",
                url: "/manager/pc/salesSlip/query",
                data: {id: data.id},
                async: false,
                error: function (request) {
                    alert("Server Connection Error.");
                },
                success: function (data) {
                    if (data.code == 1) {
                        createSelect($("#userSelect"), "/manager/pc/user/select", data.data.userId);
                        createSelect($("#customerSelect"), "/manager/pc/customer/select", data.data.customerId)
                        $("#editModal").modal("show");
                    } else {
                        alert(data.msg);
                    }
                }
            });

        });

    $("#btn-submit").on("click", function () {
            $.ajax({
                cache: false,
                type: "POST",
                url: "/manager/pc/salesSlip/save",
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
                    url: '/manager/pc/salesSlip/delete?id=' + data.id,
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

    $("#dataTable tbody").on("click", "#salesSlipSetailEdit", function () {
        var data = tables.api().row($(this).parents("tr")).data();
        var salesSlipId = $("input[name=id]").val(data.id);
        $("#salesSlip").attr("style","display:none;");
        $("#salesSlipDetail").attr("style","display:block;");;
    });

////////////////////////////////////////////////////销售单明细方法/////////////////////////////////////////////////////

    var detailStr =  "<div class='btn-group'>" +
         "<button id='detailEditRow' class='btn btn-primary btn-sm' type='button'><i class='fa'></i>编辑</button>" +
         "<button id='detailDelRow' class='btn btn-primary btn-sm' type='button'><i class='fa'></i>删除</button>" +
         "</div>"

    var detailTables = $("#detailDataTable").dataTable({
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
                 url: "/manager/pc/salesSlip/detail/dataGrid",
                 dataSrc: "data",
                 dataType:'json',
                 data: {
                     "id": null,
                     "code": null,
                     "createTime": null
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
                {"data": "productName"},
                {"data": "price"},
                {"data": "num"},
                {"data": "percentage"},
                {"data": "commission"},
                {"data": "cutoffTime"},
                {"data": "columnDefs"}
            ],
            //操作按钮
            columnDefs: [
                {
                    targets: 0,
                    defaultContent: "<input type='checkbox' name='detailCheckList'>"
                },
                {
                    targets: -1,
                    defaultContent: detailStr
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

    //添加
    $("#detail-btn-add").on("click", function () {
            $("input[name=id]").val(null);
            $("input[name=num]").val(null);
            $("input[name=price]").val(null);
            $("input[name=percentage]").val(null);
            $("input[name=commission]").val(null);
            $("input[name=cutoffTime]").val(null);
            createSelect($("#productSelect"), "/manager/pc/product/select");
            $("#detailEditModal").modal("show");
        });

 //checkbox全选
    $("#checkAll").on("click", function () {
            if ($(this).prop("checked") === true) {
                $("input[name='detailCheckList']").prop("checked", $(this).prop("checked"));
                $("#detailDataTable tbody tr").addClass('selected');
                $(this).hasClass('selected')
            } else {
                $("input[name='detailCheckList']").prop("checked", false);
                $("#detailDataTable tbody tr").removeClass('selected');
            }
        });

//修改
    $("#detailDataTable tbody").on("click", "#detailEditRow", function () {
            var data = detailTables.api().row($(this).parents("tr")).data();
            $("input[name=id]").val(data.id);
            $("input[name=num]").val(data.num);
            $("input[name=price]").val(data.price);
            $("input[name=percentage]").val(data.percentage);
            $("input[name=commission]").val(data.commission);
            $("input[name=cutoffTime]").val(data.cutoffTime);

            $.ajax({
                cache: false,
                type: "GET",
                url: "/manager/pc/salesSlip/detail/query",
                data: {id: data.id},
                async: false,
                error: function (request) {
                    alert("Server Connection Error.");
                },
                success: function (data) {
                    if (data.code == 1) {
                        createSelect($("#productSelect"), "/manager/pc/product/select", data.data.productId);
                        $("#detailEditModal").modal("show");
                    } else {
                        alert(data.msg);
                    }
                }
            });

        });

    $("#detail-btn-submit").on("click", function () {
            $.ajax({
                cache: false,
                type: "POST",
                url: "/manager/pc/salesSlip/detail/save",
                data: $("#detailEditForm").serialize(),
                async: false,
                error: function (request) {
                    alert("Server Connection Error.");
                },
                success: function (data) {
                    if (data.code == 1) {
                        $("#detailEditModal").modal("hide");
                        detailTables.fnDraw();
                    } else {
                        alert(data.msg);
                    }
                }
            });
        });

    //删除
    $("#detailDataTable tbody").on("click", "#detailDelRow", function () {
            var data = detailTables.api().row($(this).parents("tr")).data();
            if (confirm("是否确认删除这条信息?")) {
                $.ajax({
                    url: '/manager/pc/salesSlip/detail/delete?id=' + data.id,
                    type: 'delete',
                    dataType: "json",
                    cache: "false",
                    success: function (data) {
                        if (data.code == 1) {
                            detailTables.api().row().remove().draw(false);
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

    $("#salesSlipDetail").on("click", "#btn-back", function () {
        $("#salesSlipDetail").attr("style","display:none;");
        $("#salesSlip").attr("style","display:block;");;
    });


////////////////////////////////////////////////////公共方法/////////////////////////////////////////////////////

    function createSelect(elSelect, url, id) {
        elSelect.empty();
        $.ajax({
            url: url,
            type: 'get',
            dataType: "json",
            cache: "false",
            success: function (data) {
                if (data.code == 1 && data.data) {
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