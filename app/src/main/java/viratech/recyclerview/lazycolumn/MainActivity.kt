package viratech.recyclerview.lazycolumn

import SampleData
import android.content.res.Configuration
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import viratech.recyclerview.lazycolumn.ui.theme.LazyColumnTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                  // Greeting(Message("ayah tamvan","mamah cantik yang punya"))
                    Conversation(SampleData.conversationSample)



                }
            }
        }
    }
}


data class Message(val author:String, val body:String)

@Composable
fun Greeting(name: Message) {
    Column {
        //  Text(text = "Hello $name!")

        Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp){
            Text(text = name.author, color = MaterialTheme.colors.secondaryVariant,style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(4.dp))

        }

        Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp){
            Text(text = name.body, modifier = Modifier.padding(all = 4.dp), style = MaterialTheme.typography.body2)
        }


    }

}

@Preview(showBackground = true, name = "jh")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "dark mode"
)



@Composable
fun DefaultPreview() {
    LazyColumnTheme {
        Greeting(
            name = Message("colleague","hey are")
        )
    }

}
   @Composable
fun Conversation(messages: List<Message>){
    LazyColumn {
        items(messages){
            message -> Greeting(message)
        }
    }
}
@Preview
@Composable
fun PreviewConversation(){
    LazyColumnTheme {
        Conversation( SampleData.conversationSample)
    }
}







































































