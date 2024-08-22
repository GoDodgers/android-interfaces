package com.example.androidinterfaces

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.VectorPath
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidinterfaces.ui.theme.AndroidInterfacesTheme
import com.smarttoolfactory.bubble.ArrowAlignment
import com.smarttoolfactory.bubble.ArrowShape
import com.smarttoolfactory.bubble.BubbleCornerRadius
import com.smarttoolfactory.bubble.BubbleShadow
import com.smarttoolfactory.bubble.BubbleState
import com.smarttoolfactory.bubble.bubble

// class higherarchy


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface {
//                ChatView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun ChatViewPreview() {

    var textFieldTxt by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton({}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "content description"
                        )
                    }
                },
                title = {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            modifier = Modifier
                                .size(48.dp)
                                .fillMaxWidth()
                                .padding(end = 8.dp),
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "content description",
                        )
                        Text("Foobar")
                    }
                },
                actions = {
                    IconButton({}) {
                        Icon(
                            imageVector = Icons.Filled.Call,
                            contentDescription = "content description",
                        )
                    }
                    IconButton({}) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "content description",
                        )
                    }
                    IconButton({}) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "content description",
                        )
                    }
                },
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton({}) {
                        Icon(
                            Icons.Filled.AddCircle,
                            contentDescription = "content description"
                        )
                    }
                    IconButton({}) {
                        Icon(
                            Icons.AutoMirrored.Filled.List,
                            contentDescription = "content description",
                        )
                    }
                    TextField(
                        value = textFieldTxt,
//                        label = {
//                            Text("Text message")
//                        },
                        placeholder = {
                            Text(stringResource(id = R.string.msg_prompt))
                        },
                        onValueChange = {
                            textFieldTxt = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        trailingIcon = {
                            Row (
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(end = 16.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                            ) {
                                Icon(
                                    modifier = Modifier.padding(start = 8.dp),
                                    imageVector = Icons.Filled.Face,
                                    contentDescription = "content description"
                                )
                                Icon(
                                    modifier = Modifier.padding(start = 8.dp),
                                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                    contentDescription = "content description"
                                )
                            }
                        },
                        shape = RoundedCornerShape(25.dp)
                    )
                }
            )

        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = { presses++ }
//            ) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        }
    ) { innerPadding ->
        var msgs: List<String> = listOf(
            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos, sed aperiam? Quibusdam et cupiditate quas. Unde id veniam fugit magnam! Et corrupti quaerat aperiam consequuntur. Quos, sed aperiam? Quibusdam et cupiditate quas. Unde id veniam fugit magnam! Unde id veniam fugit magnam! Et corrupti quaerat aperiam consequuntur.",
            "foobar",
            "Unde id veniam fugit magnam! Et corrupti quaerat aperiam consequuntur. Quibusdam et cupiditate quas. Unde id veniam fugit magnam! Et corrupti quaerat aperiam consequuntur.",
            "baz",
            "boo",
            "Veritatis maiores eaque nostrum, quibusdam consequatur atque temporibus quia sit tempora ex quos, dolorem neque consequuntur pariatur nesciunt qui tenetur illum non ullam itaque officiis, provident quaerat sint mollitia. Eos magnam vel, ipsum inventore similique eveniet fuga sit quasi pariatur consequuntur doloribus sunt dolore! Nobis, vel cum neque aperiam illum nam ut est, odio cupiditate veritatis commodi quibusdam ipsa id et voluptatibus, modi sint sit sapiente excepturi repudiandae recusandae alias eaque eligendi."
        )



        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            reverseLayout = true
        ) {

            items(msgs) {message ->
                var sender = if ((0..10).random() <= 5) "dodger" else "kiki"
                
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = if (sender == "dodger") Arrangement.End else Arrangement.Start
                ) {
                    Message(message, sender)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Message(msg: String, author: String) {

    var showMoreBtn: Boolean by remember {
        mutableStateOf(false)
    }

    var showMore: Boolean by remember {
        mutableStateOf(false)
    }

    Box {
        BubbleLayout(
            modifier = Modifier.padding(horizontal = 8.dp),
            backgroundColor = if (author == "dodger") MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.surfaceDim,
            bubbleState = BubbleState(
                cornerRadius = BubbleCornerRadius(
                    topLeft = 16.dp,
                    topRight = 16.dp,
                    bottomLeft = 16.dp,
                    bottomRight = 16.dp
                ),
                alignment = ArrowAlignment.BottomRight,
                arrowShape = ArrowShape.Curved,
                drawArrow = true,
            ),
        ) {
            Box(
                Modifier.padding(12.dp),
            ) {
                Column () {
                    val clipboardManager = LocalClipboardManager.current

                    Text(
                        text = msg,
                        modifier = Modifier
                            .combinedClickable(
                                onLongClick = {
                                    clipboardManager.setText(AnnotatedString(msg))
                                },
                                onClick ={

                                }
                            ),
                        maxLines = if (showMore) Int.MAX_VALUE else 2,
                        overflow = if (showMore) TextOverflow.Visible else TextOverflow.Ellipsis,
                        onTextLayout = {
                            showMoreBtn = it.hasVisualOverflow
                        }
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    if (showMoreBtn) {
                        TextButton(
                            onClick = { showMore = true },
                            contentPadding = PaddingValues(1.dp),
                            modifier = Modifier
                                .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                        ) {
                            Text("mas...")
                        }
                    }

                    if (showMore) {
                        TextButton(
                            onClick = { showMore = false },
                            contentPadding = PaddingValues(1.dp),
                            modifier = Modifier
                                .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                        ) {
                            Text("menos...")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BubbleLayout(
    modifier: Modifier = Modifier,
    bubbleState: BubbleState,
    backgroundColor: Color = Color.White,
    shadow: BubbleShadow? = null,
    borderStroke: BorderStroke? = null,
    content: @Composable () -> Unit
) {
    Column(
        modifier.bubble(
            bubbleState = bubbleState,
            color = backgroundColor,
            shadow = shadow,
            borderStroke = borderStroke
        )
    ) {
        content()
    }
}



