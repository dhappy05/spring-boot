package com.ding.readWriteSparation.base;


import com.ding.readWriteSparation.utils.JacksonUtil;

import java.io.Serializable;

/**
 * Created by ding on 2017/11/2.
 */
public class BaseVo implements Serializable {
    @Override
    public String toString() {
        return JacksonUtil.toJson(this);
    }
}
