$(function () {
    $("td.value").click(function(event){
    //td中已经有了input,则不需要响应点击事件
        if($(this).children("input").length > 0)
            return false;
        var tdObj = $(this);
        var id = tdObj.attr("data-id");
        var code = tdObj.attr("data-code");
        var preText = tdObj.html();
        //得到当前文本内容
        var inputObj = $("<input type='text' data-id='" + id + "' data-code='" + code + "'/>");
        //创建一个文本框元素
        tdObj.html(""); //清空td中的所有元素
        inputObj.width(tdObj.width())
        //设置文本框宽度与td相同
        .height(tdObj.height())
        .css({border:"0px",fontSize:"17px",font:"宋体"})
        .val(preText)
        .appendTo(tdObj)
        //把创建的文本框插入到tdObj子节点的最后
        .trigger("focus")
        //用trigger方法触发事件
        .trigger("select");
        inputObj.keyup(function(event){
            var text = $(this).val();
            if (!text) { alert("请填写参数!");return; }
            if(13 == event.which) {//用户按下回车
                $.ajax({
                    cache: false,
                    type: "POST",
                    url: "/manager/pc/sysConfig/update",
                    data: {
                        id: id,
                        value: text
                    },
                    async: false,
                    error: function (request) {
                        alert("Server Connection Error.");
                    },
                    success: function (data) {
                         tdObj.html(text);
                    }
                });
            } else if(27 == event.which) {//ESC键
                tdObj.html(preText);
            }
        });
        //已进入编辑状态后，不再处理click事件
        inputObj.click(function(){
            return false;
        });
    });
});