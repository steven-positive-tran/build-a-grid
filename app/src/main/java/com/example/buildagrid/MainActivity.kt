package com.example.buildagrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildagrid.data.DataSource
import com.example.buildagrid.model.Topic
import com.example.buildagrid.ui.theme.BuildAGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildAGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseGrid(courses = DataSource.topics)
                }
            }
        }
    }
}

@Composable
fun TopicItem(modifier: Modifier = Modifier,
topic: Topic){

    Surface(modifier = modifier.height(68.dp).fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)){


        Row(modifier = Modifier.background(Color.LightGray)){
            Image(painter = painterResource(id = topic.topic_image),
            contentDescription = null,
            modifier = Modifier
                .height(68.dp)
                .width(68.dp))

            Column(
                modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(16.dp, 16.dp, 16.dp, 0.dp)){

                Text(
                    text = stringResource(id = topic.topic_name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)

                )

                Row(verticalAlignment = Alignment.CenterVertically)
                {

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_grain_24),
                        contentDescription = null,
                        modifier  = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = topic.topic_courses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }

            }
        }

    }
}


@Composable
fun CourseGrid(courses: List<Topic>)
{
    LazyVerticalGrid(columns = GridCells.Fixed(2)
    ){
        items(courses){

                course-> TopicItem(modifier = Modifier.padding(2.dp), topic = course)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuildAGridTheme {
        //TopicItem(topic = Topic(R.string.architecture, 58, R.drawable.architecture))
        CourseGrid(courses = DataSource.topics)
    }
}