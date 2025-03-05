package lista2

fun zad1()
{
    val r = {s: String, a: Int ->
        var temp = "";
        for (i in 1..a)
        {temp+=s}
        return temp}
    println(r("a", 5))
}

fun wypisz()
{
    println("\n\nLista 2\n")
    println("\nZadanie 1: \n")
    zad1()
}
