package com.yonder.basketlayoutsample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yonder.basketlayout.BasketLayoutViewListener
import com.yonder.basketlayoutsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.basketView.apply {
            setBasketQuantity(quantity = 2)
            setMaxQuantity(maxQuantity = 3)

            setBasketLayoutListener(object : BasketLayoutViewListener {
                override fun onExceedMaxQuantity(quantity: Int) {
                    Toast.makeText(
                        this@MainActivity,
                        "Exceed max quantity: $quantity",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                override fun onClickDecreaseQuantity(quantity: Int) {
                    Toast.makeText(
                        this@MainActivity,
                        "Decrease quantity to $quantity",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        setBasketQuantity(quantity)
                    }, 1000)
                }

                override fun onClickIncreaseQuantity(quantity: Int) {
                    Toast.makeText(
                        this@MainActivity,
                        "Increase quantity to $quantity",
                        Toast.LENGTH_SHORT
                    )
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