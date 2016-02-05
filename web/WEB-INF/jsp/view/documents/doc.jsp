
<template:main htmlTitle="${title}" bodyTitle="${title}">
    <jsp:attribute name="content">
            <div class="row">
                <div class="col-lg-6">
                    <div class="row">
                        <div class="col-lg-1 center-block">#</div>
                        <div class="col-lg-2 center-block">Тип документа</div>
                        <div class="col-lg-3 center-block">Дата создания</div>
                        <div class="col-lg-3 center-block">Дата документа</div>
                        <div class="col-lg-3 center-block">Контрагент</div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="row">
                        <div class="col-lg-4 center-block">Товар</div>
                        <div class="col-lg-2 center-block">Кол.,<br>шт</div>
                        <div class="col-lg-3 center-block">Сумма</div>
                        <div class="col-lg-3 center-block">Склад</div>
                    </div>
                </div>
                <div class="col-lg-2">Итого</div>
            </div>
            <c:forEach items="${documents}" var="document" varStatus="i">

                <div class="row" style="border-radius: 15px; border: 1px solid #333333; margin-top: 0.5%">
                     <div class="col-lg-6">
                         <div class="row">
                            <div class="col-lg-1 center-block"><c:out value="${i.index}"/></div>
                            <div class="col-lg-2 center-block"><c:out value="${document.documentType}"/></div>
                            <div class="col-lg-3 center-block"><c:out value="${document.insertTimestamp}"/></div>
                            <div class="col-lg-3 center-block"><c:out value="${document.dateOfDocument}"/></div>
                            <div class="col-lg-3 center-block"><c:out value="${document.partner.lastname}"/></div>
                         </div>
                     </div>
                     <div class="col-lg-4">
                            <c:set var="sum" value="${0}"/>
                            <c:forEach items="${document.details}" var="detail">
                                <div class="row">
                                    <div class="col-lg-4 center-block"><c:out value="${detail.product.name}"/></div>
                                    <div class="col-lg-2 center-block"><c:out value="${detail.quantity}"/></div>
                                    <div class="col-lg-3 center-block"><c:out value="${detail.sum}"/></div>
                                    <div class="col-lg-3 center-block"><c:out value="${detail.storage.name}"/></div>
                                </div>
                            <c:set var="sum" value="${sum + detail.sum}"/>
                            </c:forEach>
                     </div>
                     <div class="col-lg-2"><c:out value="${sum}"/></div>
                </div>
                </c:forEach>
    </jsp:attribute>
</template:main>
