<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Activity Page </title>
</head>

<h3>Add an Activity</h3>

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
			<form:label path="activityType">
				<spring:message text="Activity Type"/>
			</form:label>
		</td>
            <td>
                	<form:select path="activityType.activityTypeId">    
		         <c:forEach items="${listActivityTypes}" var="activityType">
			 <option value="${activityType.activityTypeId}">${activityType.activityTypeName}</option>
			 </c:forEach>
		        </form:select>
            </td>
        </tr>
        <tr>
		<td>
			<form:label path="activityDescription">
				<spring:message text="Activity Description"/>
			</form:label>
		</td>
		<td>
			<form:textarea path="activityDescription" />
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
				<input type="submit" id="editActivity"
					value="<spring:message text="Edit Activity"/>" />
			</c:if>
			<c:if test="${empty activity.activityName}">
				<input type="submit" id="addActivity"
					value="<spring:message text="Add Activity"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
</html>
