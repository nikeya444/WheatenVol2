<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet">
    <title></title>
</head>
<body>
<h2>Новый документ</h2>
    <form>
        <div id="docHead">
            <p><label for="operation">Тип операции:</label>
                <select id="operation" name="documentType">
                    <option>Тип документа</option>
                    <c:forEach items="${documentTypes}" var="documentType">
                        <option value="${documentType}">${documentType}</option>
                    </c:forEach>
                </select>
        <!--        <input id="operation" name="documentType" type="text"/></p>     -->
        <p><label for="partner">Контрагент:</label>
            <input id="partner" name="partnerId" type="text"/></p>
        </div>
        <hr>
        <div class="rTable">
            <div class="rTableRow">
                <div class="rTableHead">
                    <strong>Товар</strong>
                </div>
                <div class="rTableHead">
                    <span style="font-weight: bold;">Количество</span>
                </div>
                <div class="rTableHead">Цена</div>
            </div>
            <div class="rTableRow data" id="dataRow">
                <div class="rTableCell">
                    <select name="productId">
                        <option>Выберите товар...</option>
                        <c:forEach items="${products}" var="product">
                            <option value="${product.id}">${product.name}</option>
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
        <a href="#" id="submit">Сохранить</a>
    </form>

    <script src="<c:url value='/resources/js/jquery-2.1.4.js'/>"></script>
    <script type="text/javascript">
        var records = $('.rTable');
        var rTableRow = $('#dataRow');
        var htmlr = rTableRow.html();


        $('#add').click(function() {

            records.append('<div class="rTableRow data">' + rTableRow.html() + '</div>');
        });
        var docForm = {}
        var doc = {};
        var docDetails = [];

        $('#submit').click(createDocument);



        function createDocument() {
            $('#docHead').find('input').each(function() {
                doc[$(this).attr('name')] = $(this).val();
            });
            $('.data').each(function() {
                var o = {};
                $(this).find('input, select').each(function() {
                    o[$(this).attr('name')] = $(this).val();
                });
                docDetails.push(o);
            });
         //   doc['details'] = docDetails;
            docForm["document"] = doc;
            docForm["details"] = docDetails;
            alert(JSON.stringify(docForm));

            $.ajax({
                url: "<c:url value='/documents/new1'/>",
                type: "POST",
                contentType: 'application/json',
                data: JSON.stringify(docForm),
                success: function(data) {
                    alert(data);
                },
                error: function(msg) {
                    alert(msg);
                }
            });
        }

    </script>
</body>
</html>