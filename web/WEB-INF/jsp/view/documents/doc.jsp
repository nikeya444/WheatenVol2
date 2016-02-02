
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
                        <div>
                            <td><c:out value="${i.index}"/></td>
                            <td><c:out value="${document.documentType}"/></td>
                            <td><c:out value="${document.insertTimestamp}"/></td>
                            <td><c:out value="${document.dateOfDocument}"/></td>
                            <td><c:out value="${document.partner.lastname}"/></td>
                            <c:set var="sum" value="0"/>
                        </div>
                        <div>
                            <c:forEach items="${document.details}" var="detail">
                                <table>
                                    <tr>
                                        <td><c:out value="${detail.product.name}"/></td>
                                        <td><c:out value="${detail.quantity}"/></td>
                                        <td><c:out value="${detail.sum}"/></td>
                                    </tr>
                                </table>
                            </c:forEach>
                            <td><c:out value="${sum}"/></td>
                        </div>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </jsp:attribute>
</template:main>
