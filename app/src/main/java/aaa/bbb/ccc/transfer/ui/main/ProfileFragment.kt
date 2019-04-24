package aaa.bbb.ccc.transfer.ui.login.main

import aaa.bbb.ccc.transfer.R
import aaa.bbb.ccc.transfer.data.retrofit.model.RecyclerItemSearch
import aaa.bbb.ccc.transfer.data.retrofit.model.TransToken
import aaa.bbb.ccc.transfer.mvp.moxy.MvpAppCompatFragment
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainPresenter
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainView
import aaa.bbb.ccc.transfer.ui.login.LoginActivity.Companion.App_Prefences_Id_Token
import aaa.bbb.ccc.transfer.ui.login.LoginActivity.Companion.Sharedprefernces_IdToken
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_profile.*
import org.jetbrains.anko.support.v4.toast
import java.util.ArrayList

class ProfileFragment : MvpAppCompatFragment(), MainView {
    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var presenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        var idToken = Sharedprefernces_IdToken.getString(App_Prefences_Id_Token, "")
        presenter.loggedUserInfo(idToken)
        return view
    }

    override fun showText(id: String, name: String, email: String, balance: String) {
        RxTextView.text(tvId).accept(id)
        RxTextView.text(tvUserName).accept(name)
        RxTextView.text(tvEmail).accept(email)
        RxTextView.text(tvBalance).accept(balance)
    }

    override fun showError(text: String) {
       toast(text)
    }
    override fun searchName(list: ArrayList<RecyclerItemSearch>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showHistory(list: ArrayList<TransToken>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}