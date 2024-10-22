package com.example.probandobd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.probandobd.ui.theme.ProbandoBDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProbandoBDTheme {
                Boton()
            }
        }
    }
}


@Composable
@Preview
fun Boton() {

    var name by remember { mutableStateOf<String>("") }
    var selectedName by remember { mutableStateOf("") }
    var names by remember { mutableStateOf(listOf<String>()) }

    Column {

        TextField(
            value = name,
            onValueChange = { nombre ->
                name = nombre
            },
//            Ejemplo abreviado en Kotlin con el uso de it
//            equivalente a onValue de linea 42
//            onValueChange = {
//                name = it
//            }
            label = {
                Text("Ingrese un nombre")
            }
        )

        Spacer(modifier = Modifier.height(14.dp))


        Lista(names = names)

        Button(
            onClick = {
                if(name.isNotBlank()){
                    names = names + name
                    name = ""
                }
            }
        ){
            Text("Agregar un nuevo nombre")
        }

        if(names.isNotEmpty()){
            Button (
                onClick = {
                    selectedName = names.random()
                }
            ){
                Text("Seleccionar nombre al azar")
            }
        }

        if (selectedName.isNotBlank()){
            Text("El nombre seleccionado es : $selectedName")
        }

//      Ejemplo alternatuvi a if, se ejecuta aunque selectedName es blanco, pero reacciona a sus cmabios
//        selectedName.let {
//            Text("El nombre seleccionado es : $it")
//        }


    }
}

@Composable
fun Lista(
    modifier : Modifier = Modifier,
    names: List<String>
){
    Column{
        names.forEach{ name ->
            Box(
                modifier = Modifier.background(color = Color.LightGray)
            ){
                Text(name)
            }
        }
    }
}
