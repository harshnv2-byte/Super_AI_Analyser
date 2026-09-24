package com.superai.analyser

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // 22 BRAINS LOGIC
    private val brains = listOf(
        "ChartOnly Brain", "1:60 Timer Brain", "2-Min Rolling Brain",
        "Support-Resistance Brain", "Candle Pattern Brain", "Volume Brain",
        "Trend Brain", "Breakout Brain", "Rejection Brain", "Momentum Brain",
        "Volatility Brain", "Structure Brain", "Liquidity Brain", "FVG Brain",
        "OrderBlock Brain", "Sweep Brain", "Entry Brain", "SL Brain",
        "Target Brain", "Risk Brain", "Confirmation Brain", "Super AI Final Brain"
    )

    private lateinit var statusText: TextView
    private lateinit var timerText: TextView
    private lateinit var resultText: TextView
    private lateinit var scanBtn: Button
    private lateinit var startBtn: Button
    private var timer: CountDownTimer? = null
    private var isScanning = false

    private val CAPTURE_REQUEST = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(40, 60, 40, 40)
        }

        val title = TextView(this).apply {
            text = "SUPER AI ANALYSER\n22 BRAINS ACTIVE"
            textSize = 22f
            setPadding(0,0,0,30)
        }

        timerText = TextView(this).apply {
            text = "Timer: 01:60 (Waiting)"
            textSize = 18f
            setPadding(0,0,0,20)
        }

        statusText = TextView(this).apply {
            text = "Status: Screen Capture Only Chart Mode\nWaiting for chart..."
            textSize = 14f
            setPadding(0,0,0,20)
        }

        resultText = TextView(this).apply {
            text = "Last Scan: No scan yet\nRolling: 2-Min Analysis ON"
            textSize = 15f
            setPadding(0,0,0,30)
        }

        startBtn = Button(this).apply {
            text = "START SCREEN CAPTURE"
            setOnClickListener { startScreenCapture() }
        }

        scanBtn = Button(this).apply {
            text