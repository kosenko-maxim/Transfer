package aaa.bbb.ccc.transfer.data.retrofit.model

//import com.github.vivchar.rendererrecyclerviewadapter.ViewModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TransToken  {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("amount")
    @Expose
    var amount: Int? = null
    @SerializedName("balance")
    @Expose
    var balance: Int? = null
}
