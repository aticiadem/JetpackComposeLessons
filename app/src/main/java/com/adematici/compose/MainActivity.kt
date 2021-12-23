package com.adematici.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adematici.compose.ui.theme.JetpackComposeLessonsTheme
import com.adematici.compose.view.expandable.ExpandableScreen
import com.adematici.compose.view.expandable.viewmodel.ExpandableViewModel

@ExperimentalFoundationApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ExpandableViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLessonsTheme {
                ExpandableScreen(viewModel = viewModel)
            }
        }
    }
}

/*
@ExperimentalFoundationApi
@Composable
fun SetupGridNavigationGrid() {
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
*/

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeLessonsTheme {
    }
}