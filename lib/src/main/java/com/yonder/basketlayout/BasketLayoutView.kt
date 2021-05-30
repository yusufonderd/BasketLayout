package com.yonder.basketlayout

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.google.android.material.card.MaterialCardView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.RelativeCornerSize
import com.google.android.material.shape.RoundedCornerTreatment
import com.google.android.material.shape.ShapeAppearanceModel

/**
 * @author: yusufonder
 * @date: 30/05/2021
 */

enum class State {
  Loading,
  None
}

class BasketLayoutView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

  private var state: State = State.None
  var listener: BasketLayoutViewListener? = null

  fun setBasketLayoutListener(listener: BasketLayoutViewListener) {
    this.listener = listener
  }

  var incrementValue = 1
  var quantity: Int = 1
  val padding = 16.toPx.toInt()
  var isAddedViews: Boolean = false


  private val clContainer: ConstraintLayout by lazy {
    ConstraintLayout(context).apply {
      id = generateViewId()
    }
  }

  internal val btnDecreaseQuantity: AppCompatImageButton by lazy {
    AppCompatImageButton(context).apply {
      id = generateViewId()
      background = null
      setOnClickListener {
        if (state == State.None) {
          if (quantity > incrementValue) {
            listener?.onClickDecreaseQuantity(quantity - incrementValue)
            setLoading()
          } else if (quantity == incrementValue) {
            listener?.onClickTrash()
          }
        }
      }
      setColorFilter(ContextCompat.getColor(context, R.color.green))
      setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_remove_24))
    }
  }

  internal val btnIncreaseQuantity: AppCompatImageButton by lazy {
    AppCompatImageButton(context).apply {
      id = generateViewId()
      background = null
      setOnClickListener {
        if (state == State.None) {
          listener?.onClickIncreaseQuantity(quantity + incrementValue)
          setLoading()
        }
      }
      setColorFilter(ContextCompat.getColor(context, R.color.green))
      setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_add_24))
    }
  }

  internal val tvQuantity: AppCompatTextView by lazy {
    AppCompatTextView(context).apply {
      id = generateViewId()
      text = "$quantity"
      gravity = Gravity.CENTER
      width = 36.toPx.toInt()
      height = 36.toPx.toInt()
      val shape = ShapeAppearanceModel.Builder()
        .setAllCorners(RoundedCornerTreatment()).setAllCornerSizes(RelativeCornerSize(0.5f))
        .build()
      val backgroundDrawable = MaterialShapeDrawable(shape).apply {
        fillColor = ContextCompat.getColorStateList(context, R.color.green_transparent);
      }
      ViewCompat.setBackground(this, backgroundDrawable)
    }
  }

  internal val pbQuantity: CircularProgressIndicator by lazy {
    CircularProgressIndicator(context).apply {
      id = generateViewId()
      isInvisible = true
      setIndicatorColor(ContextCompat.getColor(context, R.color.green))
    }
  }

  init {
    initializeSubViews()
  }

  private fun initializeSubViews() {
    addViews(isAddedViews)
    connectViews()
    isAddedViews = true
    setDecreaseButtonImageResource(quantity)
  }


  private fun addViews(isAddedViews: Boolean) {
    if (!isAddedViews) {
      addView(clContainer)
      with(clContainer) {
        addView(btnDecreaseQuantity)
        addView(btnIncreaseQuantity)
        addView(tvQuantity)
        addView(pbQuantity)
      }
    }
  }

  private fun connectViews() {
    if (!isAddedViews) {
      ConstraintSet().apply {
        clone(clContainer)
        setBtnIncreaseQuantityLocation(this)
        setBtnDecreaseQuantityLocation(this)
        setTvQuantityLocation(this)
        setPbQuantityLocation(this)
        applyTo(clContainer)
      }
    }
  }


  private fun setLoading() {
    tvQuantity.isInvisible = true
    btnIncreaseQuantity.isEnabled = false
    btnDecreaseQuantity.isEnabled = false
    pbQuantity.isIndeterminate = true
    pbQuantity.isVisible = true
    state = State.Loading
  }

  fun setBasketQuantity(quantity: Int, state: State = State.None) {
    this.quantity = quantity
    this.state = state
    btnIncreaseQuantity.isEnabled = true
    btnDecreaseQuantity.isEnabled = true
    tvQuantity.isVisible = true
    pbQuantity.isInvisible = true
    setTvQuantity(quantity)
    setDecreaseButtonImageResource(quantity)
  }

  private fun setDecreaseButtonImageResource(quantity: Int) {
    if (quantity > incrementValue) {
      btnDecreaseQuantity.setImageDrawable(
        ContextCompat.getDrawable(
          context,
          R.drawable.ic_baseline_remove_24
        )
      )
    } else {
      btnDecreaseQuantity.setImageDrawable(
        ContextCompat.getDrawable(
          context,
          R.drawable.ic_baseline_delete_outline_24
        )
      )
    }
  }

  private fun setTvQuantity(quantity: Int) {
    tvQuantity.text = "$quantity"
  }

}