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
                <h5>我的预约</h5>
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
                        <th>服务人员</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${appointmentList}" var="appointment" varStatus="status">
                        <td>${status.index+1}</td>
                        <td>${appointment.serverInfo.title}</td>
                        <td>${appointment.serverInfo.content}</td>
                        <td>${appointment.serverInfo.staff.name}</td>
                        <td>
                            <span class="label ${appointment.serverState.label}">${appointment.serverState.displayName}</span>
                        </td>
                        <td>
                            <c:if test="${appointment.serverState.name =='SERVING'}">
                                <a href="${ctx}/admin/appointment/complete?appointmentId=${appointment.id}"
                                   onclick="return confirm('确定完成此家政服务吗？')"
                                   class="btn btn-sm btn-primary">完成服务</a>
                            </c:if>
                            <c:if test="${!appointment.commented&&appointment.serverState.name=='COMPLETE'}">
                                <button type="button" class="btn btn-sm btn-success" data-toggle="modal"
                                        data-target="#commentModal"
                                        onclick="openModal('${ctx}/admin/comment/toAdd?userId=${user.id}','commentModal')">
                                    填写服务评价
                                </button>
                            </c:if>
                        </td>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="modal inmodal fade" id="commentModal" tabindex="-1" role="dialog" aria-hidden="true"></div>
<jsp:include page="${ctx}/WEB-INF/import/script.jsp"/>
</body>
</html>
