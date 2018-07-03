package com.test.repository;

import com.test.model.ApiUsage;
import com.test.model.User;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiUsageRepository extends JpaRepository<ApiUsage, Long> {

  List<ApiUsage> findApiUsagesByTimestampBetweenAndUser(Timestamp start, Timestamp stop, User user);
}
