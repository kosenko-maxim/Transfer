package aaa.bbb.ccc.transfer.data.retrofit.model

//import com.github.vivchar.rendererrecyclerviewadapter.ViewModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Results  {
    var id_token: String? = null


    @SerializedName("user_info_token")
    @Expose
    var userInfoToken: UserInfoToken? = null

    @SerializedName("trans_token")
    @Expose
    var transToken: ArrayList<TransToken>? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}

