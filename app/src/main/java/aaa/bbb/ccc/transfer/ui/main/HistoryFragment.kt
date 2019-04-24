package aaa.bbb.ccc.transfer.ui.login.main

import aaa.bbb.ccc.transfer.util.HistoryAdapter
import aaa.bbb.ccc.transfer.R
import aaa.bbb.ccc.transfer.util.Screens
import aaa.bbb.ccc.transfer.data.retrofit.model.RecyclerItemSearch
import aaa.bbb.ccc.transfer.data.retrofit.model.TransToken
import aaa.bbb.ccc.transfer.mvp.moxy.MvpAppCompatFragment
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainPresenter
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainView
import aaa.bbb.ccc.transfer.ui.login.LoginActivity.Companion.App_Prefences_Id_Token
import aaa.bbb.ccc.transfer.ui.login.LoginActivity.Companion.Sharedprefernces_IdToken
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_history.*
import org.jetbrains.anko.support.v4.toast
import java.util.ArrayList

class HistoryFragment : MvpAppCompatFragment(), MainView {
    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var presenter: MainPresenter


    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        var idToken = Sharedprefernces_IdToken.getString(App_Prefences_Id_Token, "")
        presenter.listOfLoggedUserTransactions(idToken)
        return view
    }

    override fun showHistory(list: ArrayList<TransToken>) {
        recyclerView.adapter = context?.let { HistoryAdapter(it, list) }
    }

    override fun showError(text: String) {
        toast(text)
    }

    override fun showText(id: String, name: String, email: String, balance: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun searchName(list: ArrayList<RecyclerItemSearch>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}