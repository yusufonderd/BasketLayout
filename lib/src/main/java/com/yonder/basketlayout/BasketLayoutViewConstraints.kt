package com.yonder.basketlayout

import android.content.res.Resources
import android.util.TypedValue
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.BOTTOM
import androidx.constraintlayout.widget.ConstraintSet.TOP
import androidx.constraintlayout.widget.ConstraintSet.START
import androidx.constraintlayout.widget.ConstraintSet.END
import androidx.constraintlayout.widget.ConstraintSet.PARENT_ID

/**
 * @author: yusufonder
 * @date: 30/05/2021
 */


internal fun <T : ConstraintSet> BasketLayoutView.setBtnIncreaseQuantityLocation(constraint: T) {
  constraint.apply {
    with(btnDecreaseQuantity.id) {
      connect(this, START, PARENT_ID, START)
      connect(this, BOTTOM, PARENT_ID, BOTTOM)
      connect(this, TOP, PARENT_ID, TOP)
      connect(this, END, tvQuantity.id, START)
    }
  }
}

internal fun <T : ConstraintSet> BasketLayoutView.setBtnDecreaseQuantityLocation(constraint: T) {
  constraint.apply {
    with(btnIncreaseQuantity.id) {
      connect(this, END, PARENT_ID, END)
      connect(this, BOTTOM, PARENT_ID, BOTTOM)
      connect(this, TOP, PARENT_ID, TOP)
      connect(this, START, tvQuantity.id, END)
    }
  }
}

internal fun <T : ConstraintSet> BasketLayoutView.setTvQuantityLocation(constraint: T) {
  constraint.apply {
    with(tvQuantity.id) {
      connect(this, TOP, PARENT_ID, TOP)
      connect(this, BOTTOM, PARENT_ID, BOTTOM)
      connect(this, START, btnDecreaseQuantity.id, END, padding)
      connect(this, END, btnIncreaseQuantity.id, START, padding)

    }
  }
}


internal fun <T : ConstraintSet> BasketLayoutView.setPbQuantityLocation(constraint: T) {
  constraint.apply {
    with(pbQuantity.id) {
      connect(this, TOP, PARENT_ID, TOP)
      connect(this, BOTTOM, PARENT_ID, BOTTOM)
      connect(this, START, tvQuantity.id, END, padding)
      connect(this, END, tvQuantity.id, START, padding)
    }
  }
}

