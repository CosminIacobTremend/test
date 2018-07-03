package com.test.throttling;

import com.test.model.ApiUsage;
import com.test.model.User;
import com.test.repository.ApiUsageRepository;
import com.test.repository.UserRepository;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ThrottlingService {

  @Autowired
  private ApiUsageRepository apiUsageRepository;

  @Value("${api.usage.limit}")
  private Integer usageLimit;

  @Transactional
  public void checkApiUsage(User user, HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws IOException, ServletException {

    Timestamp now = Timestamp.valueOf(LocalDateTime.now());
    Timestamp hoursBefore = Timestamp.valueOf(LocalDateTime.now().minusHours(1));

    List<ApiUsage> apiUsageList = apiUsageRepository
        .findApiUsagesByTimestampBetweenAndUser(hoursBefore, now, user);

    if (apiUsageList == null || apiUsageList.size() < usageLimit ) {
      ApiUsage apiUsage = new ApiUsage();
      apiUsage.setTimestamp(now);
      apiUsage.setUser(user);
      apiUsageRepository.save(apiUsage);
      filterChain.doFilter(request, response);

    } else {
      response.sendError(429);
    }



  }

}
