package aaa.bbb.ccc.transfer.data.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserInfoToken {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("balance")
    @Expose
    var balance: Int? = null

}