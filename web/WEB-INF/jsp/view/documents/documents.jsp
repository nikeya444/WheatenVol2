
<template:main htmlTitle="${title}" bodyTitle="${title}">
    <jsp:attribute name="content">
        <div class="container">
            <table class="table table-striped table-hover">
                <tr>
                    <th>#</th>
                    <th>Тип документа</th>
                    <th>Дата создания</th>
                    <th>Дата документа</th>
                    <th>Контрагент</th>
                    <th>Сумма документа</th>
                </tr>

                <c:forEach items="${documents}" var="document" varStatus="i">
                    <tr>
                        <td><c:out value="${i.index}"/></td>
                        <td><c:out value="${document.documentType}"/></td>
                        <td><c:out value="${document.insertTimestamp}"/></td>
                        <td><c:out value="${document.dateOfDocument}"/></td>
                        <td><c:out value="${document.partner.lastname}"/></td>
                        <c:set var="sum" value="0"/>
                        <c:forEach items="${document.details}" var="detail">
                            ${sum += detail.sum}
                        </c:forEach>
                        <td><c:out value="${document.partner.lastname}"/></td>

                        <table>
                            <tr>
                                <th># партии</th>
                                <th>Наименование</th>
                                <th>Количество</th>
                                <th>Цена</th>
                                <th>Сумма</th>
                                <th>Склад</th>
                            </tr>

                            <c:forEach items="${document.details}" var="detail" varStatus="i">
                                <tr>
                                    <td><c:out value="${i.index}"/></td>
                                    <td><c:out value="${detail.product.name}"/></td>
                                    <td><c:out value="${detail.quantity}"/></td>
                                    <td><c:out value="${detail.price}"/></td>
                                    <td><c:out value="${detail.sum}"/></td>
                                    <td><c:out value="${detail.storage.name}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </jsp:attribute>
</template:main>
