package aaa.bbb.ccc.transfer.mvp.presenter.login


import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LoginAndRegistView : MvpView {
    fun showError(text: String)
    fun saveIdToken(idToken: String)
}
