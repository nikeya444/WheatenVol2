<template:main htmlTitle="Новый заказ" bodyTitle="Новый заказ">
    <jsp:attribute name="content">
    <div class="container">
      <form:form role="form" modelAttribute="docWrapper">
        <div id="docHead">
          <div class="row">
            <div class="col-lg-4 col-xs-8">
              <label for="operation">Тип операции:</label>
              <form:select path="document.documentType" items="${documentTypes}" class="form-control" id="operation" />


            </div>
          </div>
          <div class="row">
            <div class="col-lg-4 col-xs-8">
              <label for="partner">Контрагент:</label>
              <form:select path="document.partner" items="${partners}" class="form-control" id="partner" />
            </div>
          </div>
        </div>
        <hr>
        <div id="records">
          <div class="row">
            <div class="col-lg-4 col-xs-4">
              <strong>Товар</strong>
            </div>
            <div class="col-lg-4 col-xs-4">
              <span style="font-weight: bold;">Количество</span>
            </div>
            <div class="col-lg-4 col-xs-4">Цена</div>
          </div>
          <c:forEach items="${docWrapper.details}" varStatus="i" >
            <div class="row data" id="dataRow${i.index}">
              <div class="col-lg-4 col-xs-4">

                  <form:select path="details[${i.index}].product" items="${products}" cssClass="form-control" />

                <!--               <input class="productInput" type="text" name="productId" value="" />     -->
              </div>
              <div class="col-lg-4 col-xs-4">
                <form:input path="details[${i.index}].quantity" cssClass="form-control quantityInput" />
              </div>
              <div class="col-lg-3 col-xs-3">
                <form:input path="details[${i.index}].price" cssClass="form-control priceInput" />
              </div>
          </div>
          </c:forEach>
        </div>

        <a href="javascript:void(0)" id="add" style="float: right"><span class="glyphicon glyphicon-plus-sign"></span></a><br>
        <button type="submit">Сохранить</button>
      </form:form>
    </div>
    </jsp:attribute>
    <jsp:attribute name="footerContent">


    <script type="text/javascript">
      var records = $('#records');
      var rTableRow = $('#dataRow0').html();



      $('#add').click(function() {

        records.append('<div class="row data">' + rTableRow + '<div class="col-xs-1"><a href="javascript:void(0)" onclick="delRecord();" style="float: right"><span class="glyphicon glyphicon-remove"></span></a><br></div></div>');
      });
      var docForm = {}
      var doc = {};
      var docDetails = [];

      alert($(".data").html());

     /* function delRecord() {
        alert($(this).closest(".data").html());
      }*/



    </script>
    </jsp:attribute>
</template:main>
