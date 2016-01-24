<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!--<link href="<c:url value='/resources/css/styles.css'/>" rel="stylesheet"> -->
    <title></title>
</head>
<body>
<h1>Новый документ</h1>
<div>
    <form:form method="post" modelAttribute="documentForm">
        <form:label path="documentType">Тип документа:</form:label><br />
        <form:input path="documentType" /><br />
        <br />
        <form:label path="partner">Контрагент:</form:label><br />
        <form:input path="partner" /><br />
        <br />
        <c:forEach items="${documentForm.details}" var="detail">
            <hr>
            <form:label path="${detail.productId}">Товар:</form:label><br />
            <form:input path="${detail.productId}" /><br />
            <br/>
            <form:label path="${detail.quantity}">Количество:</form:label><br />
            <form:input path="${detail.quantity}" /><br />
            <br/>
            <form:label path="${detail.price}">Цена:</form:label><br />
            <form:input path="${detail.price}" /><br />
            <br/>
            <form:label path="${detail.sum}">Сумма:</form:label><br />
            <form:input path="${detail.sum}" /><br />
            <br/>
        </c:forEach>
        <input type="submit" value="Save" />
    </form:form>
</div>
</body>
</html>