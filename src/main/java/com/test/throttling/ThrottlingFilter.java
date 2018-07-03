package com.test.throttling;

import com.test.conf.UserDetailsImpl;
import com.test.model.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ThrottlingFilter  implements Filter {

  @Autowired
  private ThrottlingService throttlingService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    User authenticatedUser = ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal()).getUser();
    throttlingService.checkApiUsage(authenticatedUser, httpServletRequest, httpServletResponse, chain);

  }

  @Override
  public void destroy() {

  }
}
