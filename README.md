## GIF
<img src="https://github.com/yusufonderd/BasketLayout/blob/master/art/basketlayout-wip.gif" />

## Usage
Use like a card view 
```xml
 <com.yonder.basketlayout.BasketLayoutView
        android:id="@+id/basketView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:cardBackgroundColor="@color/white"
        app:cardCornerRadius="16dp"
        app:cardElevation="0dp"
        app:strokeColor="#dddddd"
        app:strokeWidth="1dp" />
```

#### Attributes:
This view extends from card view. So you can use all card view attributes  

#### Extra Properties:
| Properties | Description |
| --- | --- |
| `setBasketQuantity` | Set initial basket quantity  |
| `setMaxQuantity` | Set maximum limit for quantity  |
| `setBasketLayoutListener` | Set for observe basket layout behaviour  |


#### Code:
```kotlin
    basketLayoutView.setMaxQuantity(3) // Optional | Default is 1
    basketLayoutView.setBasketQuantity(3) // Optional | Default is null
    basketLayoutView.setBasketLayoutListener(this) // For listening layout events
```

# BasketLayout (In development..)
Basket Layout is a library which extending from cardview that makes manage add to cart operation easier for android app.
