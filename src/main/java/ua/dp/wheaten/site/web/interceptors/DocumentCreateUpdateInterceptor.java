package ua.dp.wheaten.site.web.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.services.DocumentService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by kkm on 18.05.2016.
 */
public class DocumentCreateUpdateInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = LogManager.getLogger();

    private static final String POST = "POST";

    @Inject
    private DocumentService documentService;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getMethod().equals(POST))
            return true;

        String dateOfDocument = request.getParameter("dateOfDocument");

        if (dateOfDocument == null) {
            response.sendError(400, "Date of document has not been set");
            return false;
        }

        try {
            LocalDate date = LocalDate.parse(dateOfDocument);
        } catch (DateTimeParseException e) {
            log.info(e.getMessage());

            response.sendRedirect(request.getRequestURL().toString());
            return false;
        }





       // if (date.withDayOfMonth())

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("post-handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("after completion");
    }
}
