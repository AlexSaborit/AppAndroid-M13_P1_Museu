package CEP.PolisTecnics.m13appandroid

object ElementManager {
    //llistat d'objectes Element per a accedir-hi des de totes les classes
    val elements = mutableListOf<Element>()
    //Índex per al llistat elements, per localitzar un Element en particular (p.e. per mostrar a la pantalla de detalls del vehicle)
    val indexElements = Int
    //Definició d'idioma: 0 cat, 1 spa, 2 eng
    val idioma = Int
}