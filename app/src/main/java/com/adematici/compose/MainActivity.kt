package com.adematici.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adematici.compose.model.SampleData
import com.adematici.compose.ui.theme.JetpackComposeLessonsTheme
import com.adematici.compose.view.grid.SampleGrid
import com.adematici.compose.view.grid.SampleGridDetail
import com.google.gson.Gson

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLessonsTheme {
                SetupGridNavigation()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun SetupGridNavigation() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "sample_data") {
        composable("sample_data") {
            SampleGrid(navHostController)
        }
        composable("sample_grid_detail/{item}", arguments = listOf(
            navArgument("item") {
                type = NavType.StringType
            }
        )) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, SampleData::class.java)
                SampleGridDetail(data = item)
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeLessonsTheme {
        SetupGridNavigation()
    }
}