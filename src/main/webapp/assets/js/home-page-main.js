/**
 * Created by dushang on 2016/8/16.
 */
require.config({
    baseUrl:webRoot+"/assets/",
    paths:{
        "jQuery":"js/common/jquery-2.2.2",
        "bootstrapJs":"bootstrap/js/bootstrap.min",

        "homePage":"js/home-page",
        "header":'js/header'
    },

    shim:{
        "jQuery": { exports: "$" },
        "bootstrapJs": { deps: ["jQuery"] }
    }
});

require(
    [
        "jQuery",
        "homePage",
        "header"
    ]
);