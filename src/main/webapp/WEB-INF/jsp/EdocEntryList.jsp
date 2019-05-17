<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>电子文档列表</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/jquery-1.12.4.js"></script>
    <script>
        function pageNav(pageNo, form) {
            form.pageNo.value = pageNo;
            form.submit();
        }

        function del(id, obj) {
            if (confirm("确定要删除该电子文档吗？")) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/edoc/del/"+id,
                    type: "post",
                    datatype: "text",
                    success: function (result) {
                        if (result == "true") {
                            alert("文档编号为" + id + ",删除成功！");
                            $(obj).parent().parent().remove();
                        } else {
                            alert("文档编号为" + id + ",删除失败！");
                        }
                    }
                })
            }
        }
    </script>
</head>
<body>
<c:if test="${empty edocEntryList}">
    <c:redirect url="/edoc/list"/>
</c:if>
<form action="${pageContext.request.contextPath}/edoc/list" method="post" style="text-align: center;">
    <input type="hidden" name="pageNo" value="1">
    文档分类：<select name="categoryId">
    <option value="">全部</option>
    <c:forEach items="${edocCategoryList}" var="edocCategory">
        <option value="${edocCategory.id}"
                <c:if test="${edocCategory.id == categoryId}">selected</c:if>>${edocCategory.name}</option>
    </c:forEach>
</select><input type="submit" value="查询" style="margin-left: 20px;">
    <table border="1" cellspacing="0" cellpadding="0" style="margin: 0 auto;">
        <tr>
            <th colspan="6">电子文档列表</th>
        </tr>
        <tr>
            <td>文档编号</td>
            <td>文档名称</td>
            <td>文档摘要</td>
            <td>上传人</td>
            <td>上传日期</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${edocEntryList}" var="edocEntry">
            <tr>
                <td>${edocEntry.id}</td>
                <td>${edocEntry.title}</td>
                <td>${edocEntry.summary}</td>
                <td>${edocEntry.uploaduser}</td>
                <td><fmt:formatDate value="${edocEntry.createDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                <td><a href="#" onclick="del(${edocEntry.id},this)">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" style="text-align: center">
                <a href="javascript:pageNav(1,document.forms[0])"> 首页</a>
                <!--${pageContext.request.contextPath}/goodsdetail/findAll?pageNo=${page.currPageNo -1}-->
                <a href="javascript:pageNav(${page.currPageNo -1},document.forms[0])"> 上一页</a>
                <a href="javascript:pageNav(${page.currPageNo +1},document.forms[0])"> 下一页</a>
                <a href="javascript:pageNav(${page.totaPageCount},document.forms[0])"> 末页</a>
                第${page.currPageNo}页/共${page.totaPageCount}页
            </td>
        </tr>
    </table>
</form>
</body>
</html>
