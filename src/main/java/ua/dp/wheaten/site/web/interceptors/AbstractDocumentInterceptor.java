package ua.dp.wheaten.site.web.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Created by kkm on 06.06.2016.
 */
abstract class AbstractDocumentInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LogManager.getLogger();

    protected LocalDate retrieveDate(HttpServletRequest request) throws Exception {

        String dateOfDocument = request.getParameter("dateOfDocument");

        return LocalDate.parse( dateOfDocument );
    }

    protected boolean compareDates(LocalDate currentDate, LocalDate requestDate) {

        currentDate.withDayOfMonth(1);
        requestDate.withDayOfMonth(1);

        return requestDate.isAfter( currentDate );
    }

}
