<%--
  Created by IntelliJ IDEA.
  User: eport2
  Date: 2019-10-11
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/ajaxForm.js"></script>
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
        $(submit).click();
    }

    function errCallBack(err) {
        alert(err);
    }

    function postSuccess(response) {
        alert(response);
    }

</script>

<form id="form1" name="form1" action="Add.action" method="post">
    <input type="text" id="userName" name="userName">
    <input type="text" id="password" name="password">
    <input type="submit" value="提交" id="submit" name="submit">
</form>
<hr>
<input type="button" value="post" id="btnPost" name="btnPost" onclick="doPostSubmit()">
</body>
</html>
