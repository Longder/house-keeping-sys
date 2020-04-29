<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <title>课程列表</title>
    <jsp:include page="${ctx}/WEB-INF/import/head.jsp"/>
</head>
<body>
<div class="row">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>预约家政服务</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-wrench"></i>
                    </a>
                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <div class="row">
                    <div class="col-sm-3">
                    </div>
                    <div class="col-sm-9">
                    </div>
                </div>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>标题</th>
                        <th>服务内容</th>
                        <th>预约状态</th>
                        <th>服务人员</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${serverInfoList}" var="serverInfo" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${serverInfo.title}</td>
                            <td>${serverInfo.content}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${serverInfo.appointed}">
                                        <span class="label label-success">已被预约</span>
                                    </c:when>
                                    <c:when test="${!serverInfo.appointed}">
                                        <span class="label label-danger">未被预约</span>
                                    </c:when>
                                </c:choose>
                            </td>
                            <td>${serverInfo.staff.name}</td>
                            <td>
                                <a href="${ctx}/admin/appointment/generate?serverInfoId=${serverInfo.id}"
                                   onclick="return confirm('确定预约此家政服务吗？')"
                                   class="btn btn-sm btn-success">预约服务</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="modal inmodal fade" id="serverInfoModal" tabindex="-1" role="dialog" aria-hidden="true"></div>
<jsp:include page="${ctx}/WEB-INF/import/script.jsp"/>
</body>
</html>
