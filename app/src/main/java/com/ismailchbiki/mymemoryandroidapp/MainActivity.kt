package com.ismailchbiki.mymemoryandroidapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

//Every activity represents one screen in the app
class MainActivity : AppCompatActivity() {

    //lateinit:
    // The variables will be set after onCreate method is run
    // after being invoked by the android system,
    // (They are not going to be created at the time of construction of the MainActivity)
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)
    }
}