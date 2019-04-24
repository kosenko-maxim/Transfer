package aaa.bbb.ccc.transfer.data.dagger

import aaa.bbb.ccc.transfer.data.dagger.module.AppModule
import aaa.bbb.ccc.transfer.data.dagger.module.NetModule
import aaa.bbb.ccc.transfer.mvp.presenter.login.LoginAndRegistPresenter
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainPresenter
import aaa.bbb.ccc.transfer.ui.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(NetModule::class, AppModule::class))
interface AppComponent {
    fun injectsToMainActivity(mainPresenter: MainPresenter)
    fun injectsToLogActivity(loginAndRegistPresenter: LoginAndRegistPresenter)
}