package com.bing.guo.controller.base;

import com.bing.guo.common.http.AxiosResult;
import com.bing.guo.common.http.EnumStatus;

public class BaseController {

    protected AxiosResult<Void> toCompare(int row) {
        return row > 0 ? AxiosResult.success() : AxiosResult.error(EnumStatus.UPDATE_ERROR);
    }
}
