<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Activity Page </title>
</head>
<body>
<h3>
	Add an Activity
        
</h3>

<c:url var="addAction" value="/activity/add" ></c:url>

<form:form action="${addAction}" commandName="activity">
<table>
	<c:if test="${!empty activity.activityName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="activityName">
				<spring:message text="Activity Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="activityName" />
		</td> 
	</tr>
        
        <tr>
		<td>
			<form:label path="isActive">
				<spring:message text="isActive"/>
			</form:label>
		</td>
		<td>
			<form:checkbox path="isActive" />
		</td> 
	</tr>
       
        
        <tr>
		
                <td>
			<form:hidden path="createdDate" />
		</td> 
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty activity.activityName}">
				<input type="submit"
					value="<spring:message text="Edit Activity"/>" />
			</c:if>
			<c:if test="${empty activity.activityName}">
				<input type="submit"
					value="<spring:message text="Add Activity"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
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
                        <td>${Activity.activityType}</td>
			<td>${Activity.activityDescription}</td>
			<td><a href="<c:url value='activity/edit/${Activity.id}' />" >Edit</a></td>
			<td><a href="<c:url value='activity/remove/${Activity.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if> 
</body>
</html>
