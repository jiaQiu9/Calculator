package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("")
                            }
                        )
                    }
                    ) { innerPadding ->
                    Column(modifier = Modifier
                        .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),){
                        Calculator()
                    }

                }
            }
        }
    }
}




@Composable
fun Calculator(){
    var text by remember {mutableStateOf("")}
    var num_one = 0
    var num_two= 0
    var operation = ""
    var display_text =""

    fun Check(numOne:Int, numTwo:Int, operant: String) : Int{
        if (operant == "+"){
            return numOne+numTwo
        }
        else if (operant == "-"){
            return numOne - numTwo
        }
        else if (operant == "*"){
            return numOne-numTwo
        }
        else if (operant == "\\"){
            return numOne/numTwo
        }
        return 0
    }


    Column(modifier= Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Row(verticalAlignment = Alignment.CenterVertically){
            TextField(
                value =text,
                onValueChange = {text = it},
                label = { Text("Label") },
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically){

                Button(
                    onClick={
                        text = text+"1"
                        display_text= text
                    }
                ){
                    Text("1")
                }
                Button(
                    onClick={
                        text=text+"2"
                        display_text= text
                    }
                ){
                    Text("2")
                }
                Button(
                    onClick={
                        text = text+"3"
                        display_text= text
                    }
                ){
                    Text("3")
                }
                Button(
                    onClick={
                        num_one = text.toInt()
                        num_two = Check(num_two, num_one, operation)
                        operation ="+"
                        text=""
                    }
                ){
                    Text("+")
                }
                Button(
                    onClick={
                        num_one = text.toInt()
                        num_two = Check(num_two, num_one, operation)
                        operation ="*"
                        text=""

                    }
                ){
                    Text("*")
                }


        }
        Row(verticalAlignment = Alignment.CenterVertically){

                Button(
                    onClick={
                        text = text+"4"
                        display_text= text
                    }
                ){
                    Text("4")
                }
                Button(
                    onClick={
                        text = text+"5"
                        display_text= text
                    }
                ){
                    Text("5")
                }
                Button(
                    onClick={
                        text = text+"6"
                        display_text= text
                    }
                ){
                    Text("6")
                }
                Button(
                    onClick={
                        num_one = text.toInt()
                        num_two = Check(num_two, num_one, operation)
                        operation ="-"
                        text=""
                    }
                ){
                    Text("-")
                }
                Button(
                    onClick={
                        if (text.length==0 || text =="0"){
                            text="1"
                        }
                        num_one = text.toInt()
                        num_two = Check(num_two, num_one, operation)
                        operation ="\\"
                        text=""
                    }
                ){
                    Text("\\")

                }

        }
        Row(verticalAlignment = Alignment.CenterVertically){

                Button(
                    onClick={
                        text = text+"7"
                        display_text= text
                    }
                ){
                    Text("7")
                }
                Button(
                    onClick={
                        text = text+"8"
                        display_text= text
                    }
                ){
                    Text("8")
                }
                Button(
                    onClick={
                        text = text+"9"
                        display_text= text
                    }
                ){
                    Text("9")
                }
                Button(
                    onClick={
                        num_two = Check(num_two, num_one, operation)
                        num_two = sqrt(num_two.toDouble()).toInt()
                    }
                ){
                    Text("      sqrt      ")
                }


        }
        Row(verticalAlignment = Alignment.CenterVertically){

                Button(
                    onClick={

                        if (text.length == 0){
                            text =text
                        }
                        else{
                            text = text+"0"
                        }
                        display_text= text
                    }
                ){
                    Text("         0         ")
                }
                Button(
                    onClick={}
                ){
                    Text(".")
                }
                Button(
                    onClick = {
                        num_one= text.toInt()
                        num_two = Check(num_two,num_one,operation)
                        text=num_two.toString()
                        //display_text= text
                        //text = ""

                    },

                ){
                    Text("         =         ")
                }


        }
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(
                text= "$text"
            )
        }

    }

}