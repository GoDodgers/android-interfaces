package com.example.androidinterfaces

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
                BuildScaffold()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildScaffold() {

    var showMoreBtn by remember {
        mutableStateOf(false)
    }

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
                            Text("Text message")
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
//                                horizontalArrangement = Arrangement.SpaceAround,
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
            "baz"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ) {

            msgs.reversed().forEachIndexed { i, msg ->
                BubbleLayout (
                    modifier = Modifier.padding(horizontal = 8.dp),
                    backgroundColor = if (i % 2 == 0) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.surfaceDim,
                    bubbleState = BubbleState(
                        cornerRadius = BubbleCornerRadius(topLeft = 16.dp, topRight = 16.dp, bottomLeft = 16.dp, bottomRight = 16.dp),
                        alignment = if (i % 2 == 0) ArrowAlignment.BottomRight else ArrowAlignment.BottomRight,
                        arrowShape = ArrowShape.Curved,
                        drawArrow = true,
                    ),
                ) {
                    Box (
                        Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                    ) {
                        Column {
                            Text(
                                text = msg,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                onTextLayout = {
                                    showMoreBtn = it.hasVisualOverflow
                                    println("msg")
                                    println(msg)
                                    println("showMoreBtn")
                                    println(showMoreBtn)
                                }
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            if (showMoreBtn) {
                                Button({}) {
                                    Text("mas")
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ScaffoldPreview() {

    var showMoreBtn by remember {
        mutableStateOf(false)
    }

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
                            Text("Text message")
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
//                                horizontalArrangement = Arrangement.SpaceAround,
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
            "baz"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ) {

            msgs.reversed().forEachIndexed { i, msg ->
                BubbleLayout (
                    modifier = Modifier.padding(horizontal = 8.dp),
                    backgroundColor = if (i % 2 == 0) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.surfaceDim,
                    bubbleState = BubbleState(
                        cornerRadius = BubbleCornerRadius(topLeft = 16.dp, topRight = 16.dp, bottomLeft = 16.dp, bottomRight = 16.dp),
                        alignment = if (i % 2 == 0) ArrowAlignment.BottomRight else ArrowAlignment.BottomRight,
                        arrowShape = ArrowShape.Curved,
                        drawArrow = true,
                    ),
                ) {
                    Box (
                        Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                    ) {
                        Column {
                            Text(
                                text = msg,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                onTextLayout = {
                                    showMoreBtn = it.hasVisualOverflow
                                }
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            if (showMoreBtn) {
                                TextButton({}) {
                                    Text("mas...")
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
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
