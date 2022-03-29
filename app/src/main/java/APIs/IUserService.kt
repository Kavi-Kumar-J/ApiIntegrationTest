package APIs

import android.service.autofill.UserData
import com.example.apiintegrationtest.ResponseModel
import com.example.apiintegrationtest.retrorequests.SigninRequest
import com.example.apiintegrationtest.retrorequests.SignupRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface IUserService {


    @POST("signin")
    fun signin(@Body body: SigninRequest): Call<ResponseModel<UserData>>

    @POST("signup")
    fun signup(@Body body: SignupRequest): Call<ResponseModel<UserData>>

}