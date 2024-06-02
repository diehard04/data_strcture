import com.example.datastructre.coroutines.di.api.ApiHelper

/**
 * Created by DieHard_04 on 10-06-2021.
 */

class SingleNetworkCallRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}