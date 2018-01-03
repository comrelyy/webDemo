<%--
  Created by IntelliJ IDEA.
  User: cairuirui
  Date: 2017/11/17
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SwitchPage</title>
</head>
<body>

    <div style="margin: 300px 800px;">
        <div>相关模块的开关控制:</div>
        <table border= "1">
            <tr id="1">
                <td>闯关模块开关</td>
                <td>
                    <div id="1_on"><input type="radio" name="studygame" value="1" checked="checked" onclick="changeSwitchOn(1)" />开</div>
                    <div id="1_off"><input type="radio" name="studygame" value="2" onclick="changeSwitchOff(1)" />关</div>
                </td>
                <td id="desc1"></td>
            </tr>
            <tr id="2">
                <td>课程检查开关</td>
                <td>
                    <div id="2_on"><input type="radio" name="courseCheck" value="1" checked="checked" onclick="changeSwitchOn(2)" />开</div>
                    <div id="2_off"><input type="radio" name="courseCheck" value="2" onclick="changeSwitchOff(2)" />关</div>
                </td>
                <td id="desc2"></td>
            </tr>
            <tr id="3">
                <td>问答模块开关</td>
                <td>
                    <div id="3_on"><input type="radio" name="qa" value="1" checked="checked" onclick="changeSwitchOn(3)"/>开</div>
                    <div id="3_off"><input type="radio" name="qa" value="2" onclick="changeSwitchOff(3)" />关</div>
                </td>
                <td id="desc3"></td>
            </tr>
            <tr id="4">
                <td>学校主页开关</td>
                <td>
                    <div id="4_on"><input type="radio" name="schoolHome" value="1" checked="checked" onclick="changeSwitchOn(4)"/>开</div>
                    <div id="4_off"><input type="radio" name="schoolHome" value="2" onclick="changeSwitchOff(4)" />关</div>
                </td>
                <td id="desc4"></td>

            </tr>
        </table>
    </div>

</body>

<script src="js/jquery.min.js"></script>
<script>

    $(document).ready(function(){
        var url = "http://120.27.148.181/app_2c/switch/getSwitch"
        $.ajax({
            url : url,
            type : "POST",
            async : true,
            cache : false,
            dataType : 'jsonp',
            success : function (data) {
                debugger
                console.log(data);
                var switchStatus = data.rt;
                var studygame = switchStatus.studygame;
                var courseCheck = switchStatus.courseCheck;
                var qa = switchStatus.qa;
                var schoolHome = switchStatus.schoolhomepage;
                console.log("studygame : " + studygame );
                console.log("courseCheck : " + courseCheck );
                console.log("qa : " + qa );
                console.log("schoolHome : " + schoolHome);

            }
        });

    });
    function changeSwitchOn(module) {
        var statu = $("#"+module+"_on").children().val();
        $("#"+module+"_off").children().attr("checked",false);
        $("#"+module+"_on").children().attr("checked","checked");
        console.log(module +":"+statu);
        var url = "http://120.27.148.181/app_2c/switch/changeSwitch"
        $.ajax({
            url : url,
            type : "POST",
            async : true,
            data : {
                type : module,
                status : statu
            },
            cache : false,
            dataType : 'jsonp',
            success : function (data) {
                debugger
                console.log(data);
                $("#desc"+module).text("开关已开启");
            }
        });

    }

    function changeSwitchOff(module) {
        var statu = $("#"+module+"_off").children().val();
        $("#"+module+"_on").children().attr("checked",false)
        $("#"+module+"_off").children().attr("checked","checked");
        console.log(module +":"+statu);
        url = "http://120.27.148.181/app_2c/switch/changeSwitch"
        $.ajax({
            url : url,
            type : "POST",
            async : true,
            data : {
                type : module,
                status : statu
            },
            cache : false,
            dataType : 'jsonp',
            success : function (data) {
                debugger
                console.log(data);
                $("#desc"+module).text("开关已关闭");
            }
        });

    }
</script>
</html>
