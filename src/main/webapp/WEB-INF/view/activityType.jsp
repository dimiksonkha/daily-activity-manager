<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Activity Type Page </title>
</head>
<body>
<h3>
	Add an Activity Type
        
</h3>

<c:url var="addAction" value="/activityType/add" ></c:url>

<form:form action="${addAction}" commandName="activityType">
<table>
	<c:if test="${!empty activityType.activityTypeName}">
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
			<form:label path="activityTypeName">
				<spring:message text="ActivityType Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="activityTypeName" />
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
			<c:if test="${!empty activityType.activityTypeName}">
				<input type="submit"
					value="<spring:message text="Edit ActivityType"/>" />
			</c:if>
			<c:if test="${empty activityType.activityTypeName}">
				<input type="submit"
					value="<spring:message text="Add ActivityType"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Activity Type List</h3>
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
			<td>${ActivityType.id}</td>
			<td>${ActivityType.activityTypeName}</td>
			<td><a href="<c:url value='/edit/${ActivityType.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${ActivityType.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if> 
</body>
</html>
