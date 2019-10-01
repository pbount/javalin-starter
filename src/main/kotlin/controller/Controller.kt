package controller

import io.javalin.apibuilder.ApiBuilder.*

class Controller {

    fun registerRoutes(){

        /**
         * Example simple get route
         */
        App.javalin.get("/") {
                ctx -> ctx.result("${ctx.status()}")
        }

        /**
         * Example get route with path parameter
         * Visiting 'host:port/test/property will print 'property'
         */
        App.javalin.routes {
            path("v1"){
                get("test/:property") {
                    println(it.pathParam("property"))
                }
            }
        }
    }
}
