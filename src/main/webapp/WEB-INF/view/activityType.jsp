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
	Activity Type
        
</h3>
    <a href="/DailyActivityManager/">Home</a><a href="/DailyActivityManager/activityList">Activity List</a><a href="/DailyActivityManager/activityTypeList">Activity Type List</a>

<c:url var="addAction" value="/activityType/add" ></c:url>

<form:form action="${addAction}" commandName="activityType">
<table>
	<c:if test="${!empty activityType.activityTypeName}">
	<tr>
		<td>
			<form:label path="activityTypeId">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="activityTypeId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="activityTypeId" />
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

</body>
</html>
