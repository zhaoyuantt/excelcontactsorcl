$(function () {
    initSourceField();
    initDbField();
    mappingField();
    addOrRemoveMapping();
    SC();
});

var html0;
var html1;
var html2;

/**
 * 源字段
 */
function initSourceField() {
    //获取原字段元素
    var $sourceField = $(".Source_field>.Source_box").eq(0).find("div");

    //绑定点击事件
    $(".Source_field>.Source_box").eq(0).on("click", "div", function() {

        $(this).siblings().css("background-color","White");

        //改变背景色
        $(this).css("background-color","#00FF00");
        //文本
        var sourceHtml = $(this).html();

        html0 = $(this);
    });

}

/**
 * 目标字段
 */
function initDbField() {
    var $dbField = $(".Source_field>.Source_box").eq(1).find("div");

    $(".Source_field>.Source_box").eq(1).on("click", "div", function() {
        $(this).siblings().css("background-color","White");

        $(this).css("background-color","#00FF00");
        var dbHtml = $(this).html();

        html1 = $(this);
    });
}

/**
 * 映射字段
 */
function mappingField() {
    var $mappingField = $(".Source_field>.Source_box").eq(2).find("div");

    /*$mappingField.live("click",function () {
        html2 = $(this).html();
        console.log(html2);
    });*/

    $(".Source_field>.Source_box").eq(2).on("click", "div", function() {

        $(this).siblings().css("background-color","White");
        $(this).css("background-color","#00FF00");

        html2 = $(this);

    });
}


/**
 * 添加或者删除映射
 */
function addOrRemoveMapping() {
    $(".bt>input").click(function () {

        var index = $(this).index();

        if(0 == index){//添加映射
            //判断是否选择源字段和目标字段
            if(undefined != typeof html0 && undefined != html1){
                var tj0 = html0.html();
                var tj1 = html1.html();
                console.log("source filed:"+tj0);
                console.log("db filed:"+tj1);

                //拼接显示结果
                var addMappingHtml = "<div>"+ tj0 +" &ndash;&gt; "+ tj1+"</div>";

                //移除各自
                html0.remove();
                html1.remove();

                //映射中追加
                $(".Source_field>.Source_box").eq(2).append(addMappingHtml);
            }
        }else{//删除映射
            if (undefined != html2){
                //分割字符串
                var splitArray = html2.html().split(" –&gt; ");
                var splitArrayS = splitArray[0];
                var splitArrayD = splitArray[1];

                //各自回位
                $(".Source_field>.Source_box").eq(0).append("<div>"+splitArrayS+"</div>");
                $(".Source_field>.Source_box").eq(1).append("<div>"+splitArrayD+"</div>");

                //移除
                html2.remove();
            }

        }

    });
}

function SC(){
    $(".button_btn>input").click(function () {
        var index = $(this).index();

        if(1 == index){//猜一猜(G)
            var $sourceField = $(".Source_field>.Source_box").eq(0).find("div");
            var $dbField = $(".Source_field>.Source_box").eq(1).find("div");

            $.each($sourceField,function (i,n) {
                //原字段中的某个值
                var sHtml = $(n).html();

                $.each($dbField,function (j,o) {
                    //目标字段中的某个值
                    var dHtml = $(o).html();

                    if(sHtml == dHtml){
                        //拼接
                        var mHtml = "<div>"+ sHtml +" &ndash;&gt; "+ dHtml+"</div>";
                        console.log(mHtml);

                        //映射中追加
                        $(".Source_field>.Source_box").eq(2).append(mHtml);

                        //移除各自元素
                        $(n).remove();
                        $(o).remove();
                    }

                });
            });
        }/*else if(0 == index){//最终的提交
            //获取参数
            var drpc = $("input[name='drpc']").val();//导入批次
            var is_space = $("input[name='is_space']:checked").val();//是否去除空格

            //校验导入批次参数
            var b = isNaN(drpc);
            if("" == drpc || true == b){
                alert("导入批次参数错误");
                return;
            }

            //获取映射后的数据
            var $mappingField = $(".Source_field>.Source_box").eq(2).find("div");

            $.each($mappingField,function (i,n) {
                var mHtml = $(n).html();
            });
        }*/

    })
}