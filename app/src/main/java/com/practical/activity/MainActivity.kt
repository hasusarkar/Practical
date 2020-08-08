package com.practical.activity

import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practical.BaseActivity
import com.practical.R
import com.practical.adapter.AllAdapter
import com.practical.model.AllData
import com.practical.model.category.Category
import com.practical.model.category.CategoryData
import com.practical.model.channel.Channel
import com.practical.model.channel.ChannelData
import com.practical.model.newepisode.EpisodeData
import com.practical.model.newepisode.Medium
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class MainActivity : BaseActivity() {
    val allDataObserver = mutableListOf<AllData>()
    var awaitVal = false
    lateinit var episodeList: List<Medium>
    lateinit var channelList: List<Channel>
    lateinit var categoryList: List<Category>
    lateinit var allThreeList: MutableList<AllData>
    lateinit var allAdapter :AllAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allThreeList= mutableListOf()
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        actMainRecylerList.layoutManager = linearLayoutManager

        val divider = DividerItemDecoration(actMainRecylerList.context, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(baseContext, R.drawable.line_divider)!!)
        actMainRecylerList.addItemDecoration(divider)

        allAdapter = AllAdapter(this, allThreeList)
        actMainRecylerList.adapter = allAdapter

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
            val allData=AllData()
            allData.episodeList=episodeList
            allData.type=1
            allThreeList.add(allData)
        }
    }
    val channelObserver = Observer<ChannelData> {
        if (it.data != null) {
            channelList = it.data.channels!!
            val allData=AllData()
            allData.channelList=channelList
            allData.type=2
            allThreeList.add(allData)
        }
    }
    val categoryObserver = Observer<CategoryData> {
        if (it.data != null) {
            categoryList = it.data.categories!!
            val allData=AllData()
            allData.categoryList=categoryList
            allData.type=3
            allThreeList.add(allData)
            callDispaly(allThreeList)
        }
    }

    private fun callDispaly(allThreeList: MutableList<AllData>) {
        allAdapter.updateData(allThreeList)
    }

}