package CEP.PolisTecnics.m13appandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import org.json.JSONArray
//
import android.app.Activity
import android.content.Intent
import android.net.Uri
//import android.os.Bundle
//import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
//import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader


class carregaJson : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    //declaro llistat d'elements LOCAL
    var elements = mutableListOf<Element>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrega_json)


        //String que contindrà el json, sense contingut, per a carregar-lo des de un arxiu
        val jsonString = String
        //val btnJson = findViewById<Button>(R.id.BtnJson)

            //inici codi chatgpt dialeg arxiu json part 2
            openFileButton = findViewById(R.id.openFileButton)

            openFileButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.type = "application/json"
                getContent.launch(intent)
            }

    }
    //inici codi chatgpt dialeg arxiu json part 1
    private lateinit var openFileButton: Button

    //funció getContent que llegirà el JSON i el desarà
    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    val inputStream = contentResolver.openInputStream(uri)
                    val reader = BufferedReader(InputStreamReader(inputStream))
                    val stringBuilder = StringBuilder()
                    var elementsLlegitsJson = 0
                    var llargadaJson = 0
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        stringBuilder.append(line).append("\n")
                    }

                    //l'arxiu json passa a l'string jsonString
                    val jsonString = stringBuilder.toString()

                    //intentem llegir l'string jsonString
                    try {
                        // Convertir el JSON string a un JSONArray
                        val jsonArray = JSONArray(jsonString)
                        llargadaJson = jsonArray.length()
                        Toast.makeText(this, "El JSON conté " + llargadaJson + " elements", Toast.LENGTH_SHORT).show()

                        // Iterar sobre cada objecte dins del JSONArray
                        for (i in 0 until llargadaJson) {
                            val jsonObject = jsonArray.getJSONObject(i)

                            // Obtenir els valors de cada propietat
                            val numeroInventari = jsonObject.getInt("NumeroInventari")
                            val ambit  = jsonObject.getString("Ambit")
                            val any = jsonObject.getInt("Any")
                            val autonomia = jsonObject.getInt("Autonomia")
                            val capacitatDiposit = jsonObject.getInt("CapacitatDiposit")
                            val cicleCA = jsonObject.getString("CicleCA")
                            val cicleES = jsonObject.getString("CicleES")
                            val cicleEN = jsonObject.getString("CicleEN")
                            val cilindrada = jsonObject.getInt("Cilindrada")
                            val descipcioCA =  jsonObject.getString("DescripcioCA")
                            val descripcioES = jsonObject.getString("DescripcioES")
                            val descripcioEN = jsonObject.getString("DescripcioEN")
                            val elementPerDefecte = jsonObject.getBoolean("ElementPerDefecte")
                            val envergadura = jsonObject.getInt("Envergadura")
                            val fontEnergiaCA = jsonObject.getString("FontEnergiaCA")
                            val fontEnergiaES = jsonObject.getString("FontEnergiaES")
                            val fontEnergiaEN = jsonObject.getString("FontEnergiaEN")
                            val fontIngresCA = jsonObject.getString("FontIngresCA")
                            val fontIngresES = jsonObject.getString("FontIngresES")
                            val fontIngresEN = jsonObject.getString("FontIngresEN")
                            val formaIngresCA = jsonObject.getString("FormaIngresCA")
                            val formaIngresES = jsonObject.getString("FormaIngresES")
                            val formaIngresEN = jsonObject.getString("FormaIngresEN")
                            try {
                                val imatge = jsonObject.getString("Imatge")//potser no es fa servir
                            }catch (e: Exception) {
                                e.printStackTrace()
                                val imatge = ""
                            }
                            //val imatge = jsonObject.getString("Imatge")//potser no es fa servir
                            val llocFabricacioCA = jsonObject.getString("LlocFabricacioCA")
                            val llocFabricacioES = jsonObject.getString("LlocFabricacioES")
                            val llocFabricacioEN = jsonObject.getString("LlocFabricacioEN")
                            val nomElementCA = jsonObject.getString("NomElementCA")
                            val nomElementES  = jsonObject.getString("NomElementES")
                            val nomElementEN  = jsonObject.getString("NomElementEN")
                            val longitud  = jsonObject.getInt("Longitud")
                            val pes  = jsonObject.getInt("Pes")
                            val potencia  = jsonObject.getInt("Potencia")
                            val kmsFets  = jsonObject.getInt("KmsFets")
                            val sostreMaximDeVol  = jsonObject.getInt("SostreMaximDeVol")
                            val velocitat  = jsonObject.getInt("Velocitat")
                            val velocitatMax  = jsonObject.getInt("VelocitatMax")

                            //afegeixo dades llegides al llistat d'elements LOCAL
                            elements.add(Element(
                                numeroInventari,
                                ambit,
                                any,
                                autonomia,
                                capacitatDiposit,
                                cicleCA,
                                cicleES,
                                cicleEN,
                                cilindrada,
                                descipcioCA, descripcioES, descripcioEN,
                                elementPerDefecte,
                                envergadura,
                                fontEnergiaCA, fontEnergiaES, fontEnergiaEN,
                                fontIngresCA,fontIngresES,fontIngresEN,
                                formaIngresCA,formaIngresES,formaIngresEN,
                                R.drawable.moto,//corregir, canviar per imatge definitiva
                                llocFabricacioCA,llocFabricacioES,llocFabricacioEN,
                                nomElementCA,nomElementES,nomElementEN,
                                longitud,
                                pes,
                                potencia,
                                kmsFets,
                                sostreMaximDeVol,
                                velocitat,
                                velocitatMax))
                            //FALTA assignar una imatge per defecte en cas que no en tingui una.

                            // Aquí pots fer el que vulguis amb les dades llegides
                            // Per exemple, emmagatzemar-les en una llista, mostrar-les en un log, etc.
                            // println("Element $i: NumeroInventari=$numeroInventari, Any=$any, Autonomia=$autonomia")
                            Toast.makeText(this,"Importat element " + (i+1) + ", número d'inventari " + numeroInventari + " amb denominació " + nomElementCA, Toast.LENGTH_SHORT).show()
                            elementsLlegitsJson++
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Toast.makeText(this,"Error de lectura del .JSON", Toast.LENGTH_LONG).show()
                    }
                    // Exemple: mostra el contingut llegit en el Logcat
                    //println(jsonString)
                    //Toast.makeText(this, jsonString, Toast.LENGTH_LONG).show()
                    Toast.makeText(this, "Importats " + elementsLlegitsJson + " de " + llargadaJson + " elements que conté el JSON", Toast.LENGTH_LONG).show()

                }
            }
            //buido el llistat d'elements GLOBAL
            ElementManager.elements.clear()
            //afegeixo el llistat d'elements LOCAL al llistat GLOBAL
            ElementManager.elements.addAll(elements)
        }
//fi codi chatgpt dialeg arxiu json part 1
}
