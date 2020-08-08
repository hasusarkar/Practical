package com.practical.activity

import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.gson.Gson
import com.practical.*
import com.practical.adapter.AllAdapter
import com.practical.model.AllData
import com.practical.model.category.Category
import com.practical.model.category.CategoryData
import com.practical.model.channel.Channel
import com.practical.model.channel.ChannelData
import com.practical.model.newepisode.EpisodeData
import com.practical.model.newepisode.Medium
import com.practical.prefUtils.SharedPrefrenceUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class MainActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener {
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

        refreshPull.setOnRefreshListener(this);

        refreshPull.post(Runnable {
            refreshPull.isRefreshing = true
            if(isNetworkAvailable()){
                callData()
            }else{
                callOffline()
                refreshPull.isRefreshing = false
                Toast.makeText(this,R.string.check_internet,Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun callOffline() {
        val episodeobj = UtilityData.getEpisodeData(this)
        val channelobj = UtilityData.getChannelData(this)
        val categoryobj = UtilityData.getCategoryData(this)
        episodeList = episodeobj.data?.media!!
        val allData=AllData()
        allData.episodeList=episodeList
        allData.type=1
        allThreeList.add(allData)
        val allData1=AllData()
        channelList = channelobj.data?.channels!!
        allData1.channelList=channelList
        allData1.type=2
        allThreeList.add(allData1)
        val allData2=AllData()
        categoryList = categoryobj.data?.categories!!
        allData2.categoryList=categoryList
        allData2.type=3
        allThreeList.add(allData2)
        callDispaly(allThreeList)
    }

    fun callData() = launch {
        refreshPull.isRefreshing = true
        async { mindtokeViewModel.getEpisodeRequest() }.await()
        async { mindtokeViewModel.getChannelRequest() }.await()
        async { mindtokeViewModel.getCategoryRequest() }.await()
    }

    val episodeObserver = Observer<EpisodeData> {
        if (it.data != null) {
            val episodeStringData = Gson().toJson(it, AppConstant.typeEpisodeData)
            SharedPrefrenceUtils.putStringPref(this, SharedPrefrenceUtils.PREF_EPISODE_DATA, episodeStringData)
            episodeList = it.data.media!!
            val allData=AllData()
            allData.episodeList=episodeList
            allData.type=1
            allThreeList.add(allData)
        }else{
            refreshPull.isRefreshing = false
        }


    }
    val channelObserver = Observer<ChannelData> {
        if (it.data != null) {
            val channelStringData = Gson().toJson(it, AppConstant.typeChannelData)
            SharedPrefrenceUtils.putStringPref(this, SharedPrefrenceUtils.PREF_CHANNEL_DATA, channelStringData)

            channelList = it.data.channels!!
            val allData=AllData()
            allData.channelList=channelList
            allData.type=2
            allThreeList.add(allData)
        }else{
            refreshPull.isRefreshing = false
        }
    }
    val categoryObserver = Observer<CategoryData> {
        if (it.data != null) {
            val categoryStringData = Gson().toJson(it, AppConstant.typeCategoryData)
            SharedPrefrenceUtils.putStringPref(this, SharedPrefrenceUtils.PREF_CATEGORY_DATA, categoryStringData)

            refreshPull.isRefreshing = false
            categoryList = it.data.categories!!
            val allData=AllData()
            allData.categoryList=categoryList
            allData.type=3
            allThreeList.add(allData)
            callDispaly(allThreeList)
        }else{
            refreshPull.isRefreshing = false
        }
    }

    private fun callDispaly(allThreeList: MutableList<AllData>) {
        allAdapter.updateData(allThreeList)
    }

    override fun onRefresh() {
       if(isNetworkAvailable()){
           callData()
       }else{
           Toast.makeText(this,R.string.check_internet,Toast.LENGTH_LONG).show()
       }
    }

}