import App.javalin
import controller.Controller
import io.javalin.Javalin

object App {
    val javalin: Javalin = Javalin.create()
}

fun main() {
    javalin.start()
    AppModule.GuiceInjectorProvider.injector.getInstance(Controller::class.java).registerRoutes()
}
