package aaa.bbb.ccc.transfer.data.dagger.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class AppModule {
    var cicerone: Cicerone<Router>

    init {
        cicerone = Cicerone.create()
    }

    @Provides
    fun getRouter(): Router {
        return cicerone.router
    }

    @Provides
    fun getNavigationHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}