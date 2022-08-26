package jiaozhu.com.common

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.dp


data class Message(val author: String, val body: String)

@Composable
fun App() {
    Column(modifier = Modifier.background(Color.LightGray).fillMaxSize()) {
        SearchBar()
        val list = ArrayList<Message>()
        for (i in 1..40)
            list.add(Message("Android", "Jetpack Compose"))
        Conversation(list)
    }
}


@Composable
fun SearchBar() {
    var s = ""
    TextField(
        value = "12312312",
        enabled = true,
        onValueChange = { s = it },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "null"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        //软件键盘选项
        modifier = Modifier.height(30.dp).fillMaxWidth()
    )
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            messageCard(message)
        }
    }
}


@Composable
fun messageCard(msg: Message) {
    Row(
        modifier = Modifier.padding(bottom = 1.dp).padding(horizontal = 1.dp)
            .background(Color.White).fillMaxWidth()
    ) {
        var exp by rememberSaveable { mutableStateOf(false) }
        Row(modifier = Modifier.clickable {
            exp = !exp
        }) {
            Image(
                painter = BitmapPainter(getImage("1.png")!!),
                contentDescription = "Sample",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, Color.Green, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Surface(
                elevation = 1.dp,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Column {
                    Text(text = msg.author)
                    if (exp) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = msg.body)
                    }
                }
            }
        }
    }
}

