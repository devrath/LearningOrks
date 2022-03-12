package com.demo.code.instagram.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.code.instagram.R
import com.demo.code.instagram.utils.common.Resource
import com.demo.code.instagram.utils.network.NetworkHelper
import com.demo.code.instagram.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.net.ssl.HttpsURLConnection

/**
 * The view model class has all the parameters that are needed by a view model to work
 * PROTECTED: It is used because only the inheriting classes mist access it
 * ******
 * The BaseViewModel is made abstract because, No one should create the instance of view model
 */
abstract class BaseViewModel(
    protected val schedulerProvider: SchedulerProvider,
    // We need this for the purpose of using the rx java and to add the composable one by one as needed
    protected val compositeDisposable: CompositeDisposable,
    // Network helper is used to check the connectivity
    protected val networkHelper: NetworkHelper
) : ViewModel() {

    // This live data helps to pass certain strings mentioned in the strings resource, Ex: R.strings.hello
    val messageStringId: MutableLiveData<Resource<Int>> = MutableLiveData()
    // This is used to pass some message that is getting directly from the server
    val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    // This method is called whenever the view model is destroyed by android framework
    override fun onCleared() {
        // here we need to dispose all the composable
        compositeDisposable.dispose()
        super.onCleared()
    }

    /**
     * We need to have a method that is used to keep state of the network connectivity in the view model
     */
    protected fun checkInternetConnectionWithMessage(): Boolean =
        if (networkHelper.isNetworkConnected()) {
            true
        } else {
            messageStringId.postValue(Resource.error(R.string.network_connection_error))
            false
        }

    protected fun checkInternetConnection(): Boolean = networkHelper.isNetworkConnected()

    /**
     * This method is used to handle the error that the throwable sends
     */
    protected fun handleNetworkError(err: Throwable?) =
        err?.let {
            networkHelper.castToNetworkError(it).run {
                when (status) {
                    -1 -> messageStringId.postValue(Resource.error(R.string.network_default_error))
                    0 -> messageStringId.postValue(Resource.error(R.string.server_connection_error))
                    HttpsURLConnection.HTTP_UNAUTHORIZED -> {
                        forcedLogoutUser()
                        messageStringId.postValue(Resource.error(R.string.server_connection_error))
                    }
                    HttpsURLConnection.HTTP_INTERNAL_ERROR ->
                        messageStringId.postValue(Resource.error(R.string.network_internal_error))
                    HttpsURLConnection.HTTP_UNAVAILABLE ->
                        messageStringId.postValue(Resource.error(R.string.network_server_not_available))
                    else -> messageString.postValue(Resource.error(message))
                }
            }
        }

    protected open fun forcedLogoutUser() {
        // do something
    }

    // UI can tell the view-model that it is created and it can do somethings like fetching the data
    abstract fun onCreate()
}