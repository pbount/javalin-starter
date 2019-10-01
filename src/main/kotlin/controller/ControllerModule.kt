package controller

import com.authzee.kotlinguice4.KotlinModule

class ControllerModule: KotlinModule() {
    override fun configure() {
        bind<Controller>()
    }
}
