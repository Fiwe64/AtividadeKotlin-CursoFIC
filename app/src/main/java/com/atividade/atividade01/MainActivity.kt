package com.atividade.atividade01

import androidx.compose.ui.semantics.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atividade.atividade01.ui.theme.Atividade01Theme

import kotlin.Int


/*Classe Principal*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //de ponta a ponta
        enableEdgeToEdge()
        setContent {
            Atividade01Theme {
                Surface {

                    //chamando a função da Atividade
                    botaoDecremento(100)
                }
            }
        }
    }
}


//componente criado usando o Composable para UI
@Composable
fun botaoDecremento(num: Int) {

    //variavel que vai mudar de Estado
    //serializa  o estado e restaura apos recreacoes
    var cont by rememberSaveable { mutableStateOf(num) }


//cria uma coluna
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),


        //centraliza o que esta dentro da coluna
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //texto dentro da função
        Text("Decrementador de numeros.")
        Spacer(Modifier.height(16.dp))
        Text("Valor do cont: $cont")



        //o botão que vai mudar o estado do contador.
        OutlinedButton(onClick = {
            if (cont > 0) {
                cont--
            }//fornece informacao semantica para acessibilidade
        }, modifier = Modifier.semantics {

            //descrição do conteudo
            contentDescription = "Botão para decrementar o contador"
        }) {
            Text(text = "-1")
        }
        if (cont == 0) {
            Spacer(Modifier.height(16.dp))
            Text("Acabou!!")
        } else if (cont % 10 == 0) {
            Spacer(Modifier.height(16.dp))
            Text("UAU!")


        }

        //fim da funcao
    }
}


//funcao de visualizacao previa
@Preview(showBackground = true)
@Composable
fun botaoDecrementoPreview() {
    Atividade01Theme {
        botaoDecremento(42)
    }
}
