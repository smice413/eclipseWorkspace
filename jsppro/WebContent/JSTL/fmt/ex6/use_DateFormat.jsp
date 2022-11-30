<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>numberFormat 태그 사용</title></head>
<body>

<c:set var="now" value="<%= new java.util.Date() %>" />
${now }<br>
<c:out value="${now }"/> <br>


<fmt:formatDate value="${now}" type="date" dateStyle="full" /> <br>
<fmt:formatDate value="${now}" type="date" dateStyle="short" /> <br>
<fmt:formatDate value="${now}" type="time" /> <br>
<fmt:formatDate value="${now}" type="both" 
                dateStyle="full" timeStyle="full" /> <br>
                <!-- type="both" : 날짜와 시간을 둘다 쓰겠다는 의미 -->
<fmt:formatDate value="${now}" pattern="z a h:mm" /> <br>
<!--  pattern="z a h:mm" : z는 타임존, a는 오전 오후 h또는 hh(12시간제), HH(24시간제)로 써도 됨 -->

<fmt:formatDate value="${now}" pattern="yyyy-MM-dd a hh:mm:ss EEE요일"/><br>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss EEE요일"/><br>

</body>
</html>
