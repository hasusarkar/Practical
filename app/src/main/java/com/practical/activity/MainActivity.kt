package com.practical.activity

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.practical.BaseActivity
import com.practical.R
import com.practical.model.AllData
import com.practical.model.category.Category
import com.practical.model.category.CategoryData
import com.practical.model.channel.Channel
import com.practical.model.channel.ChannelData
import com.practical.model.newepisode.EpisodeData
import com.practical.model.newepisode.Medium
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {
    val allDataObserver = mutableListOf<AllData>()
    var awaitVal = false
    lateinit var episodeList: List<Medium>
    lateinit var channelList: List<Channel>
    lateinit var categoryList: List<Category>
    lateinit var allThreeList: MutableList<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mindtokeViewModel.episodeObserver.observe(this, episodeObserver)
        mindtokeViewModel.channelObserver.observe(this, channelObserver)
        mindtokeViewModel.categoryObserver.observe(this, categoryObserver)

        mindtokeViewModel.isThrowData.observe(this, Observer {
            it.apiName
            it.isLodaer
            it.throwable
            if (it.isLodaer) {
                //progress bar show
            } else if (it.throwable != null) {
                Toast.makeText(this, it.throwable?.message, Toast.LENGTH_LONG).show()
            } else if (!it.isLodaer) {
                //progress bar hide
            }
        })

        callData()
    }

    fun callData() = launch {
        async { mindtokeViewModel.getEpisodeRequest() }.await()
        async { mindtokeViewModel.getChannelRequest() }.await()
        async { mindtokeViewModel.getCategoryRequest() }.await()
    }

    val episodeObserver = Observer<EpisodeData> {
        if (it.data != null) {
            episodeList = it.data.media!!
            allThreeList.add(episodeList)
        }
    }
    val channelObserver = Observer<ChannelData> {
        if (it.data != null) {
            channelList = it.data.channels!!
            allThreeList.add(channelList)
        }
    }
    val categoryObserver = Observer<CategoryData> {
        if (it.data != null) {
            categoryList = it.data.categories!!
            allThreeList.add(categoryList)

            callDispaly(allThreeList)
        }
    }

    private fun callDispaly(allThreeList: MutableList<Any>) {


    }

}