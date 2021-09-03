<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Activity List </title>
</head>
<a href="/DailyActivityManager/">Home</a><a href="/DailyActivityManager/activityList">Activity List</a><a href="/DailyActivityManager/activityTypeList">Activity Type List</a>
<c:url var="search" value="/activityList/search" ></c:url>

<form action="${search}">
<input type="date" name="startDate" value="${startDate}" placeholder="from date">
<input type="date" name="endDate" value="${endDate}" placeholder=" to date">
<button>Search</button>
</form>

<h3>Activity  List</h3>
<a href="/DailyActivityManager/activity">New Activity</a>
<c:if test="${!empty listActivites}">
	<table class="tg">
	<tr>
		<th width="150">Activity Date</th>
		<th width="120">Activity Name</th>
                <th width="120">Activity Type</th>
		<th width="320">Description</th>
                <th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listActivites}" var="Activity">
		<tr>
			<td width="150">${Activity.createdDate}</td>
			<td width="120">${Activity.activityName}</td>
                        <td width="120">${Activity.activityType.activityTypeName}</td>
			<td width="60">${Activity.activityDescription}</td>
			<td width="60"><a href="<c:url value='activity/edit/${Activity.id}' />" >Edit</a></td>
			<td width="60"><a href="<c:url value='activity/remove/${Activity.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if> 

</html>
