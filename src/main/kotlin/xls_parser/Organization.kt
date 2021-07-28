package ru.pfr.modules.xls_parser_fin_monitor

import java.io.IOException
import java.io.Serializable

class Organization{

    var regNumber:String = ""
    var orgName:String = ""

    //Временные массивы для заполнения данных
    var tempArray1 = mutableListOf<String>()
    var tempArray2 = mutableListOf<String>()
    var tempArray3 = mutableListOf<String>()

    //Основные массивы с данными
    private val arrayOfIntelligence = arrayListOf(listOf<String>())
    private val arrayOfNotification = arrayListOf(listOf<String>())
    private val arrayOfAppendix     = arrayListOf(listOf<String>())

    constructor()

    /**
     * Добавить данные в временный массив
     * @param e строка с данными
     * @param numArray номер временного массива (1..3)
     * */
    fun addToTempArrays(e:String, numArray:Int){
        when (numArray) {
            1 ->{
                if (e != null) {
                    tempArray1.add(e)
                } else tempArray1.add("null")
            }
            2 ->{
                if (e != null) {
                    tempArray2.add(e)
                } else tempArray2.add("null")
        }
            3 ->{
                if (e != null) {
                    tempArray3.add(e)
                } else tempArray3.add("null")
            }
            else -> throw IOException("""
                Ошибка в добавлении временного массива
            """.trimIndent())
        }
    }

    fun newTempArrays(){
        tempArray1 = mutableListOf<String>()
        tempArray2 = mutableListOf<String>()
        tempArray3 = mutableListOf<String>()
    }

    //Заменяет все три функции одной
    fun addToArrays(){

        // --Первый временный
        if (arrayOfIntelligence[0].isNullOrEmpty()) // Если первый элимент пуст добавить вместо него данные
            arrayOfIntelligence[0] = tempArray1   //Сделано для избавления от  пустых масивов
        else
            arrayOfIntelligence.add(tempArray1)

        // --Второй временный
        if (arrayOfNotification[0].isNullOrEmpty())  // Если первый элимент пуст добавить вместо него данные
            arrayOfNotification[0] = tempArray2 //Сделано для избавления от  пустых масивов
        else
            arrayOfNotification.add(tempArray2)

        // --Трейтий временный
        if (arrayOfAppendix[0].isEmpty())  // Если первый элимент пуст добавить вместо него данные
            arrayOfAppendix[0] = tempArray3 //Сделано для избавления от  пустых масивов
        else
            arrayOfAppendix.add(tempArray3)
    }

    override fun toString():String{
        return """
|$regNumber   $orgName 
| Массивы: 
|   1.- $arrayOfIntelligence 
|   2.- $arrayOfNotification 
|   3.- $arrayOfAppendix
|""".trimMargin()
    }

}
