package ru.intelinvest.consts;

public class ApiConsts {
    //endpoints
    public static final String PORTFOLIO_OVERVIEW_ENDPOINT = "/portfolios/%s/overview",
            PORTFOLIO_INFO_ENDPOINT = "/portfolio-info/%s",
            DELETE_ALL_ENDPOINT = "/trades/deleteAll",
            DELETE_ENDPOINT = "/trades/delete",
            LOGIN_ENDPOINT = "/user/login",
            TRADES_ENDPOINT = "/trades",
            MARKET_INFO_ENDPOINT = "/market/share/%s/info";

    //error codes
    public static final int BAD_REQUEST_CODE = 400,
            UNAUTHORIZED_CODE = 401,
            FORBIDDEN_CODE = 403,
            NOT_FOUND_CODE = 404,
            OK_CODE = 200,
            NO_CONTENT_CODE = 204,
            SERVER_INTERNAL_ERROR_CODE = 500;
}
