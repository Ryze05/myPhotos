package com.example.myphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myphotos.ui.theme.MyPhotosTheme
import coil.compose.rememberAsyncImagePainter

data class Data(
    val name: String,
    val url: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPhotosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/*val photos = listOf(
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image4,
    R.drawable.image5,
    R.drawable.image6,
    R.drawable.image7,
    R.drawable.image8
)*/

val photos = listOf(
    Data("Morella", "https://media.traveler.es/photos/613762aa06df43bef2d3016a/16:9/w_2560%2Cc_limit/195207.jpg"),
    Data("Playa Algarve", "https://www.algarveriders.com/es/docimg/1255/sd"),
    Data("Maldivas", "https://blackpepper.travel/cache/2024-01/blackpepper-viajes-maldivas-0003-galeria-2x-1008x671.jpg"),
    Data("Machu Pichu", "https://viajes.nationalgeographic.com.es/medio/2018/03/01/machu-picchu_5ff969ae_1280x720.jpg"),
    Data("Gran Muralla China", "https://hips.hearstapps.com/hmg-prod/images/william-olivieri-hwy9r6-yzgm-unsplash-1646657593.jpg?crop=0.666xw:1.00xh;0.0365xw,0&resize=1120:*"),
    Data("Alhambra", "https://www.dosde.com/discover/wp-content/uploads/2017/02/alhambra-de-granada-dosde-publishing.jpg"),
    Data("Atenas", "https://cdn-imgix.headout.com/blog-content/image/d2cfb372cf3a129c5ee7d6d3945d0580-AdobeStock_129050920%20copy.jpg?auto=format&w=695.0400000000001&h=434.4&q=120&crop=faces&fit=crop"),
    Data("Pirámide Kukulkan", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Chichen_Itza_3.jpg/1600px-Chichen_Itza_3.jpg"),
    Data("Punta Cana", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Playa_Bavaro.JPG/2560px-Playa_Bavaro.JPG")
)

@Composable
/*fun Greeting(name: String, modifier: Modifier = Modifier) {

    var fotoSeleccionada by remember { mutableStateOf<Int?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            LazyRow(
                contentPadding = PaddingValues(vertical = 20.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(photos) { photo ->

                    Image(
                        painter = painterResource(id = photo),
                        contentDescription = "User Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .clickable { fotoSeleccionada = photo }

                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (fotoSeleccionada != null) {
                    Image(
                        painter = painterResource(id = fotoSeleccionada!!),
                        contentDescription = "Foto",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(300.dp)
                    )
                } else {
                    Text(
                        text = "No hay imagen seleccionada",
                    )
                }
            }
        }
    }
}*/

fun Greeting(name: String, modifier: Modifier = Modifier) {

    var fotoSeleccionada by remember { mutableStateOf<Data?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            LazyRow(
                contentPadding = PaddingValues(vertical = 20.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(photos) { photo ->
                    Image(
                        painter = rememberAsyncImagePainter(photo.url),
                        contentDescription = photo.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .clickable { fotoSeleccionada = photo }
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (fotoSeleccionada != null) {
                    Image(
                        painter = rememberAsyncImagePainter(fotoSeleccionada!!.url),
                        contentDescription = fotoSeleccionada!!.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(300.dp)
                    )
                    Text(text = fotoSeleccionada!!.name, modifier = Modifier.padding(top = 8.dp))
                } else {
                    Text(
                        text = "No hay imagen seleccionada",
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyPhotosTheme {
        Greeting("Android")
    }
}