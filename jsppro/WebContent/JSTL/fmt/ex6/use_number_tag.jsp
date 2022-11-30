<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>formatNumber 태그 사용</title></head>
<body>

<c:set var="price" value="10000" />
<!-- formatNumber로 출력하면 숫자 3자리씩 끊어서 출력됨 10,000 이런식 -->
<fmt:formatNumber value="${price}" type="number" var="numberType" />
숫자: ${numberType} <br>

통화: <fmt:formatNumber value="${price}" type="currency" currencySymbol="$" /><br>

퍼센트: <fmt:formatNumber value="${price}" type="percent" groupingUsed="true" /> <br> <!-- groupingUsed="true" : 3자리씩 끊어서 출력하겠다는 의미 -->
퍼센트: <fmt:formatNumber value="${price}" type="percent" groupingUsed="false" /> <br> <!-- groupingUsed="true" : 3자리씩 끊지 않고 출력하겠다는 의미 -->

패턴: <fmt:formatNumber value="${price}" pattern="00000000.00"/>

</body>
</html>
