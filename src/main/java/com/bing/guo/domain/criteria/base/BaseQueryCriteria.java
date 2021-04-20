package com.bing.guo.domain.criteria.base;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BaseQueryCriteria {

    private int currentPage = 1;
    private int pageSize = 5;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
