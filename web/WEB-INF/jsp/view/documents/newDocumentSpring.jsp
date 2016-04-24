<template:main htmlTitle="Новый заказ" bodyTitle="Новый заказ">
    <jsp:attribute name="content">
    <div class="container">
      <form:form role="form" modelAttribute="docWrapper">
        <div id="docHead">
          <div class="row">
            <div class="col-lg-4 col-xs-8">
              <form:select path="document.documentType" cssClass="form-control input-sm" id="operation" >
                <option>Тип операции</option>
                <form:options items="${documentTypes}" itemValue="key" itemLabel="value" />
              </form:select>


            </div>
            <div class="col-xs-4">
              <div class="form-group">
                <div class="input-group date" id="datetimepicker">
                  <form:input path="document.dateOfDocument" cssClass="form-control input-sm" placeholder="Дата докумета"/>
                                            <span class="input-group-addon">
                                              <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-4">
              <form:select path="document.partner" cssClass="form-control input-sm" id="partner" >
                <option>Контрагент</option>
                <form:options items="${partners}" itemValue="id" itemLabel="fullname"/>
              </form:select>
            </div>
            <div class="col-xs-4">
                <div class="checkbox">
                    <label>
                        <form:checkbox path="document.status" /> Провести
                    </label>
                </div>
            </div>
          </div>
        </div>
        <hr>
        <div id="records">
          <div class="row">
            <div class="col-xs-3">
              <strong>Товар</strong>
            </div>
            <div class="col-xs-2">
              <span>Склад</span>
            </div>
            <div class="col-xs-2">
              <span style="font-weight: bold;">Количество</span>
            </div>
            <div class="col-lg-4 col-xs-4">Цена</div>
          </div>

          <c:forEach items="${docWrapper.details}" varStatus="i" >

            <div class="row data" id="dataRow${i.index}">
              <div class="col-xs-3">
                  <form:select path="details[${i.index}].product" items="${products}" itemValue="id" itemLabel="name" cssClass="form-control input-sm" />
              </div>
              <div class="col-xs-2">
                  <form:select path="details[${i.index}].storage" items="${storages}" itemValue="id" itemLabel="name" cssClass="form-control input-sm" />
              </div>
              <div class="col-xs-2">
                <form:input path="details[${i.index}].quantity" cssClass="form-control quantityInput input-sm" />
              </div>
              <div class="col-xs-2">
                <form:input path="details[${i.index}].price" cssClass="form-control priceInput input-sm" />
              </div>
          </div>
            <c:set var="count" value="${i.index}"/>
          </c:forEach>

        </div>

        <a href="javascript:void(0)" id="add" style="float: right"><span class="glyphicon glyphicon-plus-sign"></span></a><br>
        <button type="submit">Сохранить</button>
      </form:form>
    </div>
    </jsp:attribute>
    <jsp:attribute name="footerContent">


    <script type="text/javascript">

      $("#datetimepicker").datetimepicker(
              {pickTime: false, language: 'ru'}
      );

      var records = $('#records');
      var rTableRow = $('#dataRow0').html();
      var i = <c:out value="${count}" />


      $('#add').click(function() {
        i++;
        records.append('<div class="row data" id="dataRow' + i + '">' +
                '<div class="col-xs-3">' +
                '<select id="details' + i +'.product" name="details[' + i + '].product" class="form-control input-sm"><option value="1">Пшеничная 10 </option><option value="2" selected="selected">Коньяк</option></select></div>' +
                '<div class="col-xs-2">' +
                '<select id="details' + i + '.storage" name="details[' + i + '].storage" class="form-control input-sm"><option value="1" selected="selected">Завод</option><option value="2">Пчела</option><option value="3">Автоматы</option><option value="4">Пиздец, как далеко</option><option value="5">Офис</option></select></div>' +
                '<div class="col-xs-2">' +
                '<input id="details' + i + '.quantity" name="details[' + i + '].quantity" class="form-control input-sm quantityInput" type="text" value=""/></div>' +
                '<div class="col-xs-2">' +
                '<input id="details' + i + '.price" name="details[' + i + '].price" class="form-control input-sm priceInput" type="text" value=""/></div>' +
                '</div>');
      //  records.append('<div class="row data">' + rTableRow + '<div class="col-xs-1"><a href="javascript:void(0)" onclick="delRecord();" style="float: right"><span class="glyphicon glyphicon-remove"></span></a><br></div></div>');
      });
    </script>
    </jsp:attribute>
</template:main>
