package ua.dp.wheaten.site.web.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by kkm on 06.06.2016.
 */
public class DocumentCreationInterceptor extends AbstractDocumentInterceptor {

    private static final String POST = "POST";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getMethod().equals(POST))
            return true;

        LocalDate requestDate = this.retrieveDate(request);

        LocalDate current = LocalDate.now();

        return this.compareDates(current, requestDate);
    }
}
