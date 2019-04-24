package aaa.bbb.ccc.transfer.util

import aaa.bbb.ccc.transfer.ui.login.LoginActivity
import aaa.bbb.ccc.transfer.ui.login.RegisterFragment
import aaa.bbb.ccc.transfer.ui.login.main.ProfileFragment
import aaa.bbb.ccc.transfer.ui.login.main.SearchFragment
import aaa.bbb.ccc.transfer.ui.login.main.HistoryFragment
import aaa.bbb.ccc.transfer.ui.main.MainActivity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class ProfileScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return ProfileFragment()
        }
    }

    class SearchScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SearchFragment()
        }
    }

    class HistoryScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return HistoryFragment()
        }
    }

    class MainScreen:SupportAppScreen(){
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context,MainActivity::class.java)
        }
    }

    class LoginScreen:SupportAppScreen(){
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
    class RegisterScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return RegisterFragment()
        }
    }

}