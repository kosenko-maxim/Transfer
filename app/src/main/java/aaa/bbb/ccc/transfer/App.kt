package aaa.bbb.ccc.transfer

import aaa.bbb.ccc.transfer.data.dagger.AppComponent
import aaa.bbb.ccc.transfer.data.dagger.DaggerAppComponent
import aaa.bbb.ccc.transfer.data.dagger.module.AppModule
import aaa.bbb.ccc.transfer.data.dagger.module.NetModule
import android.app.Application

class App : Application() {
    companion object {
        @JvmStatic
        lateinit var component: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .netModule(NetModule())
            .appModule(AppModule())
            .build()
    }

}