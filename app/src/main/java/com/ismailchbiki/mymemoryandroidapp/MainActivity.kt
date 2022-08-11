package com.ismailchbiki.mymemoryandroidapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ismailchbiki.mymemoryandroidapp.models.BoardSize
import com.ismailchbiki.mymemoryandroidapp.utils.DEFAULT_ICONS

//Every activity represents one screen in the app
class MainActivity : AppCompatActivity() {

    //lateinit:
    // The variables will be set after onCreate method is run
    // after being invoked by the android system,
    // (They are not going to be created at the time of construction of the MainActivity)
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView

    private var boardSize: BoardSize = BoardSize.EASY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)

        val chosenImages: List<Int> = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (chosenImages + chosenImages).shuffled()

        //The Adapter is more involved than the LayoutManager
        //because it's responsible for taking in the underlying dataset of the RecylcerView
        //and adapts each piece of data into a view
        rvBoard.adapter =
            MemoryBoardAdapter(this, boardSize, randomizedImages) //total of elements in the grid
        rvBoard.setHasFixedSize(true) //this is optional, (for performance optimisation)
        rvBoard.layoutManager = GridLayoutManager(
            this, //this: represents the context which is the MainActivity
            boardSize.getWidth() //number of columns
        )
    }
}