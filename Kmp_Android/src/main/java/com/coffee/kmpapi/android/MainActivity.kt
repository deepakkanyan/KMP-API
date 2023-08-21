package com.coffee.kmpapi.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coffee.kmpapi.android.capsules.CapsulesUI
import com.coffee.kmpapi.android.missions.MissionsUI
import com.coffee.kmpapi.android.rockets.RocketsUI
import com.coffee.kmpapi.android.utils.ui.BottomItems

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme() {
                MainNavigation()

            }
        }
    }

    @Composable
    fun MainNavigation() {

        //1 Define navController
        val navController = rememberNavController()

        //2 Using bottomBar in Scaffold
        Scaffold(
            bottomBar = {
                BottomNav(navController) {
                    navController.navigate(it.route)
                }
            })
        {
            NavHost(
                navController = navController,
                startDestination = BottomItems.RocketUI.route,
                modifier = Modifier.padding(it)
            ) {
                composable(BottomItems.RocketUI.route) { RocketsUI() }
                composable(BottomItems.MissionUI.route) { MissionsUI() }
                composable(BottomItems.CapsuleUI.route) { CapsulesUI() }
            }
        }
    }


    @Composable
    fun BottomNav(navController: NavHostController, onClick: (route: BottomItems) -> Unit) {

        // List of Bottom Navigation Menu
        val listOfMenu = listOf(BottomItems.RocketUI, BottomItems.MissionUI, BottomItems.CapsuleUI)

        // Get Current Fragment/Route Entry. So we can highlight bottomBar selected item.
        val currentRoute = navController.currentDestination?.route


        BottomAppBar {

            // Run Loop to define
            listOfMenu.forEach { item ->

                BottomNavigationItem(
                    selected = currentRoute == item.route,
                    onClick = { onClick(item) },
                    label = { Text(text = stringResource(id = item.resLabelId)) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.resIconId),
                            contentDescription = stringResource(id = item.resLabelId)
                        )
                    })
            }

        }

    }


}

