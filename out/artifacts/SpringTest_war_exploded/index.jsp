<%--
  Created by IntelliJ IDEA.
  User: eport2
  Date: 2019-10-11
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/ajaxForm.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-ui.css"></link>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-ui.theme.css"></link>
<head>
    <title>SpringTest</title>
</head>
<body>

<script>
    $(function () {
        // alert("ready");
    });


    $('form1').ajaxForm(options);
    var options = {
        target:        this  // target element to be updated with server response
        ,success:       showResponse
    };

    function showResponse(responseText, statusText, xhr, $form)  {

        alert('ok');
    }

    function doPostSubmit() {
        // var data = {"userName": "gadd", "password": "dfjjfjf"};
        // var url = "http://localhost:8080/SpringTest/Add";
        // jQuery.ajax({
        //     type: "POST",
        //     url: url,
        //     data: data,
        //     processData: false,
        //     // contentType: "application/x-www-form-urlencoded;charset=utf-8",
        //     contentType: "application/json;charset=utf-8",
        //     success: postSuccess,
        //     error: errCallBack,
        //     dataType: "text"
        // });
        var contextPath = "${pageContext.request.contextPath}";
        var userModel = {username: "corpse", password: "corpse"};
        $.ajax({
           type: "POST",
            url: contextPath+"/user/addUser.form",
            // contentType: "application/x-www-form-urlencoded;charset=utf-8",
            contentType: "application/json",
            dataType:"json",
            data: JSON.stringify(userModel),
            success: postSuccess,
            error: errCallBack
        });
    }

    function errCallBack(err) {
        document.getElementById("divDisplay").innerText = JSON.stringify(err);
        alert(JSON.stringify(err));
    }

    function postSuccess(response) {
        alert(JSON.stringify(response));
    }

    function getAllUsers() {
        $('#formGetAll').submit();
    }

</script>

<form id="form1" name="form1" action="Add.action" method="post" class="ui-widget">
    <input type="text" id="userName" name="userName">
    <input type="text" id="password" name="password">
    <input type="submit" value="提交" id="submit" name="submit" class="ui-selectable">
</form>
<hr>
<input type="button" value="post" id="btnPost" name="btnPost" onclick="doPostSubmit()" class="ui-button">
<hr>
<form id="form2" name="form2" action="lists/list.form" method="post" class="ui-widget">
    <input type="text" id="userName1" name="userName1">
    <input type="text" id="password1" name="password1">
    <input type="submit" value="提交" id="submit1" name="submit1" class="ui-selectable">
</form>
<hr>
<div id="divDisplay" name="divDisplay"></div>
<hr>
<input type="button" id="btnGetAll" name="btnGetAll" value="查询" class="ui-button" onclick="getAllUsers()">
<form id="formGetAll" name="formGetAll" action=<%=request.getServletContext().getContextPath()%>/user/getall.form method="get">
</form>
<hr>
<form id="form4" name="form4" action="api_json.action" method="post" class="ui-widget">
    <%--<input type="text" id="userName" name="userName">--%>
    <%--<input type="text" id="password" name="password">--%>
    <input type="submit" value="提交json" id="submit" name="submit" class="ui-selectable">
</form>

</body>
</html>
