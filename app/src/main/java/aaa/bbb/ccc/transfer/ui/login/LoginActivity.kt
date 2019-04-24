package aaa.bbb.ccc.transfer.ui.login

import aaa.bbb.ccc.transfer.mvp.moxy.MvpAppCompatActivity
import aaa.bbb.ccc.transfer.R
import aaa.bbb.ccc.transfer.mvp.presenter.login.LoginAndRegistPresenter
import aaa.bbb.ccc.transfer.mvp.presenter.login.LoginAndRegistView
import aaa.bbb.ccc.transfer.util.Screens
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class LoginActivity : MvpAppCompatActivity(), LoginAndRegistView {

    lateinit var navigator: Navigator

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var presenter: LoginAndRegistPresenter
    var idToken: String = ""
    companion object {
        lateinit var Sharedprefernces_IdToken: SharedPreferences
        private val App_Prefences = "aaa.bbb.ccc.transfer.ui.login"
        val App_Prefences_Id_Token = "idToken"
    }


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        navigator = SupportAppNavigator(this, R.id.container)
        Sharedprefernces_IdToken = getSharedPreferences(App_Prefences, Context.MODE_PRIVATE)
        idToken = Sharedprefernces_IdToken.getString(App_Prefences_Id_Token, "")

        if (!idToken.isEmpty()) {
            presenter.replaceScreen(Screens.MainScreen())
        }
        RxView.clicks(btnLogin).subscribe {
            presenter.loginUser(
                inputEmail.text.toString(),
                inputPassword.text.toString()
            )
        }
        RxView.clicks(linkSignup).subscribe {
            presenter.navigateTo(Screens.RegisterScreen())
        }
    }

    override fun showError(text: String) {
        toast(text)
    }

    override fun saveIdToken(idToken: String) {
        Sharedprefernces_IdToken.edit().putString(App_Prefences_Id_Token, idToken).apply()
        Log.d("LogActivity",idToken)
        presenter.replaceScreen(Screens.MainScreen())
    }


    override fun onResume() {
        super.onResume()
        presenter.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        presenter.navigatorHolder.removeNavigator()
    }
}