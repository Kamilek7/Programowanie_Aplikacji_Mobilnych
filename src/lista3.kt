package lista3

fun zad1()
{
    fun <A> findDuplicates(lst:List<A>) : List<A>
    {
        val set : Set<A> = lst.toSet()
        val lst1 : MutableList<A> = lst.toMutableList()
        for (el in set)
        {
            lst1.removeAt(lst1.indexOf(el))
        }
        val out: Set<A> = lst1.toSet()
        return out.toList()
    }
    val tab: List<Int> = listOf(0, 1, 1, 1, 4, 4, 4, 9, 3, 3, 3, 3, 3, 3)
    println(findDuplicates(tab))
}

fun zad2()
{
    fun addToBoolean() : Map<Int, Boolean>
    {
        return (1..20).toList().associateWith{it%2==0}
    }
    print(addToBoolean())
}

fun zad3()
{
    fun sumaDodatnich(lst: List<Int>): Int
    {
        return lst.filter{it>0}.sum()
    }
    println(sumaDodatnich(listOf(1,2,3,4,5,-1,-3,-5,0,-2)))
}
fun zad4()
{
    fun countElements(lst: List<List<String>>): MutableMap<String, Int>
    {

        var list: List<String> = lst.flatten()
        var listSet:Set<String> = list.toSet()
        var map: MutableMap<String, Int> = mutableMapOf()
        for (i in listSet)
            map[i] = list.filter{it==i}.size

        return map
    }
    println(countElements(listOf(listOf("a", "b", "c"), listOf("c", "d", "f"), listOf("d", "f", "g"))))
}
fun zad5()
{
    fun evenPositiveSquare(lst:List<Int>):List<Int>
    {
        return lst.filter{lst.indexOf(it)%2==1}.filter{it>0}.map{it*it}
    }
    println(evenPositiveSquare(listOf(1, 2, 3, 5, -6, -1, -1, 2, 3)))
}
fun zad6()
{

    fun perm(lst: List<Int>): List<List<Int>> {
        var set: Set<Int> = lst.toSet()
        if (set.isEmpty())
            return emptyList()
        fun nestedPerm(list: List<Int>): List<List<Int>> {
            if (list.isEmpty()) return listOf(emptyList())

            val result: MutableList<List<Int>> = mutableListOf()
            for (i in list) {
                nestedPerm(list - i).forEach {
                        item -> result.add(item + i)
                }
            }
            return result
        }

        return nestedPerm(set.toList())
    }

    println(perm(listOf(1,2,3)))

}
fun zad7()
{
    fun srt(lst:List<String>): List<Pair<String, List<String>>>
    {
        return (lst.sorted().filter{it.length%2==0}.groupBy{it.first().toString()}.toList())
    }
    println(    srt(listOf(
        "cherry",
        "blueberry",
        "citrus",
        "apple",
        "apricot",
        "banana",
        "coconut")
    ))
}
fun zad8()
{
    fun telConvert(word:String):String
    {
        val map = mapOf(
            "abc" to "2",
            "def" to "3",
            "ghi" to "4",
            "jkl" to "5",
            "mno" to "6",
            "pqrs" to "7",
            "tuv" to "8",
            "wxyz" to "9"
        )
        var res = ""
        for (i in word)
        {
            for (j in map.keys)
            {
                if (i in j)
                {
                    for (k in 0..(j.indexOf(i)))
                    {
                        res += map[j]
                    }
                }
            }
        }
        return res
    }
    println(telConvert("franek"))
    println(telConvert("kotlin"))
}
fun zad9()
{
    data class StudentScore(val name: String, val subject: String, val score: Int)
    fun analyzeResults(studentList: List<StudentScore>):Triple<Map<String, List<StudentScore>>, List<StudentScore>, List<String>>
    {
        return Triple(studentList.filter{it.score>=50}.groupBy{it.subject},studentList.filter{it.score<50}, studentList.associate{it.subject to "nic"}.keys.toList() - (studentList.filter{it.score<50}.associate{it.subject to "nic"}).keys.toList())
    }
    val students = listOf(
        StudentScore("Alice", "Math", 78),
        StudentScore("Bob", "Math", 45),
        StudentScore("Charlie", "Physics", 92),
        StudentScore("Dave", "Physics", 55),
        StudentScore("Eve", "Physics", 40),
        StudentScore("Frank", "CS", 60),
        StudentScore("Grace", "CS", 80),
    )
    val (passedBySubject, failed, subjectsAllPassed) = analyzeResults(students)

    println("Zdani studenci według przedmiotów: $passedBySubject")
    println("Niezdani studenci: $failed")
    println("Przedmioty, w których wszyscy zdali: $subjectsAllPassed")
}
fun zad10()
{
    data class Point(val x: Int, val y: Int)
    {
        operator fun plus(a: Point): Point
        {
            return Point(this.x+a.x,this.y+a.y)
        }
        operator fun plus(a: Int): Point
        {
            return Point(this.x+a,this.y+a)
        }
        operator fun minus(a: Point): Point
        {
            return Point(this.x-a.x,this.y-a.y)
        }
        operator fun times(a: Point): Point
        {
            return Point(this.x*a.x,this.y*a.y)
        }
        operator fun inc(): Point
        {
            return Point(this.x+1,this.y+1)
        }
        operator fun dec(): Point
        {
            return Point(this.x-1,this.y-1)
        }
        operator fun not(): Point
        {
            return Point(0-this.x,0-this.y)
        }
    }
    var p1 = Point(1, 1)
    var p2 = Point(2, 2)
    println(p1+p2)
    println(p1-p2)
    println(p1*p2)
    p1+=1
    println(p1)
    println(!p1)
    p1++
    println(p1)
    p1--
    println(p1)

    var p3 = Point(0,0)
    p3+=1
    println(p3)


}
fun wypisz()
{
    println("\n\nLista 3\n")
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
    println("\nZadanie 6: \n")
    zad6()
    println("\nZadanie 7: \n")
    zad7()
    println("\nZadanie 8: \n")
    zad8()
    println("\nZadanie 9: \n")
    zad9()
    println("\nZadanie 10: \n")
    zad10()
}