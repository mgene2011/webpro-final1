<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<script type="text/javaScript" language="javascript" defer="defer">
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/student/addStudentView.do'/>";
   	document.getElementById("listForm").submit();		
}
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<th align="center">Number</th>
			<th align="center">Name</th>
		</tr>
		<c:forEach var="result" items="${resultList}" varStatus="status">
		<tr>
			<td align="center" class="listtd"><c:out value="${result.number}"/>&nbsp;</td>
			<td align="center" class="listtd"><c:out value="${result.name}"/>&nbsp;</td>
		</tr>
		</c:forEach>
	</table>
	<a href="javascript:fn_egov_addView();">등록</a>
</form:form>
</body>
</html>
