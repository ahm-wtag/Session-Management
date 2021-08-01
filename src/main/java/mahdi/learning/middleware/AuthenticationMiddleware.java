package mahdi.learning.middleware;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationMiddleware implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies = request.getCookies();
        System.out.println("iN MIDDLEWARE");
        if ( cookies == null ) {
            response.sendRedirect("/login");
            return false;
        }

        return true;

    }
}
