<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Activity List </title>
</head>
<a href="/DailyActivityManager/activity">New Activity</a>

<h3>Activity  List</h3>
<c:if test="${!empty listActivites}">
	<table class="tg">
	<tr>
		<th width="80">Activity ID</th>
		<th width="120">Activity Name</th>
                <th width="120">Activity Type</th>
		<th width="120">Description</th>
                <th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listActivites}" var="Activity">
		<tr>
			<td>${Activity.id}</td>
			<td>${Activity.activityName}</td>
                        <td>${Activity.activityType.activityTypeName}</td>
			<td>${Activity.activityDescription}</td>
			<td><a href="<c:url value='activity/edit/${Activity.id}' />" >Edit</a></td>
			<td><a href="<c:url value='activity/remove/${Activity.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if> 

</html>
