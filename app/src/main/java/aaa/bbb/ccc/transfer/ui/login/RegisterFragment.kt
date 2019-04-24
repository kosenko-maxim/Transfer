package aaa.bbb.ccc.transfer.ui.login

import aaa.bbb.ccc.transfer.mvp.moxy.MvpAppCompatFragment
import aaa.bbb.ccc.transfer.R
import aaa.bbb.ccc.transfer.mvp.presenter.login.LoginAndRegistPresenter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import aaa.bbb.ccc.transfer.mvp.presenter.login.LoginAndRegistView
import aaa.bbb.ccc.transfer.ui.login.LoginActivity.Companion.App_Prefences_Id_Token
import aaa.bbb.ccc.transfer.ui.login.LoginActivity.Companion.Sharedprefernces_IdToken
import aaa.bbb.ccc.transfer.util.Screens
import android.annotation.SuppressLint
import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_register.*
import org.jetbrains.anko.support.v4.toast


class RegisterFragment : MvpAppCompatFragment(), LoginAndRegistView {

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var presenter: LoginAndRegistPresenter


    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
       RxView.clicks(view.findViewById(R.id.btnRegister)).subscribe{
            presenter.registerUser(
                inputUsername.text.toString(),
                inputPassword.text.toString(),
                inputEmail.text.toString())
        }
        return view
    }


    override fun showError(text: String) {
       toast(text)
    }

    override fun saveIdToken(idToken: String) {
        Log.d("++++++++++=",idToken);
        Sharedprefernces_IdToken.edit().putString(App_Prefences_Id_Token, idToken).apply()
        presenter.replaceScreen(Screens.MainScreen())
    }


}
