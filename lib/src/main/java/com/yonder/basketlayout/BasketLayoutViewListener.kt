package com.yonder.basketlayout

/**
 * @author: yusufonder
 * @date: 30/05/2021
 */
interface BasketLayoutViewListener {
  fun onClickDecreaseQuantity(quantity: Int)
  fun onClickIncreaseQuantity(quantity: Int)
  fun onClickTrash()
}