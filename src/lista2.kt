package lista2

fun <T> List<T>.head() : T
{
    return this[0]
}

fun <T> List<T>.tail() : List<T>
{
    var newList :List<T> = listOf<T>()
    val size:Int = this.size
    for (i in 1..size-1)
        newList += this[i]
    return newList
}

fun zad1()
{
    val r : (s: String, a: Int) -> String = {s, a ->
        var temp = "";
        for (i in 1..a)
        {temp+=s}
        temp;
    }
    println(r("a", 5))
}

fun zad2()
{


    println(listOf(1,2,3,4,5).head())
    println(listOf(1,2,3,4,5).tail())

}

fun zad3()
{
    fun <T> isSorted(lst: List<T>, order: (T,T) -> Boolean):Boolean
    {
        var out: Boolean = true
        val size:Int = lst.size
        for (i in 0..lst.size-2)
        {
            if (!order(lst[i], lst[i+1]))
            {
                out = false
                break
            }
        }
        return out
    }

    println(isSorted(listOf(1, 2, 3, 4), {i: Int, j: Int -> i < j}))
    println(isSorted(listOf(1, 1, 1, 1), {i: Int, j: Int -> i==j}))
    println(isSorted(listOf("ahyyhh", "bkjn", "cnn", "duu"), {i: String, j: String -> i.first() < j.first()}))

    println(isSorted(listOf(4, 3, 2, 1), {i: Int, j: Int -> i < j}))
    println(isSorted(listOf(1, 2, 3, 4), {i: Int, j: Int -> i==j}))
    println(isSorted(listOf("bhyyhh", "akjn", "dnn", "cuu"), {i: String, j: String -> i.first() < j.first()}))
}

fun zad4()
{

    fun <A> tailToHead(lst: List<A>): List<A>
    {
        return lst.tail() + lst.head()
    }
    println(tailToHead(listOf<Int>(1,2,3,4,5)))
}

fun zad5()
{
    fun <A> setHead(lst: List<A>, item: A): List<A>
    {
        return listOf<A>(item) + lst.tail()
    }
    println(setHead(listOf<Int>(1,2,3,4,5), 6))
}

fun zad7()
{
    fun check(amb:Int, _lst: List<Int>): Int
    {
        var lst: List<Int> = _lst
        var out: Int = -1
        var continueSearch = true
        while (continueSearch)
        {
            var ambule: List<Int>  = lst.take(amb)
            var num:Int = lst[amb]
            var result = false
            for (j in 0..amb-1)
            {
                for (k in 0..amb-1)
                {
                    if (k!=j)
                    {
                        if ((ambule[k]+ambule[j])==num)
                        {
                            result = true
                            break
                        }
                    }
                }
            }

            if (result)
            {

                lst = lst.tail()
                if (lst.size< amb+1)
                    continueSearch = false
            }
            else
            {
                out = num
                continueSearch = false
            }

        }


        return out
    }
    println(check(3, listOf(1, 2, 3, 5, 7, 12, 19)))
}

fun wypisz()
{
    println("\n\nLista 2\n")
    println("\nZadanie 1: \n")
    zad1()
    println("\nZadanie 2: \n")
    zad2()
    println("\nZadanie 3: \n")
    zad3()
    println("\nZadanie 4: \n")
    zad4()
    println("\nZadanie 5: \n")
    zad5()
    println("\nZadanie 7: \n")
    zad7()
}
