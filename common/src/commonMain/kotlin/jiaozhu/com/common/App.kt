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
import androidx.compose.material.TextField
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.*
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem


data class Message(val author: String, val body: String)

val list = ArrayList<Message>()

@Composable
fun App() {
    for (i in 1..40)
        list.add(Message("Android", "Jetpack Compose"))
    Scaffold(
        bottomBar = { SootheBottomNavigation() }
    ) {
        Column(modifier = Modifier.background(Color.LightGray).fillMaxSize()) {
            SearchBar()
            Column(modifier = Modifier.padding(2.dp)) {
                Conversation(list)
            }
        }
    }


}


@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        enabled = true,
        onValueChange = { text = it },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "null"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            textColor = MaterialTheme.colors.primary
        ),
        placeholder = { Text("搜索") },
        singleLine = true,
        modifier = Modifier.heightIn(min = 30.dp).padding(3.dp).fillMaxWidth()
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
        Row(modifier = Modifier.fillMaxWidth().clickable {
            exp = !exp
        }) {
            Image(
                painter = BitmapPainter(getImage("1.png")),
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


@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(modifier) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("home")
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text("settings")
            },
            selected = false,
            onClick = {}
        )
    }
}
