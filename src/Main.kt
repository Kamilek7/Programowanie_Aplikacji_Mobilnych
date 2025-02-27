fun main() {
    fun zad1()
    {
        fun podzielnosci(x: Int) : String
        {
            var text: String = ""
            for (i in 1..x)
            {
                var passed: Boolean = false
                if ((i%3)==0)
                {
                    text += "trzy"
                    passed = true
                }
                if ((i%5)==0)
                {
                    text += "piec"
                    passed = true
                }
                if ((i%7)==0)
                {
                    text += "siedem"
                    passed = true
                }
                if ((i%11)==0)
                {
                    text += "jedenascie"
                    passed = true
                }
                if ((i%13)==0)
                {
                    text += "trzynascie"
                    passed = true
                }
                if (!(passed))
                {
                    text += i
                }
                text+="\n"
            }

            return text
        }

        val num: Int = 1501
        println(podzielnosci(num))
    }

    fun zad2()
    {
        fun isPalindrome(str: String) : Boolean
        {
            if (str.reversed() == str)
                return true
            else
                return false
        }
        val str:String = "kamilślimak"
        println(isPalindrome(str))
    }

    fun zad3()
    {
        fun factorial(n: Int) : Int
        {
            if (n==0)
                return 1
            else if (n==1)
                return 1
            else
                return n*factorial(n-1)
        }
        fun pascal(h: Int) : String
        {
            var output : String = ""

            for (i in 0..h-1)
            {
                for (j in 1..h-i)
                {
                    output += " "
                }
                for (j in 0..i)
                {
                    output += factorial(i)/factorial(j)/factorial(i-j)
                    output += " "
                }
                output += "\n"
            }
            return output
        }
        println(pascal(5))
    }

    fun zad4()
    {
        fun szukajDzielnikow(n:Int): Array<Int>
        {
            var nums: Array<Int> = emptyArray()

            for (i in 2..n/2)
            {
                if ((n%i)==0)
                    nums += i
            }
            return nums

        }
        fun isPerfect(n: Int) : String
        {
            val dzielniki: Array<Int> = szukajDzielnikow(n)
            var suma:Int = 1
            for (i in dzielniki)
                suma += i
            if (suma<n)
                return "niedomiarowa"
            else if (suma>n)
                return "obfita"
            else
                return "doskonała"
        }
        println(isPerfect(12))
        println(isPerfect(28))
        println(isPerfect(8))
    }

    fun zad5()
    {
        fun szukajDzielnikow(n:Int): Array<Int>
        {
            var nums: Array<Int> = emptyArray()

            for (i in 2..n/2)
            {
                if ((n%i)==0)
                    nums += i
            }
            return nums

        }
        fun armstrong(n: Int) : Boolean
        {

            if (n<10)
                return true
            else
            {
                val strN :String = n.toString()
                var suma : Int = 0
                for (char in strN)
                {
                    var len:Int = strN.length
                    var potega : Int = 1
                    for (i in 1..len)
                        potega *= char.digitToInt()
                    suma+= potega
                }
                if (suma==n)
                    return true
                else
                    return false

            }
        }
        println(armstrong(9))
        println(armstrong(15))
        println(armstrong(153))
        println(armstrong(154))
    }

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
}