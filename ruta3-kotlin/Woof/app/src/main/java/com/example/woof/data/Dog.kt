package com.example.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.woof.R

data class Dog(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val dogs = listOf(
    Dog(R.drawable.koda, R.string.dog_name_1, 2, R.string.dog_hobby_1),
    Dog(R.drawable.lola, R.string.dog_name_2, 3, R.string.dog_hobby_2),
    Dog(R.drawable.frankie, R.string.dog_name_3, 5, R.string.dog_hobby_3),
    Dog(R.drawable.nox, R.string.dog_name_4, 1, R.string.dog_hobby_4),
    Dog(R.drawable.bella, R.string.dog_name_5, 4, R.string.dog_hobby_5)
)