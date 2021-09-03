<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Activity Type Page </title>
</head>
<body>
    <a href="/DailyActivityManager/">Home</a><a href="/DailyActivityManager/activityList">Activity List</a><a href="/DailyActivityManager/activityTypeList">Activity Type List</a>
<h3>
	Activity Type List
        
</h3>

<a href="/DailyActivityManager/activityType">New Activity Type</a>
<c:if test="${!empty listActivityTypes}">
	<table class="tg">
	<tr>
		<th width="80">ActivityType ID</th>
		<th width="120">ActivityType Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listActivityTypes}" var="ActivityType">
		<tr>
			<td>${ActivityType.activityTypeId}</td>
			<td>${ActivityType.activityTypeName}</td>
			<td><a href="<c:url value='/edit/${ActivityType.activityTypeId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${ActivityType.activityTypeId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if> 
</body>
</html>
