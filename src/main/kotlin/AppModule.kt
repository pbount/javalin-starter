import com.authzee.kotlinguice4.KotlinModule
import com.google.inject.Guice
import controller.ControllerModule

class AppModule: KotlinModule() {

    object GuiceInjectorProvider {
        val injector = Guice.createInjector(AppModule())
    }

    override fun configure() {
        install(ControllerModule())
    }
}
