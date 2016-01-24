<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet">
    <title></title>
</head>
<body>
<h2>Новый документ</h2>
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
    </c:forEach>
                </select>
                <!--               <input class="productInput" type="text" name="productId" value="" />     -->
            </div>
            <div class="rTableCell">
                <input class="quantityInput" type="text" name="quantity" value="" />
            </div>
            <div class="rTableCell">
                <input class="priceInput" type="text" name="price"  value="0"/>
            </div>
        </div>
    </div>
    <a href="#" id="add" style="float: right">+</a><br>
    <input type="submit">Сохранить</input>
</form>

<script src="<c:url value='/resources/js/jquery-2.1.4.js'/>"></script>
<script type="text/javascript">
    var records = $('.rTable');
    var rTableRow = $('#dataRow');
    var htmlr = rTableRow.html();


    $('#add').click(function() {
        records.append('<div class="rTableRow data">' + rTableRow.html() + '</div>');
    });






</script>
</body>
</html>