package com.example.contact_with_custom_alert.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contact_with_custom_alert.ui.model.Contact
import com.example.contact_with_custom_alert.ui.model.listOfContact

@Composable
fun ContactScreen() {

    var allContact = listOfContact()
    var context = LocalContext.current
    var stateDialog = remember { mutableStateOf(false) }
    var selectedContactState by remember { mutableStateOf<Contact?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            allContact.forEach { contact ->
                SingleCard(stateDialog, contact) {
                    selectedContactState = contact
                    Toast.makeText(context, "done", Toast.LENGTH_SHORT).show()
                }
            }
        }
        if (stateDialog.value) {
            AsDialog() {
                DialogData(stateDialog!!, selectedContactState!!)

            }
            Toast.makeText(context, "true", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun AsDialog(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xAA000000)),
    ) {
        Card(
            modifier = Modifier
                .align(Alignment.Center)
                .size(250.dp)

        ) {
            Column {

                content()
            }
        }
    }
}

@Composable
fun DialogData(state: MutableState<Boolean>, contact: Contact) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Box(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(contact.img), contentDescription = "discription",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .size(70.dp)
                    .clip(shape = CircleShape)
                    .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                    .align(Alignment.TopCenter)
            )
            Column(Modifier.align(Alignment.Center)) {
                Text(text = contact.name)
                Text(text = contact.phone)
                Text(text = contact.address)
            }

            Button(
                onClick = { state.value = false },
                Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) { Text("Cancel") }
        }
    }
}

@Composable
fun SingleCard(state: MutableState<Boolean>, contact: Contact, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.White)
            .clickable {
                state.value = true
                onClick()
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = contact.name,
                Modifier
                    .padding(20.dp)
                    .align(Alignment.TopStart),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = contact.phone,
                Modifier
                    .padding(20.dp)
                    .align(Alignment.TopCenter)
            )
            Text(
                text = contact.address,
                Modifier
                    .padding(10.dp)
                    .align(Alignment.Center)
            )
            Image(
                painter = painterResource(id = contact.img),
                contentDescription = "discription",
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.CenterEnd)
                    .border(
                        width = 2.dp, color = Color.Black,
                        CircleShape
                    )
                    .background(Color.White, shape = CircleShape)
                    .clip(CircleShape),
            )

        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    ContactScreen()
}