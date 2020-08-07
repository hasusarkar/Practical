package com.practical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practical.http.ApiClient
import com.practical.http.ApiService
import com.practical.repository.MindTokeRepository
import com.practical.viewmodel.MindTokeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseActivity : AppCompatActivity()  , CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + mJob

    val mJob = Job()

    lateinit var apiService: ApiService
    lateinit var mindtokeRepository: MindTokeRepository
    lateinit var mindtokeViewModel: MindTokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        apiService = ApiClient.createService(this)
        mindtokeRepository = MindTokeRepository(apiService)
        mindtokeViewModel = MindTokeViewModel(mindtokeRepository)
    }
}