package ru.pfr.modules.xls_parser_fin_monitor

import org.apache.poi.ss.usermodel.Cell
import java.io.IOException
import java.io.Serializable

class Organization:Comparable<Organization>, Serializable {

    var regNumber:String = ""
    var orgName:String = ""


    //Временные массивы для заполнения данных
    var tempArray1: MutableList<String> = mutableListOf<String>("null","null","null","null")
    var tempArray2: MutableList<String> = mutableListOf<String>("null","null","null","null")
    var tempArray3: MutableList<String> = mutableListOf<String>("null","null","null","null")

    //Основные массивы с данными
     val arrayOfIntelligence = arrayListOf(listOf<String>())
     val arrayOfNotification = arrayListOf(listOf<String>())
     val arrayOfAppendix     = arrayListOf(listOf<String>())

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
    fun addToTempArrays(e:String, numArray:Int, cell: Cell){
        when (numArray) {
            1 -> {
                when (cell.columnIndex) {
                    3 -> {
                        if (e != null) {
                            tempArray1[0] = e
                        } else tempArray1[0] = "null"
                    }
                    4 -> {
                        if (e != null) {
                            tempArray1[1] = e
                        } else tempArray1[1] = "null"
                    }
                    5 -> {
                        if (e != null) {
                            tempArray1[2] = e
                        } else tempArray1[2] = "null"
                    }
                    6 -> {
                        if (e != null) {
                            tempArray1[3] = e
                        } else tempArray1[3] = "null"
                    }
                }
            }
            2 -> {
                when (cell.columnIndex) {
                    7 -> {
                        if (e != null) {
                            tempArray2[0] = e
                        } else tempArray2[0] = "null"
                    }
                    8 -> {
                        if (e != null) {
                            tempArray2[1] = e
                        } else tempArray2[1] = "null"
                    }
                    9 -> {
                        if (e != null) {
                            tempArray2[2] = e
                        } else tempArray2[2] = "null"
                    }
                    10 -> {
                        if (e != null) {
                            tempArray2[3] = e
                        } else tempArray2[3] = "null"
                    }
                }
            }
            3 -> {
                when (cell.columnIndex) {
                    11 -> {
                        if (e != null) {
                            tempArray3[0] = e
                        } else tempArray3[0] = "null"
                    }
                    12 -> {
                        if (e != null) {
                            tempArray3[1] = e
                        } else tempArray3[1] = "null"
                    }
                    13 -> {
                        if (e != null) {
                            tempArray3[2] = e
                        } else tempArray3[2] = "null"
                    }
                    14 -> {
                        if (e != null) {
                            tempArray3[3] = e
                        } else tempArray3[3] = "null"
                    }
                }
            }

            else -> throw IOException("""
                Ошибка в добавлении временного массива
            """.trimIndent())
        }
    }



    fun newTempArrays(){
        tempArray1 = mutableListOf<String>("null","null","null","null")
        tempArray2 = mutableListOf<String>("null","null","null","null")
        tempArray3 = mutableListOf<String>("null","null","null","null")
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
        if (arrayOfAppendix[0].isNullOrEmpty())  // Если первый элимент пуст добавить вместо него данные
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

    override fun compareTo(o:Organization):Int{
        return regNumber.compareTo(o.regNumber)
    }


}
