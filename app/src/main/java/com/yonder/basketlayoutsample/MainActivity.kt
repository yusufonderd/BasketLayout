package com.yonder.basketlayoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.yonder.basketlayout.BasketLayoutView
import com.yonder.basketlayout.BasketLayoutViewListener

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    findViewById<BasketLayoutView>(R.id.basketView).apply {
      setBasketLayoutListener(object : BasketLayoutViewListener {
        override fun onClickDecreaseQuantity(quantity: Int) {
          Toast.makeText(this@MainActivity, "Decrease quantity to $quantity", Toast.LENGTH_SHORT)
            .show()
          Handler(Looper.getMainLooper()).postDelayed({
            setBasketQuantity(quantity)
          }, 1000)
        }

        override fun onClickIncreaseQuantity(quantity: Int) {
          Toast.makeText(this@MainActivity, "Increase quantity to $quantity", Toast.LENGTH_SHORT)
            .show()
          Handler(Looper.getMainLooper()).postDelayed({
            setBasketQuantity(quantity)
          }, 1000)
        }

        override fun onClickTrash() {
          Toast.makeText(this@MainActivity, "on Click Trash Button", Toast.LENGTH_SHORT)
            .show()
        }
      })


    }
  }
}