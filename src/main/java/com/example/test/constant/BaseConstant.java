package com.example.test.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseConstant {
    public static final String API_PREFIX = "/api/v1";

    public static final String TRANSACTION_RECORD_API = API_PREFIX + "/transaction";

    public static final String TRANSACTION_RECORD_SEARCH_API = TRANSACTION_RECORD_API + "/search";

    public static final Integer LAST_THREE_MINUTES = 3;
}
