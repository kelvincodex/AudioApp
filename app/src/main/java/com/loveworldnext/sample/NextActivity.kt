package com.loveworldnext.sample

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.loveworldnext.sample.adapters.SingleListAdapter
import com.loveworldnext.sample.model.Item
import kotlinx.android.synthetic.main.activity_next.*
import java.io.IOException

class NextActivity : AppCompatActivity(), (Item) -> Unit {


    private var isPlaying = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val itemList:ArrayList<Item> = arrayListOf()
        itemList.add(Item("Hello World", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-16.mp3"))

        val simpleListAdapter = SingleListAdapter(this, itemList, this)
        itemRecylcer.adapter = simpleListAdapter


    }


    override fun invoke(item: Item) {
        val mediaPlayer = MediaPlayer()
        try {
            mediaPlayer.setDataSource(item.url)
            mediaPlayer.prepare()
        }catch (e:IOException){
            Log.d("debugger: ", e.message!!)
        }

        isPlaying = if(isPlaying){
            //stop audio
            mediaPlayer.stop()
            false
        }else{
            //play
            mediaPlayer.start()
            true
        }

    }


}