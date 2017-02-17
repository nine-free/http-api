package com.soft1010.common.httpapi.annotation;

import java.lang.annotation.*;

/**
 * @author
 * @version api调用次数限制
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRateLimiter {
    int value();
}
