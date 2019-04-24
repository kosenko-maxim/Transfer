package aaa.bbb.ccc.transfer.ui.main

import aaa.bbb.ccc.transfer.R
import aaa.bbb.ccc.transfer.data.retrofit.model.RecyclerItemSearch
import aaa.bbb.ccc.transfer.data.retrofit.model.TransToken
import aaa.bbb.ccc.transfer.mvp.moxy.MvpAppCompatActivity
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainPresenter
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainView
import aaa.bbb.ccc.transfer.ui.login.LoginActivity.Companion.App_Prefences_Id_Token
import aaa.bbb.ccc.transfer.ui.login.LoginActivity.Companion.Sharedprefernces_IdToken
import aaa.bbb.ccc.transfer.util.Screens
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.jakewharton.rxbinding2.widget.RxAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import java.util.ArrayList


class MainActivity : MvpAppCompatActivity(), MainView, BottomNavigationBar.OnTabSelectedListener {

    lateinit var navigator: Navigator

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator = SupportAppNavigator(this, R.id.container)
        if (savedInstanceState == null)
            presenter.replaceScreen(Screens.ProfileScreen())
        ab_bottom_navigation_bar
            .addItem(BottomNavigationItem(R.drawable.ic_perm, "Profile"))
            .addItem(BottomNavigationItem(R.drawable.ic_search, "Search"))
            .addItem(BottomNavigationItem(R.drawable.ic_history, "History"))
            .setTabSelectedListener(this)
            .initialise()
    }

    override fun showError(text: String) {
        toast(text)
    }

    override fun onResume() {
        super.onResume()
        presenter.navigatorHolder.setNavigator(navigator)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menu_exit -> {
                Sharedprefernces_IdToken.edit().putString(App_Prefences_Id_Token, "").apply()
                presenter.replaceScreen(Screens.LoginScreen())
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        super.onPause()
        presenter.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        presenter.onBackPressed()
    }

    override fun onTabSelected(position: Int) {
        when (position) {
            0 -> presenter.replaceScreen(Screens.ProfileScreen())
            1 -> presenter.replaceScreen(Screens.SearchScreen())
            2 -> presenter.replaceScreen(Screens.HistoryScreen())
        }
    }

    override fun onTabReselected(position: Int) {
    }

    override fun onTabUnselected(position: Int) {
    }

    override fun showText(id: String, name: String, email: String, balance: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchName(list: ArrayList<RecyclerItemSearch>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showHistory(list: ArrayList<TransToken>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
