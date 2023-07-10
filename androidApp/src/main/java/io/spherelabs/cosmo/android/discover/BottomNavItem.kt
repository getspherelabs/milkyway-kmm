package io.spherelabs.cosmo.android.discover

import io.spherelabs.milkyway.android.R

val bottomNavItems = listOf<BottomNavItem>(
    BottomNavItem.Search,
    BottomNavItem.Discover,
    BottomNavItem.Favourite,
    BottomNavItem.Setting
)

sealed class BottomNavItem(
    val title: Int,
    val icon: Int,
    val route: String
) {
    object Search : BottomNavItem(title = R.string.search, icon = R.drawable.ic_search,"search")
    object Discover : BottomNavItem(title = R.string.discover, icon = R.drawable.ic_discover,"discover")
    object Favourite : BottomNavItem(title = R.string.favourite, icon = R.drawable.ic_favourite,"favourite")
    object Setting : BottomNavItem(title = R.string.setting, icon = R.drawable.ic_profile,"setting")
}