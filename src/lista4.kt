package lista4

import java.time.LocalDate
import java.time.Month
import kotlin.random.Random

enum class CostType(val costType: String) {
    REFUELING("Tankowanie"),
    SERVICE("Serwis"),
    PARKING("Parking"),
    INSURANCE("Ubezpieczenie"),
    TICKET("Mandat")
}

data class Cost (
    val type: CostType,
    val date: LocalDate,
    val amount: Int
)

data class Car (
    val name: String,
    val brand: String,
    val model: String,
    val yearOfProduction: Int,
    val costs: List<Cost>
)

object DataProvider {

    public fun  generalCosts(size: Int) = List(size) {
        Cost(
            CostType.values()[
                Random.nextInt(CostType.values().size)],
            LocalDate.of(
                2025,
                Random.nextInt(1,13),
                Random.nextInt(1,28)),
            Random.nextInt(5000)
        )
    }

    val cars = listOf(
        Car("Domowy", "Skoda", "Fabia", 2002, generalCosts(100)),
        Car("Służbowy", "BMW", "Coupe", 2015, generalCosts(50)),
        Car("Kolekcjonerski", "Fiat", "125p", 1985, generalCosts(10))
    )

}


fun zad1()
{
    fun groupedCostMap(lst :List<Cost>): Map<Month, List<Cost>>
    {
        return lst.sortedBy{it.date.month}.groupBy{it.date.month}
    }
    println(groupedCostMap(DataProvider.generalCosts(5)))
}

fun zad2()
{
    fun printCosts(lst:List<Cost>)
    {
        val newLst: Map<Month, List<Cost>> = lst.sortedBy{it.date}.groupBy{it.date.month}
        for (entries in newLst.entries.iterator())
        {
            println(entries.key)
            for (j in entries.value)
            {
                println("${j.date.dayOfMonth} ${j.type} ${j.amount} zł")
            }
            println("")
        }
    }
    printCosts(DataProvider.generalCosts(5))
}

fun zad3()
{
    fun getCarCosts(str:String): List<Pair<CostType,Int>>
    {
        val car: Car = DataProvider.cars.filter{it.name==str}[0]
        return car.costs.groupBy{it.type}.map { (key,value) -> key to value.sumOf{it.amount} }
    }
    fun printCarCosts(lst: List<Pair<CostType,Int>>)
    {
        for (pair in lst)
        {
            println("${pair.first} ${pair.second} zł")
        }
    }
    printCarCosts(getCarCosts("Domowy"))
}
fun zad4()
{
    fun getFullCosts(lst:List<Car>): Map<CostType, Int>
    {
        var maps: Map<CostType,List<Cost>> = mapOf()
        for (i in lst)
        {
            val temp: Map<CostType, List<Cost>> = (i.costs.groupBy { it.type })
            maps = (maps.keys + temp.keys).associateWith{listOf(maps[it], temp[it]).filterNotNull().flatten()}
        }
        val sums: Map<CostType, Int> = maps.map { (key,value) -> key to value.sumOf{it.amount} }.toMap()
        return sums
    }
    fun printFullCosts(map:Map<CostType, Int>)
    {
        for ((key, value) in map)
        {
            println("${key} : ${value}")
        }
    }
    printFullCosts(getFullCosts(DataProvider.cars))
}
fun wypisz()
{
    println("\n\nLista 4\n")
    println("\nZadanie 1: \n")
    zad1()
    println("\nZadanie 2: \n")
    zad2()
    println("\nZadanie 3: \n")
    zad3()
    println("\nZadanie 4: \n")
    zad4()

}