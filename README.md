# BasketLayout
Basket Layout is a library which extending from cardview that makes manage add to cart operation easier for android app.

## GIF

![ezgif-3-84da886c6c](https://user-images.githubusercontent.com/13941871/148004184-2a6c9fee-1230-4ac9-84eb-f04f6ddb2e17.gif)

## Usage
 This view extended from card view. So you can use all card view attributes. Use and customize like a card view.

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

#### Extra Properties:
| Properties | Description |
| --- | --- |
| `setBasketQuantity` | Set initial basket quantity  |
| `setMaxQuantity` | Set maximum limit for quantity  |
| `setBasketLayoutListener` | Set for observe basket layout behaviour  |
| `onClickIncreaseQuantity` | Trigger when user click increase button  |
| `onClickDecreaseQuantity` | Trigger when user click decrease button  |
| `onClickTrash` | Trigger when user click trash button  |
| `onExceedMaxQuantity` | Trigger when user click increase button and quantity greater than max quantity |


#### Code:
```kotlin
    basketLayoutView.setBasketQuantity(3) // Optional | Default is 1 
    basketLayoutView.setMaxQuantity(3) // Optional | Default is null
    basketLayoutView.setBasketLayoutListener(this) // For listening layout events
```


## Installation

(app) build.gradle:
```gradle
implementation 'com.github.yusufonderd:BasketLayout:1.0'
```
#### AND

(root) build.gradle:
```gradle
allprojects {
    repositories {
        ..
        maven { url "https://jitpack.io" }
    }
}
```
or settings.gradle:
```gradle
dependencyResolutionManagement {
    ..
    repositories {
        ..
        maven { url 'https://jitpack.io' }
    }
}
```
