package com.coffee.kmpapi.android.utils.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.coffee.kmpapi.android.R

// This is bottom menu [routeName,title, icon]
sealed class BottomItems(
    val route: String,
    @StringRes val resLabelId: Int,
    @DrawableRes val resIconId: Int
) {
    object RocketUI : BottomItems("RocketUI", R.string.rockets, R.drawable.ic_rocket)
    object MissionUI : BottomItems("MissionUI", R.string.missions, R.drawable.ic_mission)
    object CapsuleUI : BottomItems("CapsuleUI", R.string.capsules, R.drawable.ic_capsule)

}