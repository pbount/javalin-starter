package controller

import io.javalin.apibuilder.ApiBuilder.*

class Controller {
    fun registerRoutes(){
        App.javalin.routes {
            path("v1"){
                get("test/:property") {
                    println(it.pathParam("property"))
                }
            }
        }

        App.javalin.get("/") { ctx -> ctx.result("${ctx.status()}") }
    }
}
