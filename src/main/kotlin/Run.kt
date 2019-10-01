import App.javalin
import controller.Controller
import io.javalin.Javalin

object App {
    val javalin: Javalin = Javalin.create()
}

/**
 * Execute this function to start the app
 * Run gradle build task 'fatJar' to create a complete, self-contained jar file.
 * Execute the jar file using:
 * # java -jar <jar-path>
 */
fun main() {
    javalin.start()
    AppModule.GuiceInjectorProvider.injector.getInstance(Controller::class.java).registerRoutes()
}
